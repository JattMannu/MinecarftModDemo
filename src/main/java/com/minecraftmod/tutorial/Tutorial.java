package com.minecraftmod.tutorial;

import com.minecraftmod.tutorial.init.*;
import com.minecraftmod.tutorial.potions.PotionJumpBoost;
import com.minecraftmod.tutorial.proxy.CommonProxy;
import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

//This is an Interface.
@Mod(
        modid = Reference.MOD_ID,
        name = Reference.NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.ACCEPTED_VERSION
        )
public class Tutorial {

    @Mod.Instance
    public static Tutorial instance;

    @SidedProxy(
            clientSide = Reference.CLIENT_PROXY_CLASS,
            serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public Tutorial(){
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Init all the mod items and blocks
        ModItems.init();
        ModBlocks.init();
        // The function must be static.....
        MinecraftForge.EVENT_BUS.register(ModItems.class);
        MinecraftForge.EVENT_BUS.register(ModBlocks.class);
        MinecraftForge.EVENT_BUS.register(PotionJumpBoost.class);
        // The function is not STATIC
        //MinecraftForge.EVENT_BUS.register(new ModItems());
        System.out.println("preInit");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
        GameRegistry.registerTileEntity(TileEntityCombustionEngine.class,Reference.MOD_ID +"TileEntityCombustionEngine");
        System.out.println("init");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        System.out.println("postInit");
    }

}
