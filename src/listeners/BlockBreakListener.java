// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import static main.Main.ServerPrefix;
import static org.bukkit.ChatColor.RED;


public class BlockBreakListener implements Listener {

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e){
        Player plr = e.getPlayer();

        if(plr.getGameMode() != GameMode.CREATIVE){
            e.setCancelled(true);
            Location loc = new Location(e.getPlayer().getWorld(), e.getBlock().getX()+ 0.5, e.getBlock().getY() + 0.5, e.getBlock().getZ() + 0.5);

            plr.spawnParticle(Particle.SMOKE_NORMAL,loc, 1,0,0,0,0);


            plr.sendMessage(ServerPrefix + RED + "Kein Zugriff!");

        }



    }
}
