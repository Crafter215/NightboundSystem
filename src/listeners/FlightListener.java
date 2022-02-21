// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;


public class FlightListener implements Listener {

    @EventHandler
    public void FlyListener(PlayerToggleFlightEvent e){
        Player plr = e.getPlayer();

        if(plr.getGameMode() != GameMode.CREATIVE){
                  e.setCancelled(true);
                Vector v = plr.getLocation().getDirection().multiply(1).setY(1);
                plr.setVelocity(v);
                plr.setAllowFlight(false);
                plr.playSound(plr.getLocation(), Sound.ENTITY_FIREWORK_LAUNCH, 1, 1);
                e.setCancelled(true);

        }


    }
}
