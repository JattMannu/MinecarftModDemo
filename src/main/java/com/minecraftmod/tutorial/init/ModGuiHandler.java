package com.minecraftmod.tutorial.init;

import com.minecraftmod.tutorial.containers.ContainerCombustionEngineTileEntity;
import com.minecraftmod.tutorial.gui.GuiCombustionEngine;
import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;
import java.awt.*;

public class ModGuiHandler implements IGuiHandler{

    public static final int COMBUSTION_ENGINE = 0;
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COMBUSTION_ENGINE)
            return new ContainerCombustionEngineTileEntity(player.inventory , (TileEntityCombustionEngine)world.getTileEntity(new BlockPos(x,y,z)) );
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == COMBUSTION_ENGINE)
            return new GuiCombustionEngine(player.inventory , (TileEntityCombustionEngine)world.getTileEntity(new BlockPos(x,y,z)) );
        return null;
    }
}
