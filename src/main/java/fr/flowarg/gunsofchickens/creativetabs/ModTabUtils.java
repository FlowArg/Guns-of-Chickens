package fr.flowarg.gunsofchickens.creativetabs;

import fr.flowarg.gunsofchickens.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTabUtils extends CreativeTabs
{
    public ModTabUtils(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemInit.block_decrafter);
    }
}
