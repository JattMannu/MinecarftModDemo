package com.minecraftmod.tutorial.init;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.items.ItemBolt;
import com.minecraftmod.tutorial.items.ItemMyPotion;
import com.minecraftmod.tutorial.items.ItemNut;
import com.minecraftmod.tutorial.items.ItemRadiator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;



public class ModItems implements iMod{

    private static Item radiator;
    private static Item nut;
    private static Item bolt;
    private static Item potionJumpBoost;

    public static void init(){
        radiator = new ItemRadiator();
        nut = new ItemNut();
        bolt = new ItemBolt();
        potionJumpBoost = new ItemMyPotion();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        System.out.println("registerItems");
        event.getRegistry().registerAll(radiator , nut ,bolt, potionJumpBoost);
    }

    public static void registerRenders(){
        System.out.println("registerRenders");
        registerRender(radiator, nut ,bolt,potionJumpBoost );
    }

    public static void registerRender(Item... items){
       // ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        for (Item item: items) {
            System.out.println("registerRender : "+ item.getRegistryName());
            Minecraft
                    .getMinecraft()
                    .getRenderItem()
                    .getItemModelMesher()
                    .register(item ,
                            0,
                            //new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5),"inventory")
                            new ModelResourceLocation(item.getRegistryName(),"inventory")
                    );
        }
    }

    //private void registerItem(Item item) {
     //   ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":"+item.getUnlocalizedName().substring(5), "inventory"));
    //}
}
