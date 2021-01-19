package com.dustin.viconsx.utils.gui;

import com.dustin.viconsx.interfaces.PanelClickAction;
import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class PanelItem {

    private ItemStack item;
    private ItemMeta meta;
    private ArrayList<Integer> slots = new ArrayList<Integer>();
    private PanelClickAction action = (event) -> {};

    public PanelItem(Material material) {
        item = new ItemStack(material);
        meta = item.getItemMeta();
    }

    public PanelItem setAction(PanelClickAction action) {
        this.action = action;
        return this;
    }

    public void onClick(InventoryClickEvent event) {
        Bukkit.getConsoleSender().sendMessage("Clicked! ");
        action.call(event);
    }
    public ItemStack get() {
        return this.item;
    }
    public PanelItem setName(@NotNull String name) {
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return this;
    }
    public PanelItem setLore(String ...newLore) {
        this.meta.setLore(Arrays.asList(newLore));
        this.item.setItemMeta(meta);
        return this;
    };
    public PanelItem setSlots(Integer ...slots) {
        this.slots.addAll(Arrays.asList(slots));
        return this;
    };
    public PanelItem setSlots(PanelSlotType slot) {
       this.slots.addAll(slot.get());
        return this;
    };
    public ArrayList<Integer> getSlots() {
        return this.slots;
    }
}
