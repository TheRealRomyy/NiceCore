package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Detector {

    private final Main main;

    public Detector(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack detector = this.buildItem();
        ShapedRecipe detectorRecipe = new ShapedRecipe(detector);
        detectorRecipe.shape("ADA", "CXC", "AEA");

        detectorRecipe.setIngredient('A', Material.AIR);
        detectorRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        detectorRecipe.setIngredient('C', Material.COMPASS);
        detectorRecipe.setIngredient('X', Material.IRON_AXE);
        detectorRecipe.setIngredient('E', Material.EMERALD_BLOCK);

        // Enregistrer le craft
        main.getServer().addRecipe(detectorRecipe);
    };

    public ItemStack buildItem() {

        ItemStack detector = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta detectorM = detector.getItemMeta();
        detectorM.setDisplayName("§6Player Detector");
        detectorM.setLore(Arrays.asList("§bUn detecteur de joueur", "§6Made by: Rome"));
        detector.setItemMeta(detectorM);

        return detector;
    };

    public void giveItem(Player player) {
        ItemStack detector = this.buildItem();
        player.getInventory().addItem(detector);
    };
};
