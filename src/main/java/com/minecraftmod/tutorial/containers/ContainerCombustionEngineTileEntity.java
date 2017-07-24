package com.minecraftmod.tutorial.containers;

import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import scala.tools.nsc.doc.model.Public;

public class ContainerCombustionEngineTileEntity extends Container {

    private TileEntityCombustionEngine te;
    private IItemHandler handler;


    public ContainerCombustionEngineTileEntity(IInventory playerInv, TileEntityCombustionEngine te) {

        this.te = te;
        //Gets the inventory from our tile entity
        this.handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

        //Our tile entity slots
        this.addSlotToContainer(new SlotItemHandler(handler, 0, 62, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 1, 80, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 2, 98, 17));
        this.addSlotToContainer(new SlotItemHandler(handler, 3, 62, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 4, 80, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 5, 98, 35));
        this.addSlotToContainer(new SlotItemHandler(handler, 6, 62, 53));
        this.addSlotToContainer(new SlotItemHandler(handler, 7, 80, 53));
        this.addSlotToContainer(new SlotItemHandler(handler, 8, 98, 53));

        //The player's inventory slots
        int xPos = 8; //The x position of the top left player inventory slot on our texture
        int yPos = 84; //The y position of the top left player inventory slot on our texture

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return false;
    }
}
