package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class OtherStuff {

    private final Main main;

    public OtherStuff(Main main) {
        this.main = main;
    };

    public void manage() {

        this.gapple();
        this.unbreakableSword();
        this.emeraldBowCraft();
    };

    public void gapple() {
        // Add gapple
        ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 1, (byte) 1);
        ShapedRecipe gappleRecipe = new ShapedRecipe(gapple);
        gappleRecipe.shape("BBB", "BGB", "BBB");

        gappleRecipe.setIngredient('G', Material.GOLDEN_APPLE);
        gappleRecipe.setIngredient('B', Material.GOLD_BLOCK);

        main.getServer().addRecipe(gappleRecipe);
    };

    public void unbreakableSword() {
        // Add gapple
        ItemStack unbreakableSword = new ItemStack(Material.WOOD_SWORD, 1);
        ItemMeta unbreakableSwordM = unbreakableSword.getItemMeta();
        unbreakableSwordM.setDisplayName("§6Unbreakable Sword");
        unbreakableSwordM.setUnbreakable(true);
        unbreakableSwordM.setLore(Arrays.asList("§bUne épée incassable", "§6Made by: Rome"));
        unbreakableSword.setItemMeta(unbreakableSwordM);

        ShapedRecipe unbreakableSwordRecipe = new ShapedRecipe(unbreakableSword);
        unbreakableSwordRecipe.shape("DDD", "DSD", "DDD");

        unbreakableSwordRecipe.setIngredient('D', Material.DIRT);
        unbreakableSwordRecipe.setIngredient('S', Material.WOOD_SWORD);

        main.getServer().addRecipe(unbreakableSwordRecipe);
    };

    public void emeraldBowCraft() {
        // Add gapple
        ItemStack emeraldBow = this.buildEmeraldBow();
        ShapedRecipe emeraldBowRecipe = new ShapedRecipe(emeraldBow);
        emeraldBowRecipe.shape("EEE", "EBE", "EEE");

        emeraldBowRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        emeraldBowRecipe.setIngredient('B', Material.BOW);

        main.getServer().addRecipe(emeraldBowRecipe);
    };

    public ItemStack buildEmeraldBow() {

        ItemStack detector = new ItemStack(Material.BOW, 1);
        ItemMeta detectorM = detector.getItemMeta();
        detectorM.setDisplayName("§aEmerald Bow");
        detectorM.setLore(Arrays.asList("§bUn arc parfait", "§6Made by: Rome"));
        detectorM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        detectorM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        detectorM.addEnchant(Enchantment.ARROW_DAMAGE, 7, true);
        detectorM.addEnchant(Enchantment.ARROW_FIRE, 3, true);
        detector.setItemMeta(detectorM);

        return detector;
    };
};
