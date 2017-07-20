package com.minecraftmod.tutorial.items;

import com.minecraftmod.tutorial.Reference;
import net.minecraft.item.Item;

public class ItemBolt extends Item{

    public ItemBolt() {
        setUnlocalizedName(Reference.MechItems.BOLT.getUnlocalizedName());
        setRegistryName(Reference.MechItems.BOLT.getRegistryName());
    }
}
