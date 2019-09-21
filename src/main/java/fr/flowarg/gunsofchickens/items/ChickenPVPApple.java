package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

public class ChickenPVPApple extends ItemFood implements IHasModel
{
    public ChickenPVPApple(String name, int amount, float saturation, boolean isWolfFood)
    {
        super(amount, saturation, isWolfFood);

        setRegistryName(name).setUnlocalizedName(name);

        setMaxStackSize(16);

        setCreativeTab(Main.modtabItems);

        ItemInit.ITEMS.add(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        int min = 1;
        int max = 3;
        Random random = new Random();
        int randomNumber = random.nextInt(max - min) + 1;

        if(randomNumber == 3)
        {
            if(!worldIn.isRemote)
            {
                player.clearActivePotions();
            }
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 60*60, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 60*60, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.HUNGER, 20*60, 250));
        }
        else if(randomNumber == 1)
        {

            if(!worldIn.isRemote)
            {
                player.clearActivePotions();
            }
            player.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 60*60, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 60*60, 1));
            player.addPotionEffect(new PotionEffect(MobEffects.INSTANT_HEALTH, 1, 2));
            player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 20*60, 1));
        }
        else if(randomNumber == 2)
        {
            if(!worldIn.isRemote)
            {
                player.clearActivePotions();
                player.sendMessage(new TextComponentString("[GOCMOD] Effect cleared !"));
            }
        }

    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}