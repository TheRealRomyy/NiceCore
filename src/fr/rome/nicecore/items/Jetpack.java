package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class Jetpack {

    private final Main main;

    public Jetpack(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack jetpack = this.buildItem();
        ShapedRecipe jetpackRecipe = new ShapedRecipe(jetpack);
        jetpackRecipe.shape("BGB", "GEG", "BGB");

        jetpackRecipe.setIngredient('B', Material.EMERALD_BLOCK);
        jetpackRecipe.setIngredient('E', Material.ELYTRA);
        jetpackRecipe.setIngredient('G', Material.GOLDEN_APPLE);

        // Enregistrer le craft
        main.getServer().addRecipe(jetpackRecipe);
    };

    public void useItem() {
        ItemStack coal = new ItemStack(Material.COAL, 1);

        new BukkitRunnable() {
            public void run() {
                try {
                    Bukkit.getOnlinePlayers().forEach(player -> {
                        PlayerInventory inventory = player.getInventory();

                        if(!player.getGameMode().equals(GameMode.CREATIVE) && !player.getGameMode().equals(GameMode.SPECTATOR) && (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§aJetpack"))) {
                            if (inventory.containsAtLeast(coal, 1)) {
                                if(player.isFlying()) {
                                    inventory.removeItem(coal);
                                    player.updateInventory();
                                };
                            } else {
                                player.setAllowFlight(false);
                                player.setFlying(false);

                                main.getJetpackPlayers().remove(player);

                                player.sendMessage("§cVous n'avez pas assez de charbon !");
                                return;
                            }
                            if(!main.getJetpackPlayers().contains(player)) {
                                player.setAllowFlight(true);
                                player.setFlying(true);

                                main.getJetpackPlayers().add(player);
                            };
                        } else {

                            if(player.getGameMode().equals(GameMode.CREATIVE) || player.getGameMode().equals(GameMode.SPECTATOR)) return;

                            if(main.getJetpackPlayers().contains(player)) {
                                player.setAllowFlight(false);
                                player.setFlying(false);

                                main.getJetpackPlayers().remove(player);
                            };
                        };
                    });
                } catch(Exception ignored) {};
            };
        }.runTaskTimer(main, 0, 20);
    };

    public ItemStack buildItem() {

        ItemStack jetpack = new ItemStack(Material.ELYTRA, 1);
        ItemMeta jetpackM = jetpack.getItemMeta();
        jetpackM.setDisplayName("§aJetpack");
        jetpackM.setLore(Arrays.asList("§bUn jetpack pour voler", "§6Made by: Rome"));
        jetpack.setItemMeta(jetpackM);

        return jetpack;
    };

    public void giveItem(Player player) {
        ItemStack jetpack = this.buildItem();
        player.getInventory().addItem(jetpack);
    };
};
