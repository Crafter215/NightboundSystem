// -- Created by Crafter215#8445 -- //

package main;

import commands.*;
import listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import static org.bukkit.ChatColor.*;

public class Main extends JavaPlugin {

    private static Main plugin;
    @Override
    public void onEnable() {
        plugin = this;
            
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("tpo").setExecutor(new TpoCommand());
        getCommand("tpohere").setExecutor(new TpohereCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("setspawn").setExecutor(new SetspawnCommand());
        getCommand("about").setExecutor(new AboutCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new LeaveListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new InteractListener(), this);
        pluginManager.registerEvents(new PlayerInteractEntityListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new EntityDamageByEntListener(), this);
        pluginManager.registerEvents(new FlightListener(), this);
        pluginManager.registerEvents(new MoveListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new PlayerDropItemListener(), this);
        pluginManager.registerEvents(new PlayerSwapHandItemsListener(), this);
        pluginManager.registerEvents(new PlayerChatListener(), this);

    }

    public static Main getPlugin(){
        return plugin;
    }

    public static String ServerPrefix = "§8[§1§lNight§b§lBound§8]§7 ";

    public static String NoPermissionsMessage = ServerPrefix + RED + "Dir fehlen die benötigten Rechte!";

    public static String getUsage(Command command){
        return ServerPrefix + RED + "Bitte benutze: " + GOLD + command.getUsage();
    }

    @Override
    public void onDisable() {

        for(Player all : Bukkit.getOnlinePlayers()){
            all.kickPlayer(ServerPrefix + "Der Server wird neugestartet.");
        }


    }


}
