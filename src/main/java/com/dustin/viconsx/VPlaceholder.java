package com.dustin.viconsx;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.OfflinePlayer;

public class VPlaceholder extends PlaceholderExpansion {
    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getAuthor() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public String onRequest(OfflinePlayer p, String params) {
        return super.onRequest(p, params);
    }
}
