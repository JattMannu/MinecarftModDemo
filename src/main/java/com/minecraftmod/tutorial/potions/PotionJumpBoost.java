package com.minecraftmod.tutorial.potions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by mannu on 3/8/2017.
 */
public class PotionJumpBoost extends Potion {

    public PotionJumpBoost(boolean isBadEffectIn, int liquidColorIn){
        super(isBadEffectIn , liquidColorIn);
        this.setPotionName("manpreet.potion.jump");
        this.setRegistryName("manpreetPotionJumpBoost");
    }


    public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn, AbstractAttributeMap attributeMapIn, int amplifier)
    {
        super.removeAttributesModifiersFromEntity(entityLivingBaseIn, attributeMapIn, amplifier);

        if (entityLivingBaseIn.getHealth() > entityLivingBaseIn.getMaxHealth())
        {
            entityLivingBaseIn.setHealth(entityLivingBaseIn.getMaxHealth());
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Potion> event){
        System.out.println("registerPotions");
        event.getRegistry().registerAll(new PotionJumpBoost(false, 1));
    }

}
