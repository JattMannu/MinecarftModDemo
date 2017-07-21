package com.minecraftmod.tutorial.blocks;


import com.minecraftmod.tutorial.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEngineBlock extends Block {

    public BlockEngineBlock() {
        super(Material.ANVIL);
        setUnlocalizedName(Reference.MechBlocks.ENGINEBLOCK.getUnlocalizedName());
        setRegistryName(Reference.MechBlocks.ENGINEBLOCK.getRegistryName());
    }
}
