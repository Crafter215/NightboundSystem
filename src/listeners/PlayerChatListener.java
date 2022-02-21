// -- Created by Crafter215#8445 -- //

package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;

import static listeners.JoinListener.scoreboards;


public class PlayerChatListener implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){
        Player plr = e.getPlayer();
        Scoreboard board = scoreboards.get(plr.getName());
        String prefix = board.getPlayerTeam(plr).getPrefix();
        System.out.println(prefix);
      e.setFormat(prefix + plr.getName() + ": " + e.getMessage());


    }

}
