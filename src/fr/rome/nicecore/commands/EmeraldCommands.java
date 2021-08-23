package fr.rome.nicecore.commands;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class EmeraldCommands implements CommandExecutor {

    private final Main main;

    public EmeraldCommands(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(label.equalsIgnoreCase("leaderboard")) {

            final File file = new File("NiceCore/emeralds.yml");
            final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
            AtomicInteger count = new AtomicInteger();

            if(sender instanceof Player) {
                Player player = (Player) sender;

                if(config.getKeys(false).size() == 0) {
                    player.sendMessage("§cIl n'y a aucun joueurs possédant des emeraudes !");
                    return false;
                }

                player.sendMessage("------------ §aEMERALD TOP §r------------");
                config.getConfigurationSection("emeralds")
                        .getValues(false)
                        .entrySet()
                        .stream()
                        .sorted((a1, a2) -> {
                            int a1V = (int) a1.getValue();
                            int a2V = (int) a2.getValue();

                            return a1V - a2V;
                        })
                        .limit(10)
                        .forEach(r -> {
                            count.getAndIncrement();
                            int emeralds = (int) r.getValue();
                            String name = r.getKey();

                            player.sendMessage(count + ")" + " §a" + name + "§r -> §d" + emeralds + " §r emeraudes");
                        });
                player.sendMessage("-------------------------------------");

                return true;
            } else {

                if(config.getKeys(false).size() == 0) {
                    System.out.println("Il n'y a aucun joueurs possédant des emeraudes !");
                    return false;
                }

                System.out.println("------------ EMERALD TOP ------------");
                config.getConfigurationSection("Emeralds")
                        .getValues(false)
                        .entrySet()
                        .stream()
                        .sorted((a1, a2) -> {
                            int a1V = (int) a1.getValue();
                            int a2V = (int) a2.getValue();

                            return a1V - a2V;
                        })
                        .limit(10)
                        .forEach(r -> {
                            count.getAndIncrement();
                            int emeralds = (int) r.getValue();
                            String name = r.getKey();

                            System.out.println(count + ")" + " " + name + " -> " + emeralds + " emeraudes");
                        });
                System.out.println("-------------------------------------");

                return true;
            }
        } else if(label.equalsIgnoreCase("add-emerald")) {

            if(sender instanceof Player) {
                Player player = (Player) sender;

                if(args.length == 0) {
                    player.sendMessage("Usage incorrect ! Fais §c/add-emerald <hand/inv>");
                    return false;
                }

                String group = "Unknow";
                String mode = "Unknow";

                final File file = new File(main.getDataFolder(), "NiceCore/emeralds.yml");
                final YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

                if (player.hasPermission("emerald.e1")) { group = "e1"; }
                else if (player.hasPermission("emerald.e2")) { group = "e2"; }
                else if (player.hasPermission("emerald.e3")) { group = "e3"; }
                else if (player.hasPermission("emerald.e4")) { group = "e4"; }
                else if (player.hasPermission("emerald.e5")) { group = "e5"; }
                else if (player.hasPermission("emerald.e6")) { group = "e6"; }

                if(group.equals("Unknow")) {
                    player.sendMessage("§cTu n'appartiens a aucune équipe !");
                    return false;
                }

                if(args[0].equalsIgnoreCase("hand")) { mode = "hand"; }
                else if(args[0].equalsIgnoreCase("inv")) { mode = "inv"; }

                if(mode.equals("Unknow")) {
                    player.sendMessage("Usage incorrect ! Fais §c/add-emerald <hand/inv>");
                    return false;
                }

                if(mode.equals("hand")) {
                    ItemStack itemInHand = player.getItemInHand();

                    if(itemInHand.getType() != Material.EMERALD) {
                        player.sendMessage("§cVous n'avez pas d'émeraudes en main !");
                        return false;
                    }

                    int emeraldAmount = itemInHand.getAmount();
                    player.setItemInHand(null);

                    if(config.get("players." + player.getName()) != null) emeraldAmount += (int) config.get("players." + player.getName());

                    config.set("players." + player.getName(), emeraldAmount);

                    try {
                        config.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    player.sendMessage("Tu as bien déposé §a" + emeraldAmount + " §rémeraudes  en banque !");
                    return true;
                }

                return true;
            } else {
                System.out.println("La console ne peut pas faire ca !");
                return false;
            }

        }

        return false;
    }
}
