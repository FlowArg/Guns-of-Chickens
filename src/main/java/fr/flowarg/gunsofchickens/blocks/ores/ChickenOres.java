package fr.flowarg.gunsofchickens.blocks.ores;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.IMetaName;
import fr.flowarg.gunsofchickens.utils.handlers.EnumHandler;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ChickenOres extends Block implements IHasModel, IMetaName
{
    public static final PropertyEnum<EnumHandler.EnumType> VARIANT = PropertyEnum.<EnumHandler.EnumType>create("variant", EnumHandler.EnumType.class);
    private String name;
    private String dimension;

    public ChickenOres(String name, String dimension, float hardness, int harvestLevel, float resistance)
    {
        super(Material.ROCK);
        this.name = name;
        this.dimension = dimension;
        setRegistryName(name);
        setUnlocalizedName(name);
        setHardness(hardness);
        setHarvestLevel("pickaxe", harvestLevel);
        setResistance(resistance);
        setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumHandler.EnumType.CHICKEN));
        setCreativeTab(Main.MOD_TAB_BLOCKS);

        UtilObjects.registerBlockWithMetadata(this);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumHandler.EnumType)state.getValue(VARIANT)).getMeta();
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumHandler.EnumType.byMetadata(meta));
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
    {
        return new ItemStack(Item.getItemFromBlock(this), 1, getMetaFromState(world.getBlockState(pos)));
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        for (EnumHandler.EnumType variant : EnumHandler.EnumType.values())
        {
            items.add(new ItemStack(this, 1, variant.getMeta()));
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[]{VARIANT});
    }

    @Override
    public String getSpecialName(ItemStack stack)
    {
        return EnumHandler.EnumType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void registerModels()
    {
        for (int i = 0; i < EnumHandler.EnumType.values().length; i++)
        {
            Main.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, EnumHandler.EnumType.values()[i].getName() + this.dimension + "_ore", "inventory");
        }
    }
}
