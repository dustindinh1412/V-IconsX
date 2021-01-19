package com.dustin.viconsx.utils;

import com.dustin.viconsx.VIconX;
import com.dustin.viconsx.guis.IconsPanel;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VCommand implements CommandExecutor {

    public VCommand(String command) {
        VIconX.getInstance().getCommand(command).setExecutor(this);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args) {
      return true;
    };
}
