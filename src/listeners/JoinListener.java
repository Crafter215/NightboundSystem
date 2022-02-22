// -- Created by Crafter215#8445 -- //

package listeners;

import main.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


import static listeners.InteractListener.PlayersHidden;
import static main.Main.ServerPrefix;
import static main.Main.updateScoreboard;
import static org.bukkit.ChatColor.*;
import static util.scoreboardUtil.setScoreboard;


public class JoinListener implements Listener {

    public static String SpielerVersteckerName = GRAY + "Spieler verstecken:" + DARK_RED + " Aus";
    public static HashMap<String, Scoreboard> scoreboards = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){


        Player plr = e.getPlayer();
        e.setJoinMessage(ServerPrefix + GOLD + plr.getName() + GREEN + " hat den Server betreten!");

        //Spawn
        FileConfiguration config = Main.getPlugin().getConfig();

        World world = Bukkit.getWorld(config.getString("Spawn.World"));
        double x = config.getDouble("Spawn.X");
        double y = config.getDouble("Spawn.Y");
        double z = config.getDouble("Spawn.Z");
        float yaw = (float) config.getDouble("Spawn.Yaw");
        float pitch = (float) config.getDouble("Spawn.Pitch");

        Location location = new Location(world, x, y, z, yaw, pitch);

        plr.teleport(location);

        //Clear Inventory [[
        plr.setGameMode(GameMode.SURVIVAL);
        PlayerInventory playerInv = plr.getInventory();

        playerInv.clear();
        playerInv.setHelmet(new ItemStack(Material.AIR));
        playerInv.setChestplate(new ItemStack(Material.AIR));
        playerInv.setLeggings(new ItemStack(Material.AIR));
        playerInv.setBoots(new ItemStack(Material.AIR));


        // Set Player Health & Food
        plr.setMaxHealth(6);
        plr.setHealth(6);

        //XP-Bar
        plr.setLevel(Calendar.getInstance().get(Calendar.YEAR));
        int day = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
        float timePercent = (float)day / 365;
        plr.setExp(timePercent);

        //Doublejump
        plr.setAllowFlight(true);


        //Navigator
        ItemStack Compass = new ItemStack(Material.COMPASS);
        ItemMeta CompassMeta = Compass.getItemMeta();
        CompassMeta.setDisplayName(GOLD + "" + BOLD + "Navigator");
        Compass.setItemMeta(CompassMeta);
        plr.getInventory().setItem(4,Compass);

        //Spielerverstecker
        ItemStack SpielerVerstecker = new ItemStack(Material.BLAZE_ROD);
        ItemMeta SpielerVersteckerMeta = SpielerVerstecker.getItemMeta();
        SpielerVersteckerMeta.setDisplayName(SpielerVersteckerName);
        SpielerVerstecker.setItemMeta(SpielerVersteckerMeta);
        plr.getInventory().setItem(7,SpielerVerstecker);

        //Kommt bald
        ItemStack KommtBald = new ItemStack(Material.BLAZE_POWDER);
        ItemMeta KommtBaldMeta = KommtBald.getItemMeta();
        KommtBaldMeta.setDisplayName(RED + "" + BOLD + "Kommt bald!");
        KommtBald.setItemMeta(KommtBaldMeta);
        plr.getInventory().setItem(1,KommtBald);

        //Spielerverstecker
        for(Player all : PlayersHidden){
            all.hidePlayer(plr);
        }

        //Join Sound
        plr.playSound(plr.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 1,1);

        //Scoreboard
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = board.registerNewObjective("abcd", "abcd");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        setScoreboard(plr, board);

        objective.setDisplayName("§1§lNight§b§lBound");
        objective.getScore("§4 ").setScore(14);
        objective.getScore("§3§l» Server:").setScore(13);
        objective.getScore(GOLD + Bukkit.getServerName()).setScore(12);
        objective.getScore("§7 ").setScore(11);
        objective.getScore("§3§l» Dein Rang:").setScore(10);
        String Prefix = board.getPlayerTeam(plr).getPrefix();
        objective.getScore(Prefix.substring(0, Prefix.length()-4)).setScore(9);
        objective.getScore("§6 ").setScore(8);
        objective.getScore("§3§l» Online:").setScore(7);
        objective.getScore( Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()).setScore(6);
        objective.getScore("§5 ").setScore(5);
        objective.getScore("§3§l» Kontostand:").setScore(4);
        objective.getScore("0$").setScore(3);
        objective.getScore("§l ").setScore(2);

        updateScoreboard(Bukkit.getOnlinePlayers().size() - 1, Bukkit.getOnlinePlayers().size());




    }

}
