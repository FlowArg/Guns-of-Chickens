package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ChickenHeart extends ItemBase
{
    public ChickenHeart(String name)
    {
        super(name);
        setCreativeTab(Main.MOD_TAB_UTILS);
        setMaxStackSize(20);
        setMaxDamage(0);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        playerIn.getHeldItemMainhand().damageItem(1, playerIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
