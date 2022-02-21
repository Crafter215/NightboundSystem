package commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.Main.*;
import static org.bukkit.ChatColor.*;

public class AboutCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player plr = (Player) sender;
                if(args.length == 0) {
                    plr.sendMessage(GREEN + "--------");
                    plr.sendMessage(ServerPrefix + GRAY + "" + BOLD + "System");
                    plr.sendMessage(GRAY + "Version: " + getPlugin().getDescription().getVersion());
                    plr.sendMessage(GRAY + "Von Crafter_215 für" + BOLD + " Nightbound.de" + RESET + GRAY + " erstellt");
                    plr.sendMessage(GREEN + "--------");


                }else {

                    plr.sendMessage(getUsage(command));

                }





        }




        return true;
    }

}