package com.dustin.viconsx.listeners;

import com.dustin.viconsx.VIconX;
import com.dustin.viconsx.utils.gui.BasePanel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PanelClickListener implements Listener {

    public PanelClickListener(VIconX main) {
        main.getServer().getPluginManager().registerEvents(this, main);
    }
    @EventHandler
    public void onClickPanelItem(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        if (!clickedInventory.equals(null) && clickedInventory.getHolder() instanceof BasePanel) {
            if (event.getCurrentItem() == null) {
                event.setCancelled(true);
                return;
            }
            ((BasePanel) clickedInventory.getHolder()).handlePanelItemClick(event);
        }
    }
}
