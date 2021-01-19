package com.dustin.viconsx.utils;

import org.bukkit.entity.Player;

public class VExperience {
    public static int getTotalExperience(int level) {
        int xp = 0;
        if((level >= 0) && (level <= 15)) {
            xp = (int)Math.round(Math.pow(level, 2.0) + 6 * level);
        } else if(level > 15 && level <= 30) {
            xp = (int)Math.round(2.5 * Math.pow(level, 2.0) - 40.5 * level + 360.0);
        } else if(level > 30) {
            xp = (int)Math.round(4.5 * Math.pow(level, 2.0) - 162.5 * level + 2220.0);
        }
        return xp;
    }

    public static int getTotalExperience(Player player) {
        return Math.round(player.getExp() * player.getExpToLevel()) + getTotalExperience(player.getLevel());
    }

    public static void setTotalExperience(Player player, int amount) {
        int level = 0;
        int xp = 0;
        float a = 0.0f;
        float b = 0.0f;
        float c = -amount;
        if((amount > getTotalExperience(0)) && (amount <= getTotalExperience(15))) {
            a = 1.0f;
            b = 6.0f;
        } else if((amount > getTotalExperience(15)) && (amount <= getTotalExperience(30))) {
            a = 2.5f;
            b = -40.5f;
            c += 360.0f;
        } else if(amount > getTotalExperience(30)) {
            a = 4.5f;
            b = -162.5f;
            c += 2220.0f;
        }
        level = (int)Math.floor((-b + Math.sqrt(Math.pow(b, 2.0) - 4.0f * a * c)) / (2.0f * a));
        xp = (amount - getTotalExperience(level));
        player.setLevel(level);
        player.setExp(0.0f);
        player.giveExp(xp);
    }
}
