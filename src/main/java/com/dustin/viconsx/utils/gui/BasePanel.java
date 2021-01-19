package com.dustin.viconsx.utils.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasePanel implements InventoryHolder {
    private Player currentPlayer;
    private Inventory inventory;
    protected Map<Integer,PanelItem> panelItemList = new HashMap<Integer,PanelItem>();

    public BasePanel(int panelRows, String panelTitle) {
        inventory = Bukkit.createInventory(this, panelRows*9,panelTitle);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
    public void handlePanelItemClick(InventoryClickEvent event) {
        int clickedSlot = event.getSlot();
        panelItemList.get(clickedSlot).onClick(event);
    };
    public void showPanel(Player player) {
        currentPlayer = player;
        player.openInventory(this.inventory);
    }
    public void setPanelItem(int slotPosition, PanelItem panelItem) {
        this.inventory.setItem(slotPosition,panelItem.get());
        panelItemList.put(slotPosition,panelItem);
    }
    public void setPanelItem(PanelItem panelItem, int ...slotPositions) {
        Arrays.stream(slotPositions).forEach( slot -> {
            this.inventory.setItem(slot,panelItem.get());
            panelItemList.put(slot,panelItem);
        });
    }
    public void setPanelItem(PanelItem panelItem ) {
        ArrayList<Integer> slots = panelItem.getSlots();
        slots.forEach( slot -> {
            this.inventory.setItem(slot,panelItem.get());
            panelItemList.put(slot,panelItem);
        });
    }
    public void setPanelItem(PanelItem ...panelItem ) {
        for (PanelItem item : panelItem) {
            ArrayList<Integer> slots = item.getSlots();
            slots.forEach( slot -> {
                this.inventory.setItem(slot,item.get());
                panelItemList.put(slot,item);
            });
        }
    }

}
