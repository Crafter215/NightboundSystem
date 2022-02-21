// -- Created by Crafter215#8445 -- //

package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.Main.*;
import static org.bukkit.ChatColor.*;

public class TpoCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player plr = (Player) sender;
            if(plr.hasPermission("Nightbound.tpo")) {
                if(args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        if(!target.equals(plr)) {
                            plr.teleport(target);
                            plr.sendMessage(ServerPrefix + GREEN + "Du hast dich erfolgreich teleportiert!");
                        } else {
                            plr.sendMessage(ServerPrefix + RED + "Du kannst dich nicht zu dir selber teleportieren!");
                        }
                    } else {
                        plr.sendMessage(ServerPrefix + RED + "Der Spieler " + GOLD + args[0] + RED + " ist nicht online!");
                    }


                }else {

                    plr.sendMessage(getUsage(command));


                }



            }else {
                plr.sendMessage(NoPermissionsMessage);
            }




        }




        return true;
    }

}
