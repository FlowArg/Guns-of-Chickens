package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ChickenMiningApple extends ItemFood implements IHasModel
{

    public ChickenMiningApple(String name, int amount, float saturation)
    {
        super(amount, saturation, false);

        setRegistryName(name).setUnlocalizedName(name);
        setMaxStackSize(16);

        setCreativeTab(Main.MOD_TAB_ITEMS);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 200*60, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 200*60, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 200*60, 2));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
