package com.minecraftmod.tutorial.items;

import com.minecraftmod.tutorial.Reference;
import net.minecraft.item.Item;

public class ItemRadiator extends Item {

    public ItemRadiator(){
        setUnlocalizedName(Reference.MechItems.RADIATOR.getUnlocalizedName());
        setRegistryName(Reference.MechItems.RADIATOR.getRegistryName());
    }
}
