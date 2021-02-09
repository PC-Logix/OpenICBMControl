package com.pclogix.openicbmcontrol.common.gui;

import com.pclogix.openicbmcontrol.common.container.ICBMControllerContainer;
import com.pclogix.openicbmcontrol.common.tileentity.ICBMControllerTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof ICBMControllerTileEntity) {
            return new ICBMControllerContainer(player.inventory, (ICBMControllerTileEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        if (te instanceof ICBMControllerTileEntity) {
            ICBMControllerTileEntity containerTileEntity = (ICBMControllerTileEntity) te;
            return new ICBMControllerGui(containerTileEntity, new ICBMControllerContainer(player.inventory, containerTileEntity));
        }
        return null;
    }
}
