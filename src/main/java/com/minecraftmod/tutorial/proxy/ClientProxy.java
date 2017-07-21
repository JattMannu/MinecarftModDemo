package com.minecraftmod.tutorial.proxy;

import com.minecraftmod.tutorial.init.ModBlocks;
import com.minecraftmod.tutorial.init.ModItems;

public class ClientProxy implements CommonProxy{

    public void init(){
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }
}
