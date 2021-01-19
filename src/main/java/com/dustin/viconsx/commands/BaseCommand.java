package com.dustin.viconsx.commands;

import com.dustin.viconsx.VIconX;
import com.dustin.viconsx.guis.IconsPanel;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BaseCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lavel, String[] args) {

        Player player = (Player) sender;

        IconsPanel iconPanel = new IconsPanel();
        iconPanel.showPanel(player);

        return true;
    }
}
