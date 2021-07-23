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
    public Double totalSeconds = 0.0;

    public ArrayList<Player> invisiblePlayers = new ArrayList<Player>();
    public ArrayList<Player> shootersPlayers = new ArrayList<Player>();
    public ArrayList<Player> jetpackPlayers = new ArrayList<Player>();
    public ArrayList<Location> tntobsidian = new ArrayList<Location>();
    public ArrayList<Player> smokePlayers = new ArrayList<Player>();

    public HashMap<Player, Integer> fireballShooterUses = new HashMap<Player, Integer>();
    public HashMap<Player, Double> fireballShooterCooldowns = new HashMap<Player, Double>();
    public HashMap<Player, Integer> doubleJumpUses = new HashMap<Player, Integer>();
    public HashMap<Player, Double> doubleJumpCooldowns = new HashMap<Player, Double>();
    public HashMap<Player, Double> detectorCooldowns = new HashMap<Player, Double>();
    public HashMap<Chest, Double> chestToExplose = new HashMap<Chest, Double>();

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

    public HashMap<Player, Double> getFireballShooterCooldowns() {
        return fireballShooterCooldowns;
    };

    public HashMap<Player, Double> getDoubleJumpCooldowns() {
        return doubleJumpCooldowns;
    };

    public HashMap<Player, Integer> getDoubleJumpUses() {
        return doubleJumpUses;
    };

    public Double getTotalSeconds() {
        return totalSeconds;
    };

    public void setTotalSeconds(Double totalSeconds) {
        this.totalSeconds = totalSeconds;
    };

    public HashMap<Player, Double> getDetectorCooldowns() {
        return detectorCooldowns;
    };

    public HashMap<Chest, Double> getChestToExplose() {
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
};
