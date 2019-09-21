package fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace.slots;

import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotChickenFurnaceFuel extends Slot
{
    public SlotChickenFurnaceFuel(IInventory inventoryIn, int index, int x, int y)
    {
        super(inventoryIn, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return TileEntityChickenFurnace.isItemFuel(stack);
    }

    @Override
    public int getItemStackLimit(ItemStack stack)
    {
        return super.getItemStackLimit(stack);
    }
}
