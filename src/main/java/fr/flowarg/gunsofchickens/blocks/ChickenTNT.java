package fr.flowarg.gunsofchickens.blocks;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.entity.EntityChickenTNTPrimed;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ChickenTNT extends BlockTNT implements IHasModel
{
    public ChickenTNT(String name)
    {
        this.setRegistryName(name).setUnlocalizedName(name);

        this.setCreativeTab(Main.MOD_TAB_BLOCKS);

        UtilObjects.getInstance().registerBlock(this);
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn)
    {
        if (!worldIn.isRemote)
        {
            EntityChickenTNTPrimed entityChickenTNTPrimed = new EntityChickenTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), explosionIn.getExplosivePlacedBy());
            entityChickenTNTPrimed.setFuse((short)(worldIn.rand.nextInt(entityChickenTNTPrimed.getFuse() / 4) + entityChickenTNTPrimed.getFuse() / 8));
            worldIn.spawnEntity(entityChickenTNTPrimed);
        }
    }

    @Override
    public void explode(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase igniter)
    {
        if(!worldIn.isRemote)
        {
            if (((Boolean)state.getValue(EXPLODE)).booleanValue())
            {
                EntityChickenTNTPrimed entityChickenTNTPrimed = new EntityChickenTNTPrimed(worldIn, (double)((float)pos.getX() + 0.5F), (double)pos.getY(), (double)((float)pos.getZ() + 0.5F), igniter);
                worldIn.spawnEntity(entityChickenTNTPrimed);
                worldIn.playSound((EntityPlayer)null, entityChickenTNTPrimed.posX, entityChickenTNTPrimed.posY, entityChickenTNTPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        ItemStack itemstack = playerIn.getHeldItem(hand);

        if (!itemstack.isEmpty() && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE))
        {
            return false;
        }
        else if(!itemstack.isEmpty() && itemstack.getItem() == ItemInit.CHICKEN_WITH_TNT)
        {
            this.explode(worldIn, pos, state.withProperty(EXPLODE, Boolean.valueOf(true)), playerIn);
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 11);
            if (!playerIn.isCreative())
            {
                itemstack.damageItem(1, playerIn);
            }
        }
        return false;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}