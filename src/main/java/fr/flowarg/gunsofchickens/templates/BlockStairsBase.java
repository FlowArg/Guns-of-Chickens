package fr.flowarg.gunsofchickens.templates;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockStairsBase extends BlockStairs implements IHasModel
{
    public BlockStairsBase(String name, IBlockState modelState)
    {
        super(modelState);
        setRegistryName(name).setUnlocalizedName(name);

        setCreativeTab(Main.modtabBlocks);

        BlockInit.BLOCKS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
