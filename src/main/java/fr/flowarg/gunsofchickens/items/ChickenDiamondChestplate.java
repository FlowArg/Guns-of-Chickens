package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ChickenDiamondChestplate extends ItemArmor implements IHasModel
{
    public ChickenDiamondChestplate(String name, ArmorMaterial materialIn, int renderIndexIn)
    {
        super(materialIn, renderIndexIn, EntityEquipmentSlot.CHEST);
        this.setRegistryName(name).setUnlocalizedName(name);

        setCreativeTab(Main.MOD_TAB_ITEMS);

        setMaxStackSize(1);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 5, 1));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}

