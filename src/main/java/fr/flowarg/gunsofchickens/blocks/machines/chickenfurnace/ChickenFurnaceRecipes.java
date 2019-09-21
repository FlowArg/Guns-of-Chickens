package fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Map;

import static java.util.Map.Entry;

public class ChickenFurnaceRecipes
{
    private static final ChickenFurnaceRecipes INSTANCE = new ChickenFurnaceRecipes();
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    private ItemStack chicken_ingot = this.getItemStack(ItemInit.chicken_diamond);
    private ItemStack chicken_diamond = this.getItemStack(ItemInit.chicken_diamond);
    private ItemStack ultimate_ingot = this.getItemStack(ItemInit.ultimate_ingot);
    private ItemStack chicken_block = this.getItemStack(BlockInit.chicken_block);
    private ItemStack chicken_diamond_block = this.getItemStack(BlockInit.chicken_diamond_block);
    private ItemStack ultimate_block = this.getItemStack(BlockInit.ultimate_block);

    public static ChickenFurnaceRecipes getInstance()
    {
        return INSTANCE;
    }

    public ChickenFurnaceRecipes()
    {
        addSmeltingRecipe(chicken_ingot, chicken_diamond, ultimate_ingot, 99999f);
        addSmeltingRecipe(chicken_diamond, chicken_ingot, ultimate_ingot, 99999f);
        addSmeltingRecipe(chicken_block, chicken_diamond_block, ultimate_block, 99999f);
        addSmeltingRecipe(chicken_diamond_block, chicken_block, ultimate_block, 99999f);
    }

    private ItemStack getItemStack(Item item)
    {
        return UtilObjects.getInstance().getItemStackFromItem(item);
    }

    private ItemStack getItemStack(Block block)
    {
        return UtilObjects.getInstance().getItemStackFromBlock(block);
    }

    public void addSmeltingRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        if (getSmeltingResult(input1, input2) != ItemStack.EMPTY) return;
        this.smeltingList.put(input1, input2, result);
        this.experienceList.put(result, Float.valueOf(experience));
    }

    public ItemStack getSmeltingResult(ItemStack input1, ItemStack input2)
    {
        for (Entry<ItemStack, Map<ItemStack, ItemStack>> entry : this.smeltingList.columnMap().entrySet())
        {
            if (this.compareItemStacks(input1, (ItemStack) entry.getKey()))
            {
                for (Entry<ItemStack, ItemStack> ent : entry.getValue().entrySet())
                {
                    if (this.compareItemStacks(input2, (ItemStack)entry.getKey()))
                    {
                        return (ItemStack)ent.getValue();
                    }
                }
            }
        }
        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Table<ItemStack, ItemStack, ItemStack> getDualSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }
        return 0.0f;
    }
}
