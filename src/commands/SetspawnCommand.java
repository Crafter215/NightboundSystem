// -- Created by Crafter215#8445 -- //

package commands;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static main.Main.*;
import static org.bukkit.ChatColor.GREEN;

public class SetspawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player plr = (Player) sender;
            if(plr.hasPermission("Nightbound.day")) {
                if(args.length == 0) {

                    FileConfiguration config = Main.getPlugin().getConfig();
                    config.set("Spawn.World", plr.getWorld().getName());
                    config.set("Spawn.X", plr.getLocation().getX());
                    config.set("Spawn.Y", plr.getLocation().getY());
                    config.set("Spawn.Z", plr.getLocation().getZ());
                    config.set("Spawn.Yaw", plr.getLocation().getYaw());
                    config.set("Spawn.Pitch", plr.getLocation().getPitch());
                    Main.getPlugin().saveConfig();

                    plr.sendMessage(ServerPrefix + GREEN + "Der Spawnpunkt wurde erfolgreich gesetzt!");

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
