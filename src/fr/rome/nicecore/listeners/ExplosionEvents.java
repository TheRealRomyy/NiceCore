package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class ExplosionEvents implements Listener {

    private final Main main;

    public ExplosionEvents(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();

        if(block.getType().equals(Material.CHEST)) {
            Chest chest = (Chest) block.getState();

          if(chest.getCustomName() != null && chest.getCustomName().equals("§cBomb")) main.getChestToExplose().put(chest, main.getTotalSeconds()+10);

        } else if(block.getType().equals(Material.OBSIDIAN)) {
            if(player.getItemInHand() != null && player.getItemInHand().hasItemMeta() && player.getItemInHand().getItemMeta().hasDisplayName() && player.getItemInHand().getItemMeta().getDisplayName().equals("§cObsidian TNT")) {
                main.getTntobsidian().add(block.getLocation());
            };
        };
    };

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();

        if(block.getType().equals(Material.CHEST)) {
            Chest chest = (Chest) block.getState();

            if(chest.getCustomName() != null && chest.getCustomName().equals("§cBomb")) {
                e.setCancelled(true);
            };
        } else if(block.getType().equals(Material.OBSIDIAN)) {
            if(main.getTntobsidian().contains(block.getLocation())) {
                e.setCancelled(true);

                main.getTntobsidian().remove(block.getLocation());

                block.setType(Material.AIR);
                TNTPrimed tnt = player.getWorld().spawn(block.getLocation(), TNTPrimed.class);
                tnt.setFuseTicks(0);
            };
        };
    };
};