package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ChunkFinder {

    private Main main;

    public ChunkFinder(Main main) {
        this.main = main;
    };

    public void addCraft() {
        ItemStack chunckFinder = this.buildItem();
        ShapedRecipe chunckFinderRecipe = new ShapedRecipe(chunckFinder);
        chunckFinderRecipe.shape("TDT", "ICI", "BBB");

        chunckFinderRecipe.setIngredient('C', Material.COMPASS);
        chunckFinderRecipe.setIngredient('B', Material.IRON_BLOCK);
        chunckFinderRecipe.setIngredient('I', Material.IRON_INGOT);
        chunckFinderRecipe.setIngredient('T', Material.REDSTONE);
        chunckFinderRecipe.setIngredient('D', Material.DIAMOND_BLOCK);

        // Enregistrer le craft
        main.getServer().addRecipe(chunckFinderRecipe);
    };

    public void useItem(Player player) {
         Chunk chunk = player.getLocation().getChunk();
         Integer chests = 0;

         player.sendMessage("§6Analyse du chunk en cours....");

         for(BlockState state: chunk.getTileEntities()) {
             if(state instanceof Chest) chests++;
         };

         player.sendMessage("§aIl y a §6" + chests.toString() + " §acoffres dans ce chunk");
    };

    public ItemStack buildItem() {

        ItemStack chunckFinder = new ItemStack(Material.FLINT_AND_STEEL, 1);
        ItemMeta chunckFinderM = chunckFinder.getItemMeta();
        chunckFinderM.setDisplayName("§aChunk Finder");
        chunckFinder.setDurability((short) 54);
        chunckFinderM.setLore(Arrays.asList("§bUn analyseur de chunck", "§6Made by: Rome"));
        chunckFinder.setItemMeta(chunckFinderM);

        return chunckFinder;
    };

    public void giveItem(Player player) {
        ItemStack chunkAnalyser = this.buildItem();
        player.getInventory().addItem(chunkAnalyser);
    };
}
