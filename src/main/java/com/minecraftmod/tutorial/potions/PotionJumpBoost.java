package com.minecraftmod.tutorial.potions;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AbstractAttributeMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
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
        this.registerPotionAttributeModifier(SharedMonsterAttributes.MAX_HEALTH,"92AEAA56-376B-4498-935B-2F7F68070635", 0.20000000298023224D, 2);
        this.setBeneficial();
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

    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
        if (entityLivingBaseIn.getHealth() > 1.0F)
        {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
        }

    }

}
