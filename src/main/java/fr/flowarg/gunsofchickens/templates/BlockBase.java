package fr.flowarg.gunsofchickens.templates;

import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel)
    {
        super(materialIn);
        setRegistryName(name).setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(harvestType, harvestLevel);

        setCreativeTab(Main.MOD_TAB_BLOCKS);

        UtilObjects.UtilBlocks.registerBlock(BlockInit.BLOCKS, ItemInit.ITEMS, this);
    }

    public BlockBase(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel, SoundType soundType)
    {
        super(materialIn);
        this.setRegistryName(name).setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(harvestType, harvestLevel);

        this.setCreativeTab(Main.MOD_TAB_BLOCKS);
        this.setSoundType(soundType);
        UtilObjects.UtilBlocks.registerBlock(BlockInit.BLOCKS, ItemInit.ITEMS, this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }

    public static class ChickenBlocks extends BlockBase
    {
        public ChickenBlocks(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel)
        {
            super(name, materialIn, resistance, hardness, harvestType, harvestLevel);
        }

        public ChickenBlocks(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel, SoundType soundType)
        {
            super(name, materialIn, resistance, hardness, harvestType, harvestLevel, soundType);
        }

        @Override
        public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
        {
            return true;
        }
    }
}
