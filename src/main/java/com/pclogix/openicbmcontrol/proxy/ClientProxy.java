package com.pclogix.openicbmcontrol.proxy;

import com.pclogix.openicbmcontrol.common.ContentRegistry;
import com.pclogix.openicbmcontrol.common.items.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void init() {
        super.init();
        Minecraft mc = Minecraft.getMinecraft();
        mc.getItemColors().registerItemColorHandler(new CardColorHandler(), ItemT1Card.DEFAULTSTACK.getItem());
        mc.getItemColors().registerItemColorHandler(new CardColorHandler(), ItemT2Card.DEFAULTSTACK.getItem());
        mc.getItemColors().registerItemColorHandler(new CardColorHandler(), ItemT3Card.DEFAULTSTACK.getItem());
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void registerModels() {
        for(Block block : ContentRegistry.modBlocks)
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));

        for(ItemStack itemStack : ContentRegistry.modBlocksWithItem.values())
            ModelLoader.setCustomModelResourceLocation(itemStack.getItem(), 0, new ModelResourceLocation(itemStack.getItem().getRegistryName().toString()));

        for(ItemStack itemStack : ContentRegistry.modItems)
            ModelLoader.setCustomModelResourceLocation(itemStack.getItem(), 0, new ModelResourceLocation(itemStack.getItem().getRegistryName().toString()));
    }

    private static class CardColorHandler implements IItemColor {
        private CardColorHandler() {}

        @Override
        public int colorMultiplier(ItemStack stack, int tintIndex) {
            // TODO Auto-generated method stub
            return tintIndex == 0 ? 0xFFFFFF : new ItemCard.CardTag(stack.getTagCompound()).color;
        }
    }
}