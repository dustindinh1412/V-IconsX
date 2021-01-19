package com.dustin.viconsx.utils;

import org.bukkit.ChatColor;

public class VFormatter {

    public static String colorize(String text) {
        return colorizeDefaultColor(text);
    }

    private static String colorizeDefaultColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    private static String colorizeHexColor(String text) {
        return "";
    }
}
