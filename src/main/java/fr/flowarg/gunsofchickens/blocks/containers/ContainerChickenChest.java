package fr.flowarg.gunsofchickens.blocks.containers;

import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChickenChest extends Container
{
    private final int numRows;
    private final TileEntityChickenChest chestInventory;

    public ContainerChickenChest(InventoryPlayer playerInv, TileEntityChickenChest chestInventory)
    {
        this.chestInventory = chestInventory;
        this.numRows = chestInventory.getSizeInventory() / 9;
        chestInventory.openInventory(playerInv.player);

        for (int i = 0; i < this.numRows; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(chestInventory, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }

        for (int y = 0; y < 3; y++)
        {
            for (int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 175 + y * 18));
            }
        }

        for (int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 233));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.chestInventory.isUsableByPlayer(playerIn);
    }

    @Override
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
        this.chestInventory.closeInventory(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();

            if (index < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemStack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemStack1, 0, this.numRows * 9, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }
        return itemStack;
    }

    public TileEntityChickenChest getChestInventory()
    {
        return this.chestInventory;
    }
}