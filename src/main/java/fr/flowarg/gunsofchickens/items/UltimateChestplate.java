package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
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
        setCreativeTab(Main.modtabItems);
        setMaxStackSize(1);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5, 10));
        player.addPotionEffect(new PotionEffect(MobEffects.LUCK, 5, 10));
        //player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 5, 1));
        player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 5, 2));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
