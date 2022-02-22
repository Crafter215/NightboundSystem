// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import static listeners.InteractListener.PlayersHidden;
import static listeners.JoinListener.scoreboards;
import static main.Main.ServerPrefix;
import static main.Main.updateScoreboard;
import static org.bukkit.ChatColor.GOLD;
import static org.bukkit.ChatColor.RED;


public class LeaveListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerQuitEvent e){
        Player plr = e.getPlayer();

        PlayersHidden.remove(plr);
        e.setQuitMessage(ServerPrefix + GOLD + plr.getName() + RED + " hat den Server verlassen!");
        scoreboards.remove(plr.getName());

        updateScoreboard(Bukkit.getOnlinePlayers().size(), Bukkit.getOnlinePlayers().size() - 1);

    }

}
