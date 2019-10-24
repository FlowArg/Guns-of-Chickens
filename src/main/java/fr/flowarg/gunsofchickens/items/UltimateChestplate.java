package fr.flowarg.gunsofchickens.items;

import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class UltimateChestplate extends ItemArmor implements IHasModel
{
    public UltimateChestplate(String name, ArmorMaterial materialIn, int renderIndexIn)
    {
        super(materialIn, renderIndexIn, EntityEquipmentSlot.CHEST);
        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(Main.MOD_TAB_ITEMS);
        setMaxStackSize(1);

        UtilObjects.UtilItems.registerItem(ItemInit.ITEMS, this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5, 10));
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 5, 10));
        player.addPotionEffect(new PotionEffect(MobEffects.SATURATION, 5, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 20, 10));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
