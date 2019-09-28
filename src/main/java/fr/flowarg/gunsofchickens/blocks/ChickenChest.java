package fr.flowarg.gunsofchickens.blocks;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ChickenChest extends BlockContainer
{
    public ChickenChest(String name)
    {
        super(Material.IRON);
        setRegistryName(name).setUnlocalizedName(name);
        setCreativeTab(Main.MOD_TAB_BLOCKS);
        setResistance(10f);
        setHardness(12f);
        setHarvestLevel("axe", 2);

        UtilObjects.getInstance().registerBlock(this);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            playerIn.openGui(Main.instance, ConfigHandler.GUI_CHICKEN_CHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        TileEntityChickenChest tileentity = (TileEntityChickenChest)worldIn.getTileEntity(pos);
        InventoryHelper.dropInventoryItems(worldIn, pos, tileentity);
        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        if (stack.hasDisplayName())
        {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity instanceof TileEntityChickenChest)
            {
                ((TileEntityChickenChest)tileEntity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i)
    {
        return new TileEntityChickenChest();
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean isFullBlock(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
