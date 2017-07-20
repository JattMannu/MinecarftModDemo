package com.minecraftmod.tutorial.init;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.Tutorial;
import com.minecraftmod.tutorial.items.ItemRadiator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


public class ModItems {

    public static Item radiator = new ItemRadiator();

    public static void init(){
        radiator = new ItemRadiator();
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event){
        System.out.println("registerItems : radiator");
        event.getRegistry().registerAll(radiator);
    }

    public static void registerRenders(){
        registerRender(radiator);
    }

    public static void registerRender(Item item){
       // ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        Minecraft
                .getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(item ,
                        0,
                         new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5),"inventory")
                );
    }

    //private void registerItem(Item item) {
     //   ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));
    //}
}
