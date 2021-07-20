package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EmeraldArmorEvents implements Listener {

    private final Main main;

    public EmeraldArmorEvents(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();

        if(player.getInventory().getHelmet() != null && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§aEmerald Helmet")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0));
        };

        if(player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§aEmerald Chestplate")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 40, 0));
        };

        if(player.getInventory().getLeggings() != null && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§aEmerald Leggings")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 1));
        };

        if(player.getInventory().getBoots() != null && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().getDisplayName().equals("§aEmerald Boots")) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 40, 1));
        };

        if((player.getInventory().getHelmet() != null && player.getInventory().getHelmet().hasItemMeta() && player.getInventory().getHelmet().getItemMeta().getDisplayName().equals("§aEmerald Helmet")) && (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().hasItemMeta() && player.getInventory().getChestplate().getItemMeta().getDisplayName().equals("§aEmerald Chestplate")) && (player.getInventory().getLeggings() != null && player.getInventory().getLeggings().hasItemMeta() && player.getInventory().getLeggings().getItemMeta().getDisplayName().equals("§aEmerald Leggings")) && (player.getInventory().getBoots() != null && player.getInventory().getBoots().hasItemMeta() && player.getInventory().getBoots().getItemMeta().getDisplayName().equals("§aEmerald Boots"))) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 4*20, 1));
        };
    };
};