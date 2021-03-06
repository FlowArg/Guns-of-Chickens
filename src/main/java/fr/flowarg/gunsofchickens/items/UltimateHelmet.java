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

public class UltimateHelmet extends ItemArmor implements IHasModel
{
    public UltimateHelmet(String name, ArmorMaterial materialIn, int renderIndexIn)
    {
        super(materialIn, renderIndexIn, EntityEquipmentSlot.HEAD);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(Main.MOD_TAB_ITEMS);
        this.setMaxStackSize(1);

        UtilObjects.UtilItems.registerItem(ItemInit.ITEMS, this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 5, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 5, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 5, 20));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
