package com.pclogix.openicbmcontrol.common.items;

import com.pclogix.openicbmcontrol.OpenICBMControl;
import com.pclogix.openicbmcontrol.common.ContentRegistry;
import net.minecraft.item.Item;

public abstract class ItemOCBase extends Item {

    ItemOCBase(String name) {
        setUnlocalizedName("openicbmcontrol." + name);
        setRegistryName(OpenICBMControl.MODID, name);
        setCreativeTab(ContentRegistry.creativeTab);
    }
}
