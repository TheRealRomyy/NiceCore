package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Smoke {

    private final Main main;

    public Smoke(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack smoke = this.buildItem();
        ShapedRecipe smokeRecipe = new ShapedRecipe(smoke);
        smokeRecipe.shape("AEA", "GPG", "AEA");

        smokeRecipe.setIngredient('A', Material.AIR);
        smokeRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        smokeRecipe.setIngredient('P', Material.PAPER);
        smokeRecipe.setIngredient('G', Material.BLAZE_POWDER);

        // Enregistrer le craft
        main.getServer().addRecipe(smokeRecipe);
    };

    public ItemStack buildItem() {

        ItemStack smoke = new ItemStack(Material.STICK, 1);
        ItemMeta smokeM = smoke.getItemMeta();
        smokeM.setDisplayName("§6Fumigene");
        smokeM.setLore(Arrays.asList("§bDe quoi faire un écran de fumée", "§6Made by: Rome"));
        smoke.setItemMeta(smokeM);

        return smoke;
    };

    public void giveItem(Player player) {
        ItemStack smoke = this.buildItem();
        player.getInventory().addItem(smoke);
    };
}
