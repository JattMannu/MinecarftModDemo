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
        if(worldIn.isRemote) return;
        //This will trigger at client side.
        if(worldIn.isRemote)
            Minecraft.getMinecraft().player.sendChatMessage(this.getUnlocalizedName());

        TileEntityCombustionEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityCombustionEngine ? (TileEntityCombustionEngine)worldIn.getTileEntity(pos) : null);
        Minecraft.getMinecraft().player.sendChatMessage("Is Engine Running?  and worldIn.isRemote" + tileEntityCombustionEngine.isEngineRunning()+worldIn.isRemote) ;

    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityCombustionEngine();
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        //Ensure the code runs Server side.
        if(worldIn.isRemote) return false;

        System.out.println("worldIn.isRemote   =  "+worldIn.isRemote);
        TileEntityCombustionEngine tileEntityCombustionEngine =
                (worldIn.getTileEntity(pos) instanceof  TileEntityCombustionEngine ? (TileEntityCombustionEngine)worldIn.getTileEntity(pos) : null);
        //If the tileEntity is null if continue we will null exception error.
        if(tileEntityCombustionEngine == null) return false;

        String itemInHand = playerIn.getHeldItemMainhand().getItem().getUnlocalizedName();
        Minecraft.getMinecraft().player.sendChatMessage(itemInHand);

        switch (itemInHand){
            case "tile.air":
                Minecraft.getMinecraft().player.sendChatMessage("Trying to toggle engine.");
                Logger.spawnParticleDefault(worldIn, EnumParticleTypes.WATER_BUBBLE ,pos );
                tileEntityCombustionEngine.toggleEngine();
                return true;
            case "item.coal":
                Minecraft.getMinecraft().player.sendChatMessage("Putting Fuel into Engine.");
                Logger.spawnParticleDefault(worldIn, EnumParticleTypes.SMOKE_LARGE , pos);
                return true;
            default:
                Minecraft.getMinecraft().player.sendChatMessage("IGNORED");
                return false;
        }
        

    }



}
