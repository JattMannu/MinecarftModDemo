package com.minecraftmod.tutorial.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCombustionEngine extends TileEntity {

    private float amountAir = 0;
    private float amountfuel = 0;
    private float sparkPlugTiming = 0;

    private static final int  maxFuel = 4;


    public float addFuel(){
        if(canAddFuel())
            ++amountfuel;

        return amountfuel;
    }

    private boolean canAddFuel(){
        return amountfuel < maxFuel;
    }

    private boolean canRemoveFuel(){
        return amountfuel > 0;
    }

    public float removeFuel(){
        if(canRemoveFuel())
            --amountfuel;
        return amountfuel;
    }


    //This saving data to file and loading it when the ever starts again.
    //I suppose if we do not do this will we not be able to save the information.
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setFloat("amountAir",amountAir);
        compound.setFloat("amountfuel",amountfuel);
        compound.setFloat("sparkPlugTiming",sparkPlugTiming);

        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.amountAir = compound.getFloat("amountAir");
        this.amountfuel = compound.getFloat("amountfuel");
        this.sparkPlugTiming = compound.getFloat("sparkPlugTiming");
    }
}
