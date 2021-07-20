package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Feather {

    private final Main main;

    public Feather(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack feather = this.buildItem();
        ShapedRecipe featherRecipe = new ShapedRecipe(feather);
        featherRecipe.shape("AFA", "ADA", "EEE");

        featherRecipe.setIngredient('A', Material.AIR);
        featherRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        featherRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        featherRecipe.setIngredient('F', Material.FEATHER);

        // Enregistrer le craft
        main.getServer().addRecipe(featherRecipe);
    };

    public ItemStack buildItem() {

        ItemStack feather = new ItemStack(Material.FEATHER, 1);
        ItemMeta featherM = feather.getItemMeta();
        featherM.setDisplayName("§eFeather Jump");
        featherM.setLore(Arrays.asList("§bUne plume pour faire des doubles sauts", "§6Made by: Rome"));
        feather.setItemMeta(featherM);

        return feather;
    };

    public void giveItem(Player player) {
        ItemStack feather = this.buildItem();
        player.getInventory().addItem(feather);
    };
}
