// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntityListener implements Listener {

    @EventHandler
    public void EntityInteract(PlayerInteractEntityEvent e){
        if (e.getRightClicked().getType().equals(EntityType.ITEM_FRAME)) {
            if(e.getPlayer().getGameMode() != GameMode.CREATIVE){
                e.setCancelled(true);
            }
        }
    }
}
