package com.dustin.viconsx.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.security.Permission;
import java.util.Arrays;

public class VUtils {

    private static PluginManager manager = Bukkit.getPluginManager();

    public static boolean isPluginEnabled(String pluginName) {
        return manager.isPluginEnabled(pluginName);
    };

    public static boolean isPluginEnabled(Plugin plugin) {
        return manager.isPluginEnabled(plugin);
    }


    public static void broadCastToAll(String message) {
        Bukkit.broadcastMessage(message);
    }

    public static void broadCastToAll(String ...messages) {
        for (String message : messages) {
            broadCastToAll(message);
        }
    }
    public static void logToConsle(String message){
        Bukkit.getConsoleSender().sendMessage(message);
    }
    public static void logToConsle(String ...messages){
        Arrays.stream(messages).forEach(message -> {
            logToConsle(message);
        });
    }

    public static void broadCastToSpecific(Permission permission, String message) {
        Bukkit.broadcast(message,permission.getName());
    }

    public static void broadCastToSpecific(Permission permission, String... messages) {
        for (String message : messages) {
            broadCastToSpecific(permission,messages);
        }
    }
}
