package fr.flowarg.gunsofchickens.creativetabs;

import fr.flowarg.flowutils.UtilObjects;
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
        return UtilObjects.getItemStackFromItem(ItemInit.BLOCK_DRECRAFTER);
    }
}
