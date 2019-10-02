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

public class ChickenDiamondLeggings extends ItemArmor implements IHasModel
{
    public ChickenDiamondLeggings(String name, ArmorMaterial materialIn, int renderIndexIn)
    {
        super(materialIn, renderIndexIn, EntityEquipmentSlot.LEGS);
        this.setRegistryName(name).setUnlocalizedName(name);

        setCreativeTab(Main.MOD_TAB_ITEMS);

        setMaxStackSize(1);

        UtilObjects.registerItem(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 5, 2));
        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 5, 1));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
