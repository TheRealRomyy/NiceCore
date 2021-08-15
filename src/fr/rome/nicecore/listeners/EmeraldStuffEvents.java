package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class EmeraldStuffEvents implements Listener {

    private final Main main;

    public EmeraldStuffEvents(Main main) {
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

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        Location location = block.getLocation();
        ItemStack itemInHand = player.getItemInHand();

        assert itemInHand != null;
        if(itemInHand.hasItemMeta() && itemInHand.getItemMeta().hasDisplayName() && itemInHand.getItemMeta().getDisplayName().equals("§aEmerald Pickaxe")) {

            if(main.getSingModePlayers().contains(player)) return;

            ArrayList<Location> locs = new ArrayList<Location>();

            double x = location.getX();
            double y = location.getY();
            double z = location.getZ();

            switch (getDirection(player, block)) {
                case 0: // North or South

                    locs.add(new Location(location.getWorld(), x, y+1, z));
                    locs.add(new Location(location.getWorld(), x, y-1, z));
                    locs.add(new Location(location.getWorld(), x, y, z+1));
                    locs.add(new Location(location.getWorld(), x, y, z-1));
                    locs.add(new Location(location.getWorld(), x, y+1, z+1));
                    locs.add(new Location(location.getWorld(), x, y+1, z-1));
                    locs.add(new Location(location.getWorld(), x, y-1, z+1));
                    locs.add(new Location(location.getWorld(), x, y-1, z-1));

                    break;
                case 1: // East or West

                    locs.add(new Location(location.getWorld(), x, y+1, z));
                    locs.add(new Location(location.getWorld(), x, y-1, z));
                    locs.add(new Location(location.getWorld(), x+1, y, z));
                    locs.add(new Location(location.getWorld(), x-1, y, z));
                    locs.add(new Location(location.getWorld(), x+1, y+1, z));
                    locs.add(new Location(location.getWorld(), x-1, y+1, z));
                    locs.add(new Location(location.getWorld(), x+1, y-1, z));
                    locs.add(new Location(location.getWorld(), x-1, y-1, z));

                    break;
                case 2: // Down

                    locs.add(new Location(location.getWorld(), x, y, z+1));
                    locs.add(new Location(location.getWorld(), x, y, z-1));
                    locs.add(new Location(location.getWorld(), x+1, y, z));
                    locs.add(new Location(location.getWorld(), x-1, y, z));
                    locs.add(new Location(location.getWorld(), x+1, y, z+1));
                    locs.add(new Location(location.getWorld(), x-1, y, z+1));
                    locs.add(new Location(location.getWorld(), x-1, y, z-1));
                    locs.add(new Location(location.getWorld(), x+1, y, z-1));

                    break;
                default:
                    break;
            }

            locs.forEach(location1 -> {
                Block block1 = location1.getBlock();

                if(!block1.getType().equals(Material.AIR) && !block1.getType().equals(Material.BEDROCK)) block1.breakNaturally(itemInHand);
            });

            if(!player.getGameMode().equals(GameMode.CREATIVE)) itemInHand.setDurability((short) (itemInHand.getDurability() + 1));
        };
    };

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent e) {

        if(e.getItem() == null) return;

        Player player = e.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack item = player.getItemInHand();

        String prefix = main.getPrefix();

        if(item == null) return;

        if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§aEmerald Pickaxe")) {

            if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {

                if(main.getSingModePlayers().contains(player)) {
                    main.getSingModePlayers().remove(player);

                    player.sendMessage(prefix + "§avous etes maintenant en mode creusage 3x3x1");
                } else {
                    main.getSingModePlayers().add(player);

                    player.sendMessage(prefix + "§avous etes maintenant en mode creusage single");
                };
            };
        };
    };

    private static Integer getDirection(Player player, Block block) {
        if(player.getLocation().getY() > block.getLocation().getY()) return 2; // Down
        double rot = (player.getLocation().getYaw() - 90) % 360;
        if (rot < 0) rot += 360.0;

        if (0 <= rot && rot < 67.5) {
            return 0; // North
        } else if (67.5 <= rot && rot < 157.5) {
            return 1; // East
        } else if (157.5 <= rot && rot < 247.5) {
            return 0; // South
        } else if (247.5 <= rot && rot < 337.5) {
            return 1; // West
        } else if (337.5 <= rot && rot < 360.0) {
            return 0; // North
        } else {
            return 3;
        }
    }
};