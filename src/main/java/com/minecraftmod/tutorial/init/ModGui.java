package com.minecraftmod.tutorial.init;

import com.minecraftmod.tutorial.containers.ContainerCombustionEngineTileEntity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;
import java.awt.*;

public class ModGui implements IGuiHandler{

    public static final int COMBUSTION_ENGINE = 0;
    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == COMBUSTION_ENGINE){
          // return new ContainerCombustionEngineTileEntity();
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}
