// -- Created by Crafter215#8445 -- //

package util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

import static listeners.JoinListener.scoreboards;


public class scoreboardUtil {

    public static void setScoreboard(Player plr, Scoreboard scoreboard){

        scoreboard.registerNewTeam("000Admin");

        scoreboard.getTeam("000Admin").setPrefix("§4Admin §7» ");
        scoreboards.put(plr.getName(),scoreboard);
        for(Player all : Bukkit.getOnlinePlayers()){
            setTeams(all);
        }
    }

    public static void setTeams(Player plr){
        String team = "";

        Scoreboard board = scoreboards.get(plr.getName());
        for(Player all: Bukkit.getOnlinePlayers()) {
            if (all.hasPermission("rank.admin")) {
                team = "000Admin";
            }
            board.getTeam(team).addPlayer(all);
        }
        plr.setScoreboard(board);


    }
}
