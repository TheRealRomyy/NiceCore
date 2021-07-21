package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Bomb {

    private final Main main;

    public Bomb(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack bomb = this.buildItem();
        ShapedRecipe bombRecipe = new ShapedRecipe(bomb);
        bombRecipe.shape("ATA", "TCT", "ATA");

        bombRecipe.setIngredient('T', Material.TNT);
        bombRecipe.setIngredient('C', Material.TRAPPED_CHEST);
        bombRecipe.setIngredient('A', Material.AIR);

        // Enregistrer le craft
        main.getServer().addRecipe(bombRecipe);
    };

    public void giveItem(Player player) {
        ItemStack bomb = this.buildItem();
        player.getInventory().addItem(bomb);
    };

    public ItemStack buildItem() {

        ItemStack bomb = new ItemStack(Material.CHEST, 1);
        ItemMeta bombM = bomb.getItemMeta();
        bombM.setDisplayName("§cBomb");
        bombM.setLore(Arrays.asList("§bUne bombe a retardement (10s)", "§6Made by: Rome"));
        bomb.setItemMeta(bombM);

        return bomb;
    };
}
