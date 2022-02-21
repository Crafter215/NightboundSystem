// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player plr = (Player) e.getClickedInventory().getHolder();
        if(plr.getGameMode() != GameMode.CREATIVE){
            e.setCancelled(true);
        }
    }
}
