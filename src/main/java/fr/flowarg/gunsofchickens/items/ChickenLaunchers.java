package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.entity.EntityChickenTNTPrimed;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class ChickenLaunchers extends ItemBase
{

    public ChickenLaunchers(String name)
    {
        super(name);
        setMaxDamage(4);
        setMaxStackSize(1);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (playerIn.getActiveHand() == EnumHand.MAIN_HAND)
        {
            Random random = new Random();
            RayTraceResult rayTraceResult = playerIn.rayTrace(ConfigHandler.tntReachDistance + random.nextInt(ConfigHandler.tntReachDistancechDistancePlus), 1);

            EntityChickenTNTPrimed entityChickenTNTPrimed = new EntityChickenTNTPrimed(worldIn);

            entityChickenTNTPrimed.setPosition(rayTraceResult.getBlockPos().getX(), rayTraceResult.getBlockPos().getY() + random.nextInt(5), rayTraceResult.getBlockPos().getZ());
            worldIn.spawnEntity(entityChickenTNTPrimed);
            worldIn.playSound(null, entityChickenTNTPrimed.posX, entityChickenTNTPrimed.posY, entityChickenTNTPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 100, 1f);
            playerIn.getHeldItemMainhand().damageItem(1, playerIn);
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }


}