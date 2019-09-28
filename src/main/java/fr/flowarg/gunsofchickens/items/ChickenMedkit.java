package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ChickenMedkit extends ItemBase
{
    public ChickenMedkit(String name)
    {
        super(name);
        setMaxDamage(9);
        setMaxStackSize(1);
        setCreativeTab(Main.MOD_TAB_UTILS);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.getHeldItemMainhand().damageItem(1, playerIn);
        playerIn.heal(7f);

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
