// -- Created by Crafter215#8445 -- //

package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.Main.*;
import static org.bukkit.ChatColor.GREEN;
import static org.bukkit.ChatColor.RED;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player plr = (Player) sender;
            if(plr.hasPermission("Nightbound.fly")){
                if(args.length == 0) {
                    plr.setAllowFlight(!plr.getAllowFlight());
                    if(plr.getAllowFlight()){
                        plr.sendMessage(ServerPrefix + GREEN + "Du kannst nun fliegen!");
                    } else {
                        plr.sendMessage(ServerPrefix + RED + "Du kannst nun nicht mehr fliegen!");
                    }
                } else {
                    plr.sendMessage(getUsage(command));
                }
            } else {
                plr.sendMessage(NoPermissionsMessage);
            }

        }

        return true;
    }

}
