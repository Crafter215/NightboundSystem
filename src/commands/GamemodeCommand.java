// -- Created by Crafter215#8445 -- //

package commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static main.Main.*;
import static net.md_5.bungee.api.ChatColor.GOLD;
import static net.md_5.bungee.api.ChatColor.RED;
import static org.bukkit.ChatColor.GREEN;

public class GamemodeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player plr = (Player) sender;
                if(args.length == 1) {

                    switch(args[0]){

                        case "0":
                            if(plr.hasPermission("Nightbound.gm.0") || plr.hasPermission("Nightbound.gm.all")) {
                                if (!plr.getGameMode().equals(GameMode.SURVIVAL)) {
                                    plr.setGameMode(GameMode.SURVIVAL);
                                    plr.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Überlebensmodus!");
                                } else {
                                    plr.sendMessage(ServerPrefix + RED + "Du befindest dich bereits in diesem Spielmodus!");
                                }
                            } else {
                                plr.sendMessage(NoPermissionsMessage);
                            }
                            break;
                        case "1":
                            if(plr.hasPermission("Nightbound.gm.1") || plr.hasPermission("Nightbound.gm.all")) {
                                if (!plr.getGameMode().equals(GameMode.CREATIVE)) {
                                    plr.setGameMode(GameMode.CREATIVE);
                                    plr.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Kreativmodus!");
                                } else {
                                    plr.sendMessage(ServerPrefix + RED + "Du befindest dich bereits in diesem Spielmodus!");
                                }
                            } else {
                                plr.sendMessage(NoPermissionsMessage);
                            }
                            break;
                        case "2":
                            if(plr.hasPermission("Nightbound.gm.2")) {
                                if (!plr.getGameMode().equals(GameMode.ADVENTURE) || plr.hasPermission("Nightbound.gm.all")) {
                                    plr.setGameMode(GameMode.ADVENTURE);
                                    plr.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Abenteuermodus!");
                                } else {
                                    plr.sendMessage(ServerPrefix + RED + "Du befindest dich bereits in diesem Spielmodus!");
                                }
                            } else {
                                plr.sendMessage(NoPermissionsMessage);
                            }
                            break;
                        case "3":
                            if(plr.hasPermission("Nightbound.gm.3") || plr.hasPermission("Nightbound.gm.all")) {
                                if (!plr.getGameMode().equals(GameMode.SPECTATOR)) {
                                    plr.setGameMode(GameMode.SPECTATOR);
                                    plr.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Zuschauermodus!");
                                } else {
                                    plr.sendMessage(ServerPrefix + RED + "Du befindest dich bereits in diesem Spielmodus!");
                                }
                            } else {
                                plr.sendMessage(NoPermissionsMessage);
                            }
                            break;
                        default:
                            plr.sendMessage(getUsage(command));


                    }

                }else if(args.length == 2) {
                    if(plr.hasPermission("Nightbound.gm.admin")) {
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {

                            switch (args[0]) {

                                case "0":
                                    if (!target.getGameMode().equals(GameMode.SURVIVAL)) {
                                        target.setGameMode(GameMode.SURVIVAL);
                                        target.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Überlebensmodus!");
                                        plr.sendMessage(ServerPrefix + GREEN + "Der Spielmodus des Spielers wurde erfolgreich aktualisiert!");
                                    } else {
                                        plr.sendMessage(ServerPrefix + RED + "Der Spieler befindet sich bereits in diesem Spielmodus!");
                                    }
                                    break;
                                case "1":
                                    if (!target.getGameMode().equals(GameMode.CREATIVE)) {
                                        target.setGameMode(GameMode.CREATIVE);
                                        target.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Kreativmodus!");
                                        plr.sendMessage(ServerPrefix + GREEN + "Der Spielmodus des Spielers wurde erfolgreich aktualisiert!");
                                    } else {
                                        plr.sendMessage(ServerPrefix + RED + "Der Spieler befindet sich bereits in diesem Spielmodus!");
                                    }
                                    break;
                                case "2":
                                    if (!target.getGameMode().equals(GameMode.ADVENTURE)) {
                                        target.setGameMode(GameMode.ADVENTURE);
                                        target.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Abenteuermodus!");
                                        plr.sendMessage(ServerPrefix + GREEN + "Der Spielmodus des Spielers wurde erfolgreich aktualisiert!");
                                    } else {
                                        plr.sendMessage(ServerPrefix + RED + "Der Spieler befindet sich bereits in diesem Spielmodus!");
                                    }
                                    break;
                                case "3":
                                    if (!target.getGameMode().equals(GameMode.SPECTATOR)) {
                                        target.setGameMode(GameMode.SPECTATOR);
                                        target.sendMessage(ServerPrefix + GREEN + "Du befindest dich nun im " + GOLD + "Zuschauermodus!");
                                        plr.sendMessage(ServerPrefix + GREEN + "Der Spielmodus des Spielers wurde erfolgreich aktualisiert!");
                                    } else {
                                        plr.sendMessage(ServerPrefix + RED + "Der Spieler befindet sich bereits in diesem Spielmodus!");
                                    }
                                    break;
                                default:
                                    plr.sendMessage(getUsage(command));

                            }


                        } else {
                            plr.sendMessage(ServerPrefix + RED + "Der Spieler " + GOLD + args[1] + RED + " ist nicht online!");
                        }


                    } else {
                        plr.sendMessage(NoPermissionsMessage);
                    }

                } else {
                    plr.sendMessage(getUsage(command));
                }







        }

        return true;
    }

}
