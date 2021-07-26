package fr.rome.nicecore.commands;

import fr.rome.nicecore.Main;
import fr.rome.nicecore.items.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemGive implements CommandExecutor {

    private final Main main;

    public ItemGive(Main main) {
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

        if ("chunk".equals(args[0])) {
            ChunkFinder chunkFinder = new ChunkFinder(main);
            chunkFinder.giveItem(player);

            return true;
        } else if("inv".equals(args[0])) {
            InvisibilyClock invisibilyClock = new InvisibilyClock(main);
            invisibilyClock.giveItem(player);

            return true;
        } else if("fireball".equals(args[0])) {
            FireballLauncher fireballLauncher = new FireballLauncher(main);
            fireballLauncher.giveItem(player);

            return true;
        } else if("feather".equals(args[0])) {
            Feather feather = new Feather(main);
            feather.giveItem(player);

            return true;
        } else if("detector".equals(args[0])) {
            Detector detector = new Detector(main);
            detector.giveItem(player);

            return true;
        } else if("bomb".equals(args[0])) {
            Bomb bomb = new Bomb(main);
            bomb.giveItem(player);

            return true;
        } else if("jetpack".equals(args[0])) {
            Jetpack jetpack = new Jetpack(main);
            jetpack.giveItem(player);

            return true;
        } else if("smoke".equals(args[0])) {
            Smoke smoke = new Smoke(main);
            smoke.giveItem(player);

            return true;
        } else {
            player.sendMessage(prefix + "§cArgument invalide ! Faites : /itemgive <chunk/inv/fireball/feather/detector/bomb/jetpack/smoke>");
            return false;
        }
    };
};
