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
        this.emeraldSword();
        this.emeraldPickaxe();
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

        ItemStack emeraldBow = new ItemStack(Material.BOW, 1);
        ItemMeta emeraldBowM = emeraldBow.getItemMeta();
        emeraldBowM.setDisplayName("§aEmerald Bow");
        emeraldBowM.setLore(Arrays.asList("§bUn arc parfait", "§6Made by: Rome"));
        emeraldBowM.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        emeraldBowM.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        emeraldBowM.addEnchant(Enchantment.ARROW_DAMAGE, 7, true);
        emeraldBowM.addEnchant(Enchantment.ARROW_FIRE, 3, true);
        emeraldBowM.addEnchant(Enchantment.DURABILITY, 3, true);
        emeraldBowM.addEnchant(Enchantment.MENDING, 1, true);
        emeraldBow.setItemMeta(emeraldBowM);

        return emeraldBow;
    };

    public void emeraldSword() {
        ItemStack emeraldSword = this.buildEmeraldSword();
        ShapedRecipe emeraldSwordRecipe = new ShapedRecipe(emeraldSword);
        emeraldSwordRecipe.shape("EEE", "EBE", "EEE");

        emeraldSwordRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        emeraldSwordRecipe.setIngredient('B', Material.DIAMOND_SWORD);

        main.getServer().addRecipe(emeraldSwordRecipe);
    };

    public ItemStack buildEmeraldSword() {

        ItemStack emeraldSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta emeraldSwordM = emeraldSword.getItemMeta();
        emeraldSwordM.setDisplayName("§aEmerald Sword");
        emeraldSwordM.setLore(Arrays.asList("§bUne épée parfaite", "§6Made by: Rome"));
        emeraldSwordM.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        emeraldSwordM.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        emeraldSwordM.addEnchant(Enchantment.DURABILITY, 3, true);
        emeraldSwordM.addEnchant(Enchantment.MENDING, 1, true);
        emeraldSwordM.addEnchant(Enchantment.KNOCKBACK, 2, true);
        emeraldSword.setItemMeta(emeraldSwordM);

        return emeraldSword;
    };

    public void emeraldPickaxe() {
        ItemStack emeraldPickaxe = this.buildEmeraldPickaxe();
        ShapedRecipe emeraldPickaxeRecipe = new ShapedRecipe(emeraldPickaxe);
        emeraldPickaxeRecipe.shape("EEE", "EBE", "EEE");

        emeraldPickaxeRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        emeraldPickaxeRecipe.setIngredient('B', Material.DIAMOND_PICKAXE);

        main.getServer().addRecipe(emeraldPickaxeRecipe);
    };

    public ItemStack buildEmeraldPickaxe() {

        ItemStack emeraldPickaxe = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta emeraldPickaxeM = emeraldPickaxe.getItemMeta();
        emeraldPickaxeM.setDisplayName("§aEmerald Pickaxe");
        emeraldPickaxeM.setLore(Arrays.asList("§bUne pioche parfaite", "§6Made by: Rome"));
        emeraldPickaxeM.addEnchant(Enchantment.DIG_SPEED, 5, true);
        emeraldPickaxeM.addEnchant(Enchantment.DURABILITY, 3, true);
        emeraldPickaxeM.addEnchant(Enchantment.MENDING, 1, true);
        emeraldPickaxeM.addEnchant(Enchantment.LUCK, 3, true);
        emeraldPickaxe.setItemMeta(emeraldPickaxeM);

        return emeraldPickaxe;
    };
};
