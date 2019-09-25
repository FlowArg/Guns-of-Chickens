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

public class ChickenHelmet extends ItemArmor implements IHasModel
{
    public ChickenHelmet(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
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
        if(player.inventory.armorInventory.get(3)!=null)
        {
            ItemStack helmet = player.inventory.armorInventory.get(3);
            if(helmet.getItem()== ItemInit.chicken_helmet);
            {
                player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 5, 0));
            }
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
