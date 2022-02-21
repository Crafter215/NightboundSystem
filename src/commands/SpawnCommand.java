// -- Created by Crafter215#8445 -- //

package commands;

import main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static main.Main.*;
import static org.bukkit.ChatColor.GREEN;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player plr = (Player) sender;
            if(plr.hasPermission("Nightbound.day")) {
                if(args.length == 0) {
                    FileConfiguration config = Main.getPlugin().getConfig();
                    World world = Bukkit.getWorld(config.getString("Spawn.World"));
                    double x = config.getDouble("Spawn.X");
                    double y = config.getDouble("Spawn.Y");
                    double z = config.getDouble("Spawn.Z");
                    float yaw = (float) config.getDouble("Spawn.Yaw");
                    float pitch = (float) config.getDouble("Spawn.Pitch");
                    Location location = new Location(world, x, y, z, yaw, pitch);

                    plr.teleport(location);
                    plr.sendMessage(ServerPrefix + GREEN + "Du wurdest zum Spawn teleportiert!");
                    plr.playSound(plr.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT, 1, 2);

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
