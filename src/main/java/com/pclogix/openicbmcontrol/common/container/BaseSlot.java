package com.pclogix.openicbmcontrol.common.container;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BaseSlot extends SlotItemHandler {

    BaseSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public void onSlotChanged() {
        super.onSlotChanged();
    }
}
