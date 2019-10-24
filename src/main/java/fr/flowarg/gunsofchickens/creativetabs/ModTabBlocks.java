package fr.flowarg.gunsofchickens.creativetabs;

import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.init.BlockInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTabBlocks extends CreativeTabs
{
    public ModTabBlocks(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return UtilObjects.UtilBlocks.getItemStackFromBlock(BlockInit.MULTICOLORED_CHICKEN_BLOCK);
    }
}