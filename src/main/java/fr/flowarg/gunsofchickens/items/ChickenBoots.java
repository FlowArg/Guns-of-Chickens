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

public class ChickenBoots extends ItemArmor implements IHasModel
{
    public ChickenBoots(String name, ArmorMaterial materialIn, int renderIndexIn)
    {
        super(materialIn, renderIndexIn, EntityEquipmentSlot.FEET);
        this.setRegistryName(name).setUnlocalizedName(name);

        setCreativeTab(Main.MOD_TAB_ITEMS);

        setMaxStackSize(1);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(player.inventory.armorInventory.get(0)!=null)
        {
            ItemStack boots = player.inventory.armorInventory.get(0);
            if(boots.getItem()== ItemInit.CHICKEN_BOOTS);
            {
                player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 5, 1));
            }
        }
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}