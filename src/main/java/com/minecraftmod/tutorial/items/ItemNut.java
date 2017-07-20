package com.minecraftmod.tutorial.items;

import com.minecraftmod.tutorial.Reference;
import net.minecraft.item.Item;

public class ItemNut extends Item {

    public ItemNut(){
        setUnlocalizedName(Reference.MechItems.NUT.getUnlocalizedName());
        setRegistryName(Reference.MechItems.NUT.getRegistryName());
    }
}
