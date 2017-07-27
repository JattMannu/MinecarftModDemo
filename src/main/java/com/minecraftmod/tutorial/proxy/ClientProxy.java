package com.minecraftmod.tutorial.proxy;

import com.minecraftmod.tutorial.Tutorial;
import com.minecraftmod.tutorial.init.ModGuiHandler;
import com.minecraftmod.tutorial.init.ModBlocks;
import com.minecraftmod.tutorial.init.ModItems;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ClientProxy implements CommonProxy{

    public void init(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
        NetworkRegistry.INSTANCE.registerGuiHandler(Tutorial.instance,new ModGuiHandler());
    }
}
