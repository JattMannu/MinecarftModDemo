package com.minecraftmod.tutorial.blocks;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.init.ModItems;
import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import com.minecraftmod.tutorial.tileentity.TileEntityEngine;
import com.minecraftmod.tutorial.utility.Logger;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemCoal;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.SidedProxy;

public class BlockCombustionEngine extends Block implements ITileEntityProvider {

    public BlockCombustionEngine(){
        super(Material.ANVIL);
        super.setHardness(1);
        setUnlocalizedName(Reference.MechBlocks.COMBUSTIONENGINE.getUnlocalizedName());
        setRegistryName(Reference.MechBlocks.COMBUSTIONENGINE.getRegistryName());
    }


    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
        super.onBlockClicked(worldIn, pos, playerIn);
        //Ensure the code runs Server side.
        if(worldIn.isRemote) return;

        System.out.println("worldIn.isRemote   =  "+worldIn.isRemote);
        TileEntityCombustionEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityCombustionEngine ? (TileEntityCombustionEngine)worldIn.getTileEntity(pos) : null);
        //If the tileEntity is null if continue we will null exception error.
        if(tileEntityCombustionEngine == null) return;

        String itemInHand = playerIn.getHeldItemMainhand().getItem().getUnlocalizedName();
        Minecraft.getMinecraft().player.sendChatMessage(itemInHand);

        switch (itemInHand){
            case "tile.air":
                Minecraft.getMinecraft().player.sendChatMessage("Trying to toggle engine.");
                Logger.spawnParticleDefault(worldIn, EnumParticleTypes.WATER_BUBBLE ,pos );
                tileEntityCombustionEngine.toggleEngine();
                return;
            case "item.coal":
                Minecraft.getMinecraft().player.sendChatMessage("Putting Fuel into Engine.");
                Logger.spawnParticleDefault(worldIn, EnumParticleTypes.SMOKE_LARGE , pos);
                return;
            default:
                Minecraft.getMinecraft().player.sendChatMessage("IGNORED");
                return;
        }

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityCombustionEngine();
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(worldIn.isRemote) return false;
        //This will trigger at client side.
        if(worldIn.isRemote)
            Minecraft.getMinecraft().player.sendChatMessage(this.getUnlocalizedName());

        TileEntityCombustionEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityCombustionEngine ? (TileEntityCombustionEngine)worldIn.getTileEntity(pos) : null);
        Minecraft.getMinecraft().player.sendChatMessage("Is Engine Running? " + tileEntityCombustionEngine.isEngineRunning()) ;
        return true;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState blockstate) {
        TileEntityCombustionEngine te = (TileEntityCombustionEngine) world.getTileEntity(pos);
        for(int i=0; i<te.getSizeInventory(); i++)
        {
            if(te.getStackInSlot(i) != null)
                dropBlockAsItem(world, pos, blockstate ,1);
        }
        super.breakBlock(world, pos, blockstate);

    }


    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if(stack.hasDisplayName())
            ((TileEntityCombustionEngine) worldIn.getTileEntity(pos)).setCustomName(stack.getDisplayName());
    }
}
