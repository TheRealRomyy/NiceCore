package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class TNTObsidian {

    private final Main main;

    public TNTObsidian(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack TNTObsidian = this.buildItem();
        ShapedRecipe TNTObsidianRecipe = new ShapedRecipe(TNTObsidian);
        TNTObsidianRecipe.shape("ATA", "TOT", "ATA");

        TNTObsidianRecipe.setIngredient('A', Material.AIR);
        TNTObsidianRecipe.setIngredient('T', Material.TNT);
        TNTObsidianRecipe.setIngredient('O', Material.OBSIDIAN);

        // Enregistrer le craft
        main.getServer().addRecipe(TNTObsidianRecipe);
    };

    public ItemStack buildItem() {

        ItemStack TNTObsidian = new ItemStack(Material.OBSIDIAN, 1);
        ItemMeta TNTObsidianM = TNTObsidian.getItemMeta();
        TNTObsidianM.setDisplayName("§cObsidian TNT");
        TNTObsidianM.setLore(Arrays.asList("§bUne obsidienne qui se transforme en TNT", "§6Made by: Rome"));
        TNTObsidian.setItemMeta(TNTObsidianM);

        return TNTObsidian;
    };

    public void giveItem(Player player) {
        ItemStack TNTObsidian = this.buildItem();
        player.getInventory().addItem(TNTObsidian);
    };
};
