package fr.rome.nicecore.items;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class EmeraldArmor {

    private Main main;

    public EmeraldArmor(Main main) {
        this.main = main;
    };

    public void addCraft() {
        // Emerald Helmet
        ItemStack emeraldHelmet = this.buildHelmet();
        ShapedRecipe emeraldHelmetRecipe = new ShapedRecipe(emeraldHelmet);
        emeraldHelmetRecipe.shape("EEE", "EAE", "AAA");

        emeraldHelmetRecipe.setIngredient('A', Material.AIR);
        emeraldHelmetRecipe.setIngredient('E', Material.EMERALD_BLOCK);

        // Emerald Chestplate
        ItemStack emeraldChestplate = this.buildChestplate();
        ShapedRecipe emeraldChestplateRecipe = new ShapedRecipe(emeraldChestplate);
        emeraldChestplateRecipe.shape("EAE", "EDE", "EEE");

        emeraldChestplateRecipe.setIngredient('A', Material.AIR);
        emeraldChestplateRecipe.setIngredient('E', Material.EMERALD_BLOCK);
        emeraldChestplateRecipe.setIngredient('D', Material.DIAMOND_BLOCK);

        // Emerald Leggings
        ItemStack emeraldLeggings = this.buildLeggings();
        ShapedRecipe emeraldLeggingsRecipe = new ShapedRecipe(emeraldLeggings);
        emeraldLeggingsRecipe.shape("EEE", "EAE", "EAE");

        emeraldLeggingsRecipe.setIngredient('A', Material.AIR);
        emeraldLeggingsRecipe.setIngredient('E', Material.EMERALD_BLOCK);

        // Emerald boots
        ItemStack emeraldBoots = this.buildBoots();
        ShapedRecipe emeraldBootsRecipe = new ShapedRecipe(emeraldBoots);
        emeraldBootsRecipe.shape("AAA", "EAE", "EAE");

        emeraldBootsRecipe.setIngredient('A', Material.AIR);
        emeraldBootsRecipe.setIngredient('E', Material.EMERALD_BLOCK);

        // Enregistrer tous les craft
        main.getServer().addRecipe(emeraldHelmetRecipe);
        main.getServer().addRecipe(emeraldChestplateRecipe);
        main.getServer().addRecipe(emeraldLeggingsRecipe);
        main.getServer().addRecipe(emeraldBootsRecipe);
    };

    public ItemStack buildHelmet() {

        ItemStack emeraldHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemMeta emeraldHelmetM = emeraldHelmet.getItemMeta();
        emeraldHelmetM.setDisplayName("§aEmerald Helmet");
        emeraldHelmetM.setLore(Arrays.asList("§bUn casque en émeraudes (speed)", "§6Made by: Rome"));
        emeraldHelmet.setItemMeta(emeraldHelmetM);

        return emeraldHelmet;
    };

    public ItemStack buildChestplate() {

        ItemStack emeraldChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemMeta emeraldChestplateM = emeraldChestplate.getItemMeta();
        emeraldChestplateM.setDisplayName("§aEmerald Chestplate");
        emeraldChestplateM.setLore(Arrays.asList("§bUn plastron en émeraudes (strength)", "§6Made by: Rome"));
        emeraldChestplate.setItemMeta(emeraldChestplateM);

        return emeraldChestplate;
    };

    public ItemStack buildLeggings() {

        ItemStack emeraldLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemMeta emeraldLeggingsM = emeraldLeggings.getItemMeta();
        emeraldLeggingsM.setDisplayName("§aEmerald Leggings");
        emeraldLeggingsM.setLore(Arrays.asList("§bDes jambières en émeraudes (resistance 2)", "§6Made by: Rome"));
        emeraldLeggings.setItemMeta(emeraldLeggingsM);

        return emeraldLeggings;
    };

    public ItemStack buildBoots() {

        ItemStack emeraldBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta emeraldBootsM = emeraldBoots.getItemMeta();
        emeraldBootsM.setDisplayName("§aEmerald Boots");
        emeraldBootsM.setLore(Arrays.asList("§bDes bottes en émeraudes (jump boost 2)", "§6Made by: Rome"));
        emeraldBoots.setItemMeta(emeraldBootsM);

        return emeraldBoots;
    };
};
