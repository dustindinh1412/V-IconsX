package com.dustin.viconsx.guis;

import com.dustin.viconsx.utils.gui.BasePanel;
import com.dustin.viconsx.utils.gui.PanelItem;
import com.dustin.viconsx.utils.gui.PanelSlotType;
import org.bukkit.Bukkit;
import org.bukkit.Material;

public class IconsPanel extends BasePanel {

    public IconsPanel() {
        super(6, "Magic apple panel!");

        PanelItem helloButton = new PanelItem(Material.APPLE)
                .setName("This is a magic apple!")
                .setLore("", "Click to listen a lovely quote!")
                .setSlots(45)
                .setAction( event -> {
                    Bukkit.getConsoleSender().sendMessage("Du ma may");
                    event.setCancelled(true);
                });

        PanelItem border = new PanelItem(Material.BLACK_STAINED_GLASS_PANE)
                .setName("")
                .setSlots(PanelSlotType.BORDER_AROUND)
                .setAction( event -> {
                    event.setCancelled(true);
                });

        this.setPanelItem(helloButton,border);
    }

}
