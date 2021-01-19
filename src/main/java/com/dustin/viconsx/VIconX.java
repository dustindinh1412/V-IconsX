package com.dustin.viconsx;

import com.dustin.viconsx.commands.BaseCommand;
import com.dustin.viconsx.listeners.PanelClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public class VIconX extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        registerEvents();
        registerCommands();
    }
    private void registerEvents()  {
        new PanelClickListener(this);
    }
    private  void registerCommands() {
        this.getCommand("viconsx").setExecutor(new BaseCommand());
    }

}
