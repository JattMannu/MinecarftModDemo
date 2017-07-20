package com.minecraftmod.tutorial;

import com.minecraftmod.tutorial.init.ModItems;
import com.minecraftmod.tutorial.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
        //MinecraftForge.EVENT_BUS.register(ModItems.class);
        MinecraftForge.EVENT_BUS.register(new ModItems());
        System.out.println("preInit");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init();
        System.out.println("init");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        System.out.println("postInit");
    }



}
