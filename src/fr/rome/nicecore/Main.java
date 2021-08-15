package fr.rome.nicecore;

import fr.rome.nicecore.commands.CooldownBypass;
import fr.rome.nicecore.commands.ItemGive;
import fr.rome.nicecore.items.ItemManager;
import fr.rome.nicecore.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Main extends JavaPlugin {

    public String prefix = this.getConfig().getString("prefix").replace("&", "§") + " ";
    public Long totalSeconds = 0L;

    public ArrayList<Player> invisiblePlayers = new ArrayList<Player>();
    public ArrayList<Player> shootersPlayers = new ArrayList<Player>();
    public ArrayList<Player> jetpackPlayers = new ArrayList<Player>();
    public ArrayList<Location> tntobsidian = new ArrayList<Location>();
    public ArrayList<Player> smokePlayers = new ArrayList<Player>();
    public ArrayList<Player> singModePlayers = new ArrayList<Player>();

    public HashMap<Player, Integer> fireballShooterUses = new HashMap<Player, Integer>();
    public HashMap<Player, Long> fireballShooterCooldowns = new HashMap<Player, Long>();
    public HashMap<Player, Integer> doubleJumpUses = new HashMap<Player, Integer>();
    public HashMap<Player, Long> doubleJumpCooldowns = new HashMap<Player, Long>();
    public HashMap<Player, Long> detectorCooldowns = new HashMap<Player, Long>();
    public HashMap<Chest, Long> chestToExplose = new HashMap<Chest, Long>();

    @Override
    public void onEnable() {
        System.out.println("[NiceCore] Demarrage...");

        // Save config
        saveDefaultConfig();

        // Item manager
        ItemManager itemmanager = new ItemManager(this);
        itemmanager.manage();

        // Setup Plugin manager (for events)
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ClicksEvents(this), this);
        pm.registerEvents(new EmeraldStuffEvents(this), this);
        pm.registerEvents(new InvisivilityCloackEvents(this), this);
        pm.registerEvents(new PlayerManagement(this), this);
        pm.registerEvents(new ExplosionEvents(this), this);

        // Setup commands
        getCommand("itemgive").setExecutor(new ItemGive(this));
        getCommand("clearcooldowns").setExecutor(new CooldownBypass(this));
    };

    public String getPrefix() {
        return prefix;
    }

    public ArrayList<Player> getInvisiblePlayers() {
        return invisiblePlayers;
    };

    public ArrayList<Player> getShootersPlayers() {
        return shootersPlayers;
    };

    public HashMap<Player, Integer> getFireballShooterUses() {
        return fireballShooterUses;
    };

    public HashMap<Player, Long> getFireballShooterCooldowns() {
        return fireballShooterCooldowns;
    };

    public HashMap<Player, Long> getDoubleJumpCooldowns() {
        return doubleJumpCooldowns;
    };

    public HashMap<Player, Integer> getDoubleJumpUses() {
        return doubleJumpUses;
    };

    public Long getTotalSeconds() {
        return totalSeconds;
    };

    public void setTotalSeconds(Long totalSeconds) {
        this.totalSeconds = totalSeconds;
    };

    public HashMap<Player, Long> getDetectorCooldowns() {
        return detectorCooldowns;
    };

    public HashMap<Chest, Long> getChestToExplose() {
        return chestToExplose;
    };

    public ArrayList<Player> getJetpackPlayers() {
        return jetpackPlayers;
    };

    public ArrayList<Location> getTntobsidian() {
        return tntobsidian;
    };

    public ArrayList<Player> getSmokePlayers() {
        return smokePlayers;
    };

    public ArrayList<Player> getSingModePlayers() {
        return singModePlayers;
    };
};
