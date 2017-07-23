package com.minecraftmod.tutorial.blocks;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.init.ModItems;
import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import com.minecraftmod.tutorial.tileentity.TileEntityEngine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCombustionEngine extends Block implements ITileEntityProvider {

    public BlockCombustionEngine(){
        super(Material.ANVIL);
        //super.setHardness(1);
        setUnlocalizedName(Reference.MechBlocks.COMBUSTIONENGINE.getUnlocalizedName());
        setRegistryName(Reference.MechBlocks.COMBUSTIONENGINE.getRegistryName());
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);


        //This will trigger at client side.
        if(worldIn.isRemote)
            Minecraft.getMinecraft().player.sendChatMessage(this.getUnlocalizedName());
        System.out.println("BlockCombustionEngine's onBlockClicked trigger");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityCombustionEngine();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityCombustionEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityCombustionEngine ? (TileEntityCombustionEngine)worldIn.getTileEntity(pos) : null);
        if(!worldIn.isRemote && tileEntityCombustionEngine != null && playerIn.getHeldItemMainhand().getItem() == new ItemCoal())
            Minecraft.getMinecraft().player.sendChatMessage("onBlockActivated with Coal in hand");
        else
            Minecraft.getMinecraft().player.sendChatMessage("onBlockActivated trying to turn start or stop engine.");
        worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pos.getX()+0.5, pos.getY()+1.1,pos.getZ()+0.5, 0.0D, 0.0D, 0.0D);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }


}
