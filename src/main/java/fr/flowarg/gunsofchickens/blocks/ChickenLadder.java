package fr.flowarg.gunsofchickens.blocks;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ChickenLadder extends BlockLadder implements IHasModel
{
    public ChickenLadder(String name)
    {
        this.setRegistryName(name).setUnlocalizedName(name);

        this.setCreativeTab(Main.MOD_TAB_BLOCKS);

        UtilObjects.getInstance().registerBlock(this);
    }

    @Override
    public boolean isFertile(World world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return true;
    }

    @Override
    public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, @Nullable EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBed(IBlockState state, IBlockAccess world, BlockPos pos, @Nullable Entity player) {
        return false;
    }

    @Override
    public boolean isAir(IBlockState state, IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isBurning(IBlockAccess world, BlockPos pos) {
        return false;
    }

    @Override
    public boolean isStickyBlock(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFireSource(World world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face) {
        return true;
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
