package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BombEvents implements Listener {

    private final Main main;

    public BombEvents(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Block block = e.getBlock();

        if(block.getType().equals(Material.CHEST)) {
            Chest chest = (Chest) block.getState();

          if(chest.getCustomName() != null && chest.getCustomName().equals("§cBomb")) {
            main.getChestToExplose().put(chest, main.getTotalSeconds()+10);
          };
        };
    };

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Block block = e.getBlock();

        if(block.getType().equals(Material.CHEST)) {
            Chest chest = (Chest) block.getState();

            if(chest.getCustomName() != null && chest.getCustomName().equals("§cBomb")) {
                e.setCancelled(true);
            };
        };
    };
};