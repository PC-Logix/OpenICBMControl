package com.pclogix.openicbmcontrol;

import com.pclogix.openicbmcontrol.common.ContentRegistry;
import com.pclogix.openicbmcontrol.proxy.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod.EventBusSubscriber
@Mod(modid = com.pclogix.openicbmcontrol.OpenICBMControl.MODID, name = com.pclogix.openicbmcontrol.OpenICBMControl.NAME, version = com.pclogix.openicbmcontrol.OpenICBMControl.VERSION,
        dependencies = "required-after:opencomputers;")
public
class OpenICBMControl
{
    public static final String MODID = "openicbmcontrol";
    public static final String NAME = "OpenICBMControl";
    public static final String VERSION = "1.0.2";

    @SidedProxy(clientSide = "com.pclogix.openicbmcontrol.proxy.ClientProxy", serverSide = "com.pclogix.openicbmcontrol.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static com.pclogix.openicbmcontrol.OpenICBMControl instance;

    public static final Logger LOGGER = LogManager.getLogger(com.pclogix.openicbmcontrol.OpenICBMControl.MODID);

    public static ContentRegistry contentRegistry = new ContentRegistry();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        LOGGER.info(NAME + " FMLPreInitializationEvent");
        proxy.preInit(e);
        ContentRegistry.preInit();
        MinecraftForge.EVENT_BUS.register(contentRegistry);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
        ContentRegistry.init();
        LOGGER.info(NAME + " FMLInitializationEvent");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
        LOGGER.info(NAME + " FMLPostInitializationEvent");
    }

    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent event) {
        proxy.registerModels();
    }

}
