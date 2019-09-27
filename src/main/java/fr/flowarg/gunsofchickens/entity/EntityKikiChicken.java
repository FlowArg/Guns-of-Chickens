package fr.flowarg.gunsofchickens.entity;

import com.google.common.collect.Sets;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import java.util.Set;

public class EntityKikiChicken extends EntityChicken
{
    private static final Set<Item> TEMPTATION_ITEMS = Sets.newHashSet(ItemInit.CHICKEN_INGOT, ItemInit.CHICKEN_DIAMOND, Item.getItemFromBlock(BlockInit.CHICKEN_BLOCK), Item.getItemFromBlock(BlockInit.CHICKEN_DIAMOND_BLOCK), ItemInit.ULTIMATE_INGOT, Item.getItemFromBlock(BlockInit.ULTIMATE_BLOCK));

    public EntityKikiChicken(World worldIn)
    {
        super(worldIn);
        this.setSize(0.4F,0.7F);
    }

    @Override
    protected void initEntityAI()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 3.4D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(1, new EntityAITempt(this, 0.70021546D, false, TEMPTATION_ITEMS));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.5D));
        this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    @Override
    public float getEyeHeight()
    {
        return this.height;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
    }

    @Override
    protected ResourceLocation getLootTable()
    {
        return new ResourceLocation(References.MODID, "chicken/kiki");
    }

    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return TEMPTATION_ITEMS.contains(stack.getItem());
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return super.getAmbientSound();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source)
    {
        return super.getHurtSound(source);
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return super.getDeathSound();
    }

    @Override
    public EntityKikiChicken createChild(EntityAgeable ageable)
    {
        return new EntityKikiChicken(world);
    }
}