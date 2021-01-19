package com.dustin.viconsx;

import com.dustin.viconsx.commands.RootCommand;
import com.dustin.viconsx.listeners.PanelClickListener;
import com.dustin.viconsx.utils.VUtils;
import com.dustin.viconsx.utils.configs.Configurations;
import org.bukkit.plugin.java.JavaPlugin;

public class VIconX extends JavaPlugin {

    private static VIconX instance;


    @Override
    public void onEnable() {
        instance = this;
        registerEvents();
        registerCommands();
        initalConfigurations();
    }
    private void registerEvents()  {
        new PanelClickListener(this);
    }
    private void registerCommands() {
       new RootCommand("viconsx");
    }
    private void initalConfigurations() {
        VUtils.logToConsle("Setup configration files...");
        new Configurations().setup("config");
    }
    public static VIconX getInstance() {
        if (instance == null) {
            return new VIconX();
        };
        return instance;
    };
}
