// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntListener implements Listener {

    @EventHandler
    public void EntityDamageByEnt(EntityDamageByEntityEvent e){
           if(e.getDamager() instanceof Player){
               if(((Player) e.getDamager()).getGameMode() != GameMode.CREATIVE){
                   e.setCancelled(true);
               }
           }
    }
}
