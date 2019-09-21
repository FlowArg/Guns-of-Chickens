package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.item.ItemStack;

public class ChickenCoal extends ItemBase
{
    public ChickenCoal(String name)
    {
        super(name);
    }

    @Override
    public int getItemBurnTime(ItemStack itemStack)
    {
        return 200 * 10;
    }
}
