package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemManager {

    private Main main;

    public ItemManager(Main main) {
        this.main = main;
    };

    public void manage() {
        ChunkFinder chunkfinder = new ChunkFinder(main);
        chunkfinder.addCraft();

        EmeraldArmor emeraldArmor = new EmeraldArmor(main);
        emeraldArmor.addCraft();

        InvisibilyClock invisibilyClock = new InvisibilyClock(main);
        invisibilyClock.addCraft();

        FireballLauncher fireballLauncher = new FireballLauncher(main);
        fireballLauncher.addCraft();

        Feather feather = new Feather(main);
        feather.addCraft();

        this.manageInvisibilityCloack();
    };

    public void manageInvisibilityCloack() {

        new BukkitRunnable() {
            public void run() {
                try {
                    main.setTotalSeconds(main.getTotalSeconds()+1.0);
                    if(main.getInvisiblePlayers().size() != 0) main.getInvisiblePlayers().forEach(player -> {
                        if (player.getInventory().getChestplate() == null || !player.getInventory().getChestplate().hasItemMeta() || (player.getInventory().getChestplate().hasItemMeta() && !player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§6Invisibility Cloack"))) {
                            main.getInvisiblePlayers().remove(player);
                            for (Player pl : Bukkit.getOnlinePlayers()) {
                                pl.showPlayer(player);
                            };
                        } else if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§6Invisibility Cloack")) {
                            // If player wear cloack, remove 1 to durability
                            player.getInventory().getChestplate().setDurability((short) (player.getInventory().getChestplate().getDurability() + 1));

                            // Remove chestplate if his durability is 0
                            if(player.getInventory().getChestplate().getDurability() == 80) player.getInventory().setChestplate(null);
                        };
                    });
                } catch(Exception ignored) {};
            };
        }.runTaskTimer(main, 0, 20);
    };
};
