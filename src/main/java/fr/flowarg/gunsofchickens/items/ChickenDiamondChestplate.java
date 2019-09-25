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
    public ChickenDiamondChestplate(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name).setUnlocalizedName(name);

        setCreativeTab(Main.modtabItems);

        setMaxStackSize(1);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(player.inventory.armorInventory.get(2)!=null)
        {
            ItemStack chestplate = player.inventory.armorInventory.get(2);
            if(chestplate.getItem() == ItemInit.chicken_diamond_chestplate);
            {
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 5, 1));
                player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 5, 1));
            }
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}

