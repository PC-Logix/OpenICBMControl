package com.pclogix.openicbmcontrol.common;

import com.pclogix.openicbmcontrol.common.blocks.BlockLauncherInterface;
import com.pclogix.openicbmcontrol.common.items.*;
import com.pclogix.openicbmcontrol.common.tileentity.ICBMControllerTileEntity;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;


import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Mod.EventBusSubscriber
public class ContentRegistry {
    public static CreativeTabs creativeTab = new CreativeTabs("tabopencargo") {
        public @Nonnull ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(BlockLauncherInterface.DEFAULTITEM));
        }

        public @Nonnull String getTranslatedTabLabel() {
            return new TextComponentTranslation("itemGroup.openicbmcontrol.tabopenicbmcontrol").getUnformattedText();
        }
    };

    // holds a list of normal mod blocks
    public static final HashSet<Block> modBlocks = new HashSet<>();

    // holds a list of mod blocks that have a specific custom Item like the doors
    public static final HashMap<Block, ItemStack> modBlocksWithItem = new HashMap<>();

    // holds a list of normal mod items
    public static final HashSet<ItemStack> modItems = new HashSet<>();

    static {
        modBlocks.add(BlockLauncherInterface.DEFAULTITEM = new BlockLauncherInterface());

        modItems.add(ItemT1Card.DEFAULTSTACK = new ItemStack(new ItemT1Card()));
        modItems.add(ItemT2Card.DEFAULTSTACK = new ItemStack(new ItemT2Card()));
        modItems.add(ItemT3Card.DEFAULTSTACK = new ItemStack(new ItemT3Card()));
    }


    // Called on mod preInit()
    public static void preInit() {
        registerEvents();
    }

    private static void registerEvents() {

    }

    //Called on mod init()
    public static void init() {

    }


    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event){
    }

    @SubscribeEvent
    public static void addBlocks(RegistryEvent.Register<Block> event) {
        for(Block block : modBlocks) {
            com.pclogix.openicbmcontrol.OpenICBMControl.LOGGER.info("Registering: " + block.getUnlocalizedName());
            event.getRegistry().register(block);
        }

        for(Block block : modBlocksWithItem.keySet())
            event.getRegistry().register(block);

        registerTileEntity(ICBMControllerTileEntity.class, BlockLauncherInterface.NAME);
    }

    private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key) {
        // For better readability
        GameRegistry.registerTileEntity(tileEntityClass, new ResourceLocation(com.pclogix.openicbmcontrol.OpenICBMControl.MODID, key));
    }

    @SuppressWarnings("ConstantConditions")
    @SubscribeEvent
    public static void addItems(RegistryEvent.Register<Item> event) {

        for(Block block : modBlocks)
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));

        for(Map.Entry<Block, ItemStack> entry : modBlocksWithItem.entrySet())
            event.getRegistry().register(entry.getValue().getItem());

        for(ItemStack itemStack : modItems)
            event.getRegistry().register(itemStack.getItem());
    }
}

