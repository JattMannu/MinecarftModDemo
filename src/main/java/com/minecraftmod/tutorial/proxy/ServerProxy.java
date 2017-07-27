package com.minecraftmod.tutorial.proxy;

import com.minecraftmod.tutorial.Tutorial;
import com.minecraftmod.tutorial.init.ModGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class ServerProxy implements CommonProxy{
    public void init(){
        NetworkRegistry.INSTANCE.registerGuiHandler(Tutorial.instance, new ModGuiHandler());
    }
}
