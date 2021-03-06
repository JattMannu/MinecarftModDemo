package com.minecraftmod.tutorial.blocks;


import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.tileentity.TileEntityEngine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemCoal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTest extends Block implements ITileEntityProvider {

    public BlockTest(){
        super(Material.ANVIL);
        setUnlocalizedName(Reference.MechBlocks.TEST.getUnlocalizedName());
        setRegistryName(Reference.MechBlocks.TEST.getRegistryName());
    }

    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityEngine();
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityEngine ? (TileEntityEngine)worldIn.getTileEntity(pos) : null);
        if(!worldIn.isRemote && tileEntityCombustionEngine != null && playerIn.getHeldItemMainhand().getItem() == new ItemCoal())
            Minecraft.getMinecraft().player.sendChatMessage("onBlockActivated with Coal in hand");
        else
            Minecraft.getMinecraft().player.sendChatMessage("onBlockActivated trying to turn start or stop engine.");
        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX(), pos.getY(),pos.getZ(), 0.0D, 0.0D, 0.0D);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
}
