// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void EntityDamage(EntityDamageEvent e){
        Player plr = (Player) e.getEntity();
        if(plr instanceof Player) {
            e.setCancelled(true);
        }
    }
}
