package com.dustin.viconsx.utils.gui;

import java.util.ArrayList;
import java.util.Arrays;

public enum PanelSlotType {
    BORDER_AROUND(0,1,2,3,4,5,6,7,8,9,17);

    PanelSlotType(Integer ...slots) {
        this.slots.addAll(Arrays.asList(slots));
    }
    private ArrayList<Integer> slots = new ArrayList<Integer>();
    public ArrayList<Integer> get() {
        return this.slots;
    }

}
