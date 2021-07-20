package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class FireballLauncher {

    private final Main main;

    public FireballLauncher(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack fireballLauncher = this.buildItem();
        ShapedRecipe fireballLauncherRecipe = new ShapedRecipe(fireballLauncher);
        fireballLauncherRecipe.shape("AGA", "BDB", "AMA");

        fireballLauncherRecipe.setIngredient('A', Material.AIR);
        fireballLauncherRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        fireballLauncherRecipe.setIngredient('B', Material.BLAZE_ROD);
        fireballLauncherRecipe.setIngredient('G', Material.GHAST_TEAR);
        fireballLauncherRecipe.setIngredient('M', Material.MAGMA_CREAM);

        // Enregistrer le craft
        main.getServer().addRecipe(fireballLauncherRecipe);
    };

    public ItemStack buildItem() {

        ItemStack fireballLauncher = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta fireballLauncherM = fireballLauncher.getItemMeta();
        fireballLauncherM.setDisplayName("§cFireball Launcher");
        fireballLauncherM.setLore(Arrays.asList("§bUn lanceur de fireballs", "§6Made by: Rome"));
        fireballLauncher.setItemMeta(fireballLauncherM);

        return fireballLauncher;
    };

    public void giveItem(Player player) {
        ItemStack fireballLauncher = this.buildItem();
        player.getInventory().addItem(fireballLauncher);
    };
}
