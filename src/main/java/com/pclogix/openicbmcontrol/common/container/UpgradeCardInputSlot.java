package com.pclogix.openicbmcontrol.common.container;

import com.pclogix.openicbmcontrol.common.items.ItemCard;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpgradeCardInputSlot extends BaseSlot implements ISlotToolTip {

    public UpgradeCardInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition);
    }

    @Override
    public boolean isItemValid(@Nonnull ItemStack stack) {
        if(!(stack.getItem() instanceof ItemCard)) {
            return false;
        }
        return true;
    }

    @Override
    public List<String> getTooltip(){
        return new ArrayList<>(Arrays.asList("Accepted Items:", "Tag"));
    }
}
