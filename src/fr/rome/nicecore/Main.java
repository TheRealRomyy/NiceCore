package fr.rome.nicecore;

import fr.rome.nicecore.commands.CooldownBypass;
import fr.rome.nicecore.commands.ItemGive;
import fr.rome.nicecore.items.ItemManager;
import fr.rome.nicecore.listeners.ClicksEvents;
import fr.rome.nicecore.listeners.EmeraldArmorEvents;
import fr.rome.nicecore.listeners.InvisivilityCloackEvents;
import fr.rome.nicecore.listeners.PlayerManagement;
import org.bukkit.Bukkit;
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

    public HashMap<Player, Integer> fireballShooterUses = new HashMap<Player, Integer>();
    public HashMap<Player, Double> fireballShooterCooldowns = new HashMap<Player, Double>();
    public HashMap<Player, Integer> doubleJumpUses = new HashMap<Player, Integer>();
    public HashMap<Player, Double> doubleJumpCooldowns = new HashMap<Player, Double>();

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
        pm.registerEvents(new EmeraldArmorEvents(this), this);
        pm.registerEvents(new InvisivilityCloackEvents(this), this);
        pm.registerEvents(new PlayerManagement(this), this);

        // Setup commands
        getCommand("itemgive").setExecutor(new ItemGive(this));
        getCommand("clearcooldowns").setExecutor(new CooldownBypass(this));
    };

    @Override
    public void onDisable() {
        System.out.println("[NiceCore] Shutdown....");
    }

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
};
