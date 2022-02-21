// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

public class PlayerSwapHandItemsListener implements Listener {

    @EventHandler
    public void onPlayerSwapHandItem(PlayerSwapHandItemsEvent e){
        Player plr = e.getPlayer();

        if(plr.getGameMode() != GameMode.CREATIVE){
            e.setCancelled(true);
        }

    }
}
