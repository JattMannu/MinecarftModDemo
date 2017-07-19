package com.minecraftmod.tutorial;

import com.minecraftmod.tutorial.init.ModItems;
import com.minecraftmod.tutorial.proxy.CommonProxy;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

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
        //For Static
        MinecraftForge.EVENT_BUS.register(ModItems.class);
    }

    @Mod.EventHandler
    public void preInit(FMLInitializationEvent event){
        System.out.println("preInit");
        ModItems.init();
        //For instance
        //MinecraftForge.EVENT_BUS.register(new ModItems());
        proxy.init();
      // ModItems.registerRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        System.out.println("init");

    }

    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event){
        System.out.println("postInit");
    }



}
