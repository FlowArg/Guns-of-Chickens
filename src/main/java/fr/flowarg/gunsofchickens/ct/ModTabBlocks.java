package fr.flowarg.gunsofchickens.ct;

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
        return new ItemStack(BlockInit.multicolored_chicken_block);
    }
}