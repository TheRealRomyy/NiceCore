package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class InvisibilyClock {

    private Main main;

    public InvisibilyClock(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack invisibilityCloack = this.buildItem();
        ShapedRecipe invisibilityCloackRecipe = new ShapedRecipe(invisibilityCloack);
        invisibilityCloackRecipe.shape("GIG", "ILI", "GIG");

        invisibilityCloackRecipe.setIngredient('G', Material.GLOWSTONE_DUST);
        invisibilityCloackRecipe.setIngredient('I', Material.DIAMOND);
        invisibilityCloackRecipe.setIngredient('L', Material.LEATHER_CHESTPLATE);

        // Enregistrer le craft
        main.getServer().addRecipe(invisibilityCloackRecipe);
    };

    public void giveItem(Player player) {
        ItemStack invisibilityCloack = this.buildItem();
        player.getInventory().addItem(invisibilityCloack);
    };

    public ItemStack buildItem() {

        ItemStack invisibilityCloack = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemMeta invisibilityCloackM = invisibilityCloack.getItemMeta();
        invisibilityCloackM.setDisplayName("§6Invisibility Cloack");
        invisibilityCloackM.setLore(Arrays.asList("§bUne cape d'invisibilité", "§6Made by: Rome"));
        invisibilityCloack.setItemMeta(invisibilityCloackM);

        return invisibilityCloack;
    };
};
