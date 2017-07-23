package com.minecraftmod.tutorial.utility;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Logger {

    public static void spawnParticleDefault(World worldIn, EnumParticleTypes enumParticleTypes , BlockPos pos){
        worldIn.spawnParticle(enumParticleTypes, pos.getX()+0.5, pos.getY()+1.1,pos.getZ()+0.5, 0.0D, 0.0D, 0.0D);
    }
}
