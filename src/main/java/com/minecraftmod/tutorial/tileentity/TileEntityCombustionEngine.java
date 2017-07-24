package com.minecraftmod.tutorial.tileentity;

import javafx.scene.paint.Material;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

public class TileEntityCombustionEngine extends TileEntity  implements IInventory {

    private float amountAir = 0;
    private float amountfuel = 0;
    private float sparkPlugTiming = 0;
    private boolean isEngineRunning = false;

    private static final int  maxFuel = 4;
    private ItemStack[] inventory;
    private String customName;

    public TileEntityCombustionEngine() {
        this.inventory = new ItemStack[this.getSizeInventory()];
        for(int i = 0 ; i < this.getSizeInventory(); i++ ){
            this.inventory[i] = new ItemStack((Item)null);
        }
    }

    public String getCustomName() {
        return this.customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

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
        //Ensure that the code is trigger at server side.
        if( !world.isRemote && canRemoveFuel() )
            --amountfuel;
        return amountfuel;
    }

    public void startEngine(){
        isEngineRunning = true;
    }

    public void stopEngine(){
        isEngineRunning = false;
    }

    public boolean isEngineRunning(){
        return isEngineRunning;
    }

    public void  toggleEngine(){
        if(world.isRemote)return;
        isEngineRunning  = !isEngineRunning;
    }

    //This saving data to file and loading it when the ever starts again.
    //I suppose if we do not do this will we not be able to save the information.
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setFloat("amountAir",amountAir);
        compound.setFloat("amountfuel",amountfuel);
        compound.setFloat("sparkPlugTiming",sparkPlugTiming);
        compound.setBoolean("isEngineRunning",isEngineRunning);

        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.amountAir = compound.getFloat("amountAir");
        this.amountfuel = compound.getFloat("amountfuel");
        this.sparkPlugTiming = compound.getFloat("sparkPlugTiming");
        this.isEngineRunning = compound.getBoolean("isEngineRunning");

    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "container.tutorial_tile_entity";
    }

    @Override
    public boolean hasCustomName() {
        return this.customName != null && !this.customName.equals("");
    }


    @Override
    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    @Override
    public int getSizeInventory() {
        return 9;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStackInSlot(int index) {
        if (index < 0 || index >= this.getSizeInventory())
            return null;
        return this.inventory[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (this.getStackInSlot(index) != null) {
            ItemStack itemstack;

            if (this.getStackInSlot(index).getCount() <= count) {
                itemstack = this.getStackInSlot(index);
                this.setInventorySlotContents(index, null);
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.getStackInSlot(index).splitStack(count);

                if (this.getStackInSlot(index).getCount() <= 0) {
                    this.setInventorySlotContents(index, null);
                } else {
                    //Just to show that changes happened
                    this.setInventorySlotContents(index, this.getStackInSlot(index));
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return null;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        this.setInventorySlotContents(index, null);
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        if (index < 0 || index >= this.getSizeInventory())
            return;

       if (stack != null && stack.getCount() > this.getInventoryStackLimit())
            stack.setCount(this.getInventoryStackLimit());

        if (stack != null && stack.getCount() == 0)
            stack = null;

        this.inventory[index] = stack;
        this.markDirty();
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }


    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
        //return player.getDistanceSq(this.pos.getX() + 0.5f, yCoord + 0.5f, zCoord + 0.5f) <= 64;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        return true;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getSizeInventory(); i++)
            this.setInventorySlotContents(i, null);
    }
}
