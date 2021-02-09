package com.pclogix.openicbmcontrol.proxy;

import com.pclogix.openicbmcontrol.common.gui.GuiProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    public void registerModels() {
    }

    protected void init() {
        NetworkRegistry.INSTANCE.registerGuiHandler(com.pclogix.openicbmcontrol.OpenICBMControl.instance, new GuiProxy());
    }
}
