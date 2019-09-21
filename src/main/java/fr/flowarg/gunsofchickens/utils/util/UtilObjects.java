package fr.flowarg.gunsofchickens.utils.util;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class UtilObjects
{
    private static final UtilObjects INSTANCE = new UtilObjects();

    public static UtilObjects getInstance()
    {
        return INSTANCE;
    }

    public boolean isStackEqualToAnotherStack(ItemStack stack1, ItemStack stack2)
    {
        return stack1 == stack2;
    }
    public boolean isStackEqualToItem(ItemStack stack, Item item)
    {
        return stack.equals(new ItemStack(item));
    }
    public boolean isStackEqualToBlock(ItemStack stack, Block block)
    {
        return stack.equals(new ItemStack(block));
    }

    public ItemStack getItemStackFromItem(Item item)
    {
        return new ItemStack(item);
    }
    public ItemStack getItemStackFromBlock(Block block)
    {
        return new ItemStack(block);
    }
    public Item getItemFromItemStack(ItemStack item)
    {
        return item.getItem();
    }


    public boolean isEntityEqualToAnotherEntity(Entity entity1, Entity entity2)
    {
        return entity1 == entity2;
    }
}
