package fr.rome.nicecore.commands;

import fr.rome.nicecore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CooldownBypass implements CommandExecutor {

    private final Main main;

    public CooldownBypass(Main main) {
        this.main = main;
    };

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String prefix = main.getPrefix();

        if(!(sender instanceof Player)) {
            System.out.println("§cLa console ne peut pas executer cette commande !");
            return false;
        };

        Player player = (Player) sender;

        if(args.length == 0) {
            player.sendMessage(prefix + "§cVeuillez spécifier un argument !");
            return false;
        };

        if("feather".equals(args[0])) {
            main.getDoubleJumpCooldowns().remove(player);

            player.sendMessage(prefix + "§aVous n'êtes plus en cooldown sur le §6Feather Jump §a!");
        } else if("fireball".equals(args[0])) {
            main.getFireballShooterCooldowns().remove(player);

            player.sendMessage(prefix + "§aVous n'êtes plus en cooldown sur le §cFireball Launcher §a!");
        } else {
            player.sendMessage(prefix + "§cArgument incorrect. Veuillez faire §b/cc <feather/fireball>");

            return false;
        };
        return false;
    };
};