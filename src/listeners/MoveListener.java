// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


public class MoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e){
        Player plr = e.getPlayer();

        if (plr.getGameMode() != GameMode.CREATIVE) {
            if (!plr.getAllowFlight()) {
         Block block = plr.getLocation().subtract(0,1,0).getBlock();
                if (block.getType() != Material.AIR) {
                    plr.setAllowFlight(true);
                }
            }
        }
    }

    }


