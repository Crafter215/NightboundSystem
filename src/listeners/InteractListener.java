// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static listeners.JoinListener.SpielerVersteckerName;
import static main.Main.ServerPrefix;
import static org.bukkit.ChatColor.*;

public class InteractListener implements Listener {
    public String SpielerAnzeigerName = GRAY + "Spieler verstecken:" + GREEN + " Ein";
    public static List<Player> PlayersHidden = new ArrayList<>();
    public HashMap<String, Long> cooldownsHider = new HashMap<>();
    int cooldownTimeHider = 3;
    @EventHandler
    public void InteractEvent(PlayerInteractEvent e){
        Player plr = e.getPlayer();

        //Anti Block interact
        if(plr.getGameMode() != GameMode.CREATIVE){
            if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                e.setCancelled(true);
                Location loc = new Location(e.getPlayer().getWorld(), e.getClickedBlock().getX()+ 0.5, e.getClickedBlock().getY() + 0.5, e.getClickedBlock().getZ() + 0.5);

                plr.spawnParticle(Particle.SMOKE_NORMAL,loc, 1,0,0,0,0);
                if(plr.getItemInHand().equals(Material.AIR)){
                    plr.sendMessage(ServerPrefix + RED + "Kein Zugriff!");
                }

            }

        }




    if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK  )){


        //Spieler Verstecker Cooldown//
        if(!cooldownsHider.containsKey(plr.getName())) {
            cooldownsHider.put(plr.getName(), System.currentTimeMillis() - cooldownTimeHider * 1000);
        }
            int secondsLeft = (int) (((cooldownsHider.get(plr.getName())/1000)+cooldownTimeHider) - (System.currentTimeMillis()/1000));
            if(secondsLeft <= 0) {

                //Spieler Verstecker//
                if (plr.getItemInHand().getItemMeta().getDisplayName().equals(SpielerVersteckerName)) {

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        plr.hidePlayer(all);
                    }

                    ItemStack SpielerAnzeiger = new ItemStack(Material.STICK);
                    ItemMeta SpielerAnzeigerMeta = SpielerAnzeiger.getItemMeta();
                    SpielerAnzeigerMeta.setDisplayName(SpielerAnzeigerName);
                    SpielerAnzeiger.setItemMeta(SpielerAnzeigerMeta);
                    plr.getInventory().setItem(7, SpielerAnzeiger);

                    PlayersHidden.add(plr);
                    plr.sendMessage(ServerPrefix + GREEN + "Alle Spieler werden jetzt versteckt!");

                    plr.playSound(plr.getLocation(),Sound.ITEM_ARMOR_EQUIP_CHAIN,1,1);

                    cooldownsHider.put(plr.getName(), System.currentTimeMillis());

                } else if (plr.getItemInHand().getItemMeta().getDisplayName().equals(SpielerAnzeigerName)) {

                    for (Player all : Bukkit.getOnlinePlayers()) {
                        plr.showPlayer(all);
                    }
                    ItemStack SpielerVerstecker = new ItemStack(Material.BLAZE_ROD);
                    ItemMeta SpielerVersteckerMeta = SpielerVerstecker.getItemMeta();
                    SpielerVersteckerMeta.setDisplayName(SpielerVersteckerName);
                    SpielerVerstecker.setItemMeta(SpielerVersteckerMeta);
                    plr.getInventory().setItem(7, SpielerVerstecker);

                    PlayersHidden.remove(plr);
                    plr.sendMessage(ServerPrefix + GREEN + "Alle Spieler werden jetzt angezeigt!");

                    cooldownsHider.put(plr.getName(), System.currentTimeMillis());

                    plr.playSound(plr.getLocation(),Sound.ITEM_ARMOR_EQUIP_CHAIN,1,1);
                }
            } else {
                switch (secondsLeft){
                    case 1:
                        plr.sendMessage(ServerPrefix + RED + "Du kannst das erst wieder in 1 Sekunde!");
                        break;
                    default:
                        plr.sendMessage(ServerPrefix + RED + "Du kannst das erst wieder in " + secondsLeft + " Sekunden!");
                        break;

                }

            }
            //Spieler Verstecker Ende//




      }
    }

}
