package com.minecraftmod.tutorial.blocks;


import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.tileentity.TileEntityEngine;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEngineBlock extends Block implements ITileEntityProvider {

    public BlockEngineBlock() {
        super(Material.ANVIL);
        super.setHardness(1);
        setUnlocalizedName(Reference.MechBlocks.ENGINEBLOCK.getUnlocalizedName());
        setRegistryName(Reference.MechBlocks.ENGINEBLOCK.getRegistryName());
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        System.out.println("BlockEngineBlock's onBlockActivated trigger");
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        Minecraft.getMinecraft().player.sendChatMessage(this.getUnlocalizedName());
        System.out.println("BlockEngineBlock's onBlockClicked trigger");
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockDestroyedByPlayer(worldIn, pos, state);
        this.dropBlockAsItem(worldIn, pos, state , 1);
        System.out.println("BlockEngineBlock's onBlockDestroyedByPlayer trigger");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityEngine();
    }

}
