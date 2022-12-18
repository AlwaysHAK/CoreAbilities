package net.alwayshak.config;

import net.alwayshak.Core;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {
    private final Core core;
    private static ConfigHandler instance;
    private FileConfiguration cosmetics;
    private FileConfiguration player;
    private FileConfiguration notes;

    public static ConfigHandler getInstance() {
        return instance;
    }


    public ConfigHandler(Core core) {
        this.core = core;
        instance = this;
        if (!core.getDataFolder().exists())
            core.getDataFolder().mkdir();
        loadCosmeticsConfig();
        loadNotesConfig();
        loadPlayerConfig();
    }

    public FileConfiguration getCosmetics() {
        return this.cosmetics;
    }

    public FileConfiguration getNotes() {
        return this.notes;
    }

    public FileConfiguration getPlayer() {
        return this.player;
    }

    public void loadPlayerConfig() {
        try {
            File cosmeticsFile = new File(this.core.getDataFolder(), "players.yml");
            if (!cosmeticsFile.exists())
                cosmeticsFile.createNewFile();
            this.player = YamlConfiguration.loadConfiguration(cosmeticsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savePlayerConfig() {
        try {
            this.player.save(new File(this.core.getDataFolder(), "players.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNotesConfig() {
        try {
            File cosmeticsFile = new File(this.core.getDataFolder(), "notes.yml");
            if (!cosmeticsFile.exists())
                cosmeticsFile.createNewFile();
            this.notes = YamlConfiguration.loadConfiguration(cosmeticsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveNotesConfig() {
        try {
            this.notes.save(new File(this.core.getDataFolder(), "notes.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCosmeticsConfig() {
        try {
            File cosmeticsFile = new File(this.core.getDataFolder(), "cosmetics.yml");
            if (!cosmeticsFile.exists())
                cosmeticsFile.createNewFile();
            this.cosmetics = YamlConfiguration.loadConfiguration(cosmeticsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveCosmeticsConfig() {
        try {
            this.cosmetics.save(new File(this.core.getDataFolder(), "cosmetics.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


