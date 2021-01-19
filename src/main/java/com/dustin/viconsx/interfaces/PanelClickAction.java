package com.dustin.viconsx.interfaces;

import org.bukkit.event.inventory.InventoryClickEvent;

@FunctionalInterface
public interface PanelClickAction {
    public void call(InventoryClickEvent event);
}
