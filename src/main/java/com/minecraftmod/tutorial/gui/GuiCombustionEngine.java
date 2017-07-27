package com.minecraftmod.tutorial.gui;

import com.minecraftmod.tutorial.Reference;
import com.minecraftmod.tutorial.containers.ContainerCombustionEngineTileEntity;
import com.minecraftmod.tutorial.tileentity.TileEntityCombustionEngine;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiCombustionEngine extends GuiContainer{

    public static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/blocks/engineblock.png");
    private TileEntityCombustionEngine te;
    private IInventory playerInv;

    public GuiCombustionEngine(IInventory playerInv , TileEntityCombustionEngine te){
        super(new ContainerCombustionEngineTileEntity(playerInv , te));

        this.xSize = 175;
        this.ySize = 166;

        this.te =te;
        this.playerInv = playerInv;

        System.out.println("Trying to open GUI");
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F); //Grey background
        this.mc.getTextureManager().bindTexture(TEXTURE); //Binds the texture for rendering
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize); //Draws our texture
    }
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.te.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, 88 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);            //#404040
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);      //#404040
    }
}
