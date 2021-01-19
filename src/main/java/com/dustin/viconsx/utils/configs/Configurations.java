package com.dustin.viconsx.utils.configs;

import com.dustin.viconsx.VIconX;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class Configurations {

    private static Configurations instance;

    private Map<String, FileConfiguration> config;
    private Map<String, File> configFile;

    public Configurations() {
        instance = this;
        config = new HashMap<String, FileConfiguration>();
        configFile = new HashMap<String, File>();
        if ( !VIconX.getInstance().getDataFolder().exists()) {
            VIconX.getInstance().getDataFolder().mkdirs();
        }
    }
    public Configurations setup(String ...resourceConfigurationKeyName){

        Arrays.stream(resourceConfigurationKeyName).forEach( keyName -> {
            String fileName = keyName+".yml";
            File physicalConfigFile = new File(VIconX.getInstance().getDataFolder(), fileName);

            if (!physicalConfigFile.exists()) {

                Reader resourceFile = new InputStreamReader(VIconX.getInstance().getResource(fileName));
                Bukkit.getConsoleSender().sendMessage(physicalConfigFile.getPath());
                YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(resourceFile);
                try {
                    physicalConfigFile.createNewFile();
                    yamlConfiguration.save(physicalConfigFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileConfiguration ymlConfigFile = YamlConfiguration.loadConfiguration(physicalConfigFile);
            config.put(keyName, ymlConfigFile);
            configFile.put(keyName, physicalConfigFile);
        });

        return get();
    }

    public ConfigurationSection get(String configurationKeyName) {
        return config.get(configurationKeyName).getConfigurationSection("");
    }

    public void update(String configurationKeyName) {
        try {
            config.get(configurationKeyName).load(configFile.get(configurationKeyName));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void updateAll() {
        configFile.keySet().forEach(this::update);
    }

    public static Configurations get() {
        return instance;
    }
}
