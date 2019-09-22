package fr.flowarg.gunsofchickens.creativetabs;

import fr.flowarg.gunsofchickens.init.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class ModTabItems extends CreativeTabs
{
    public ModTabItems(String label)
    {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemInit.chicken_launcher_black);
    }
}