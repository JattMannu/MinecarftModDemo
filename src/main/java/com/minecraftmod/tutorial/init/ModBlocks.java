package com.minecraftmod.tutorial.init;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.blocks.BlockCombustionEngine;
import com.minecraftmod.tutorial.blocks.BlockEngineBlock;
import com.minecraftmod.tutorial.blocks.BlockTest;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks implements iMod{

//Declare the the BLOCK here
    private static BlockEngineBlock blockEngineBlock;
    private static BlockCombustionEngine blockCombustionEngine;
    private static BlockTest blockTest;

    public static void init(){
        //Init the blocks
        blockEngineBlock = new BlockEngineBlock();
        blockCombustionEngine = new BlockCombustionEngine();
        blockTest = new BlockTest();
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        System.out.println("registerBlocks");
        event.getRegistry().registerAll(
                blockEngineBlock,
                blockCombustionEngine,
                blockTest);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
        // will MY_BLOCK have been injected at this point?
        System.out.println("registerItemBlocks");
        event.getRegistry().registerAll(
                new ItemBlock(blockEngineBlock).setRegistryName(blockEngineBlock.getRegistryName()),
                new ItemBlock(blockCombustionEngine).setRegistryName(blockCombustionEngine.getRegistryName()),
                new ItemBlock(blockTest).setRegistryName(blockTest.getRegistryName())
        );
    }


    public static void registerRenders(){
        System.out.println("registerRenders");
        registerRender(
                blockEngineBlock,
                blockCombustionEngine,
                blockTest
        );
    }

    public static void registerRender(Block... blocks){
        for (Block block: blocks) {
            System.out.println("registerRender : "+ block.getRegistryName());
            Minecraft
                    .getMinecraft()
                    .getRenderItem()
                    .getItemModelMesher()
                    .register(Item.getItemFromBlock(block) ,
                            0,
                            //new ModelResourceLocation(Reference.MOD_ID + ":"+block.getUnlocalizedName().substring(5),"inventory")
                            new ModelResourceLocation(block.getRegistryName(),"inventory")
                    );
        }
    }
}
