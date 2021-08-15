package fr.rome.nicecore.listeners;

import fr.rome.nicecore.Main;
import fr.rome.nicecore.items.*;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ClicksEvents implements Listener {

    private final Main main;

    public ClicksEvents(Main main) {
        this.main = main;
    };

    @EventHandler
    public void onPlayerUseItem(PlayerInteractEvent e) {

        if (e.getItem() == null) return;

        Player player = e.getPlayer();
        PlayerInventory inventory = player.getInventory();
        ItemStack item = player.getItemInHand();
        ItemStack coal = new ItemStack(Material.COAL, 1);

        String prefix = main.getPrefix();

        if(item == null) return;

        if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§aChunk Finder")) {
           item.setDurability((short) (item.getDurability() + 1));
            if(item.getDurability() >= 64) {
                player.setItemInHand(null);
                player.updateInventory();
                return;
            };

            ChunkFinder chunkFinder = new ChunkFinder(main);
            chunkFinder.useItem(player);
        } else if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§cFireball Launcher")) {
            if (inventory.containsAtLeast(coal, 1)) {

                if (!main.getFireballShooterCooldowns().containsKey(player) || (main.getTotalSeconds() - main.getFireballShooterCooldowns().get(player) >= 20L)) {
                    main.getFireballShooterCooldowns().remove(player);
                    main.getFireballShooterCooldowns().put(player, main.getTotalSeconds());

                    inventory.removeItem(coal);
                    player.updateInventory();

                    player.getLocation().getDirection().normalize().multiply(1);
                    player.launchProjectile(SmallFireball.class);
                    player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);

                    main.getShootersPlayers().add(player);

                    if(!main.getFireballShooterUses().containsKey(player)) main.getFireballShooterUses().put(player, 50);

                    Integer uses = main.getFireballShooterUses().get(player)-1;
                    main.getFireballShooterUses().remove(player);
                    if(uses != 0) {
                        main.getFireballShooterUses().put(player, uses);

                        player.sendMessage("§aIl te reste §6" + uses + " §atirs ! (Tu es en cooldown pour 20s)");
                    } else {
                        FireballLauncher fireballLauncher = new FireballLauncher(main);
                        player.getInventory().remove(fireballLauncher.buildItem());
                        main.getFireballShooterCooldowns().remove(player);
                        player.updateInventory();

                        player.sendMessage("§cTon lanceur de fireball s'est cassé !");

                        e.setCancelled(true);
                    };
                } else {
                  player.sendMessage("§cTu es en cooldown. Il reste " + (20L - (main.getTotalSeconds() - main.getFireballShooterCooldowns().get(player))) + " secondes !");
                };
            } else {
              player.sendMessage("§cTu n'a pas de charbon dans votre inventaire !");
            };
        } else if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§eFeather Jump")) {

            if (!main.getDoubleJumpCooldowns().containsKey(player) || (main.getTotalSeconds() - main.getDoubleJumpCooldowns().get(player) >= 30L)) {
                main.getDoubleJumpCooldowns().remove(player);
                main.getDoubleJumpCooldowns().put(player, main.getTotalSeconds());

               player.setVelocity(player.getLocation().getDirection().multiply(3).setY(1));

                if(!main.getDoubleJumpUses().containsKey(player)) main.getDoubleJumpUses().put(player, 30);

                Integer uses = main.getDoubleJumpUses().get(player)-1;
                main.getDoubleJumpUses().remove(player);
                if(uses != 0) {
                    main.getDoubleJumpUses().put(player, uses);

                    player.sendMessage("§aIl te reste §6" + uses + " §adouble jumps ! (Tu es en cooldown pour 30s)");
                } else {
                    Feather feather = new Feather(main);
                    player.getInventory().remove(feather.buildItem());
                    main.getDoubleJumpCooldowns().remove(player);

                    player.sendMessage("§cTon feather jump s'est cassé !");

                    e.setCancelled(true);
                };
            } else {
                player.sendMessage("§cTu es en cooldown. Il reste " + (30L - (main.getTotalSeconds() - main.getDoubleJumpCooldowns().get(player))) + " secondes !");
                e.setCancelled(true);
            };
        } else if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§6Player Detector")) {

            main.getDetectorCooldowns().remove(player);
            main.getDetectorCooldowns().put(player, main.getTotalSeconds());

            for (Entity ent : player.getNearbyEntities(50,50,50)) {
                if (ent instanceof Player) {
                    Player entP = (Player) ent;
                    entP.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20*30, 0));
                };
            };

            Detector detector = new Detector(main);
            player.getInventory().remove(detector.buildItem());
            player.updateInventory();

            e.setCancelled(true);

            player.sendMessage(prefix + "§6Détection des joueurs dans les environs...");
        } else if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§eGolden Head")) {

            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 30*20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 5*40, 1));
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120*20, 0));
            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 30*20, 0));

            for (ItemStack i : player.getInventory().getContents()) {
                if(i != null && i.hasItemMeta() && i.getItemMeta().hasDisplayName() && i.getItemMeta().getDisplayName().equals("§eGolden Head")) {
                    if(i.getAmount() == 1) {
                        player.getInventory().remove(i);
                    } else {
                        i.setAmount(i.getAmount() - 1);
                    };
                };
            };

            e.setCancelled(true);
            player.sendMessage(prefix + "§aGolden head consommee avec succes..");
        } else if(item.hasItemMeta() && item.getItemMeta().hasDisplayName() && item.getItemMeta().getDisplayName().equalsIgnoreCase("§6Fumigene")) {

            main.getSmokePlayers().add(player);

            player.getLocation().getDirection().normalize().multiply(1);
            player.launchProjectile(SmallFireball.class);
            player.playSound(player.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1, 1);

            for (ItemStack i : player.getInventory().getContents()) {
                if(i != null && i.hasItemMeta() && i.getItemMeta().hasDisplayName() && i.getItemMeta().getDisplayName().equals("§6Fumigene") && i.getType().equals(Material.STICK)) {
                    if(i.getAmount() == 1) {
                        player.getInventory().remove(i);
                    } else {
                        i.setAmount(i.getAmount() - 1);
                    };
                };
            };

            e.setCancelled(true);
        };
    };

    @EventHandler
    public void onHit(ProjectileHitEvent e) {
        if(e.getEntity().getShooter() instanceof Player) {
            Player shooter = (Player) e.getEntity().getShooter();

            if (e.getEntity() instanceof Fireball) {
                if(main.getShootersPlayers().contains(shooter)) {
                    e.getEntity().getWorld().createExplosion(e.getEntity().getLocation(), (float) 4.0);
                    main.getShootersPlayers().remove(shooter);
                } else if(main.getSmokePlayers().contains(shooter)) {

                    main.getSmokePlayers().remove(shooter);

                    if(e.getHitBlock() == null || e.getHitBlock().getWorld().getNearbyEntities(e.getHitBlock().getLocation(), 10,10,10) == null) return;

                    for (Entity ent : e.getHitBlock().getWorld().getNearbyEntities(e.getHitBlock().getLocation(), 10,10,10)) {
                        if (ent instanceof Player) {
                            Player entP = (Player) ent;
                            entP.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*30, 0));
                        };
                    };
                };
            };
        };
    };
};
