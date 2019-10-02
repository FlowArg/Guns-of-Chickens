package fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import net.minecraft.item.ItemStack;

import java.util.Map;

import static java.util.Map.Entry;

public class ChickenFurnaceRecipes
{
    private static final ChickenFurnaceRecipes INSTANCE = new ChickenFurnaceRecipes();
    public static ChickenFurnaceRecipes getInstance()
    {
        return INSTANCE;
    }
    private final Table<ItemStack, ItemStack, ItemStack> smeltingList = HashBasedTable.<ItemStack, ItemStack, ItemStack>create();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public ChickenFurnaceRecipes()
    {
        addSmeltingRecipe(new ItemStack(ItemInit.CHICKEN_DIAMOND), new ItemStack(ItemInit.CHICKEN_INGOT), new ItemStack(ItemInit.ULTIMATE_INGOT), 999f);
        addSmeltingRecipe(new ItemStack(ItemInit.CHICKEN_INGOT), new ItemStack(ItemInit.CHICKEN_DIAMOND), new ItemStack(ItemInit.ULTIMATE_INGOT), 999f);
        addSmeltingRecipe(new ItemStack(BlockInit.CHICKEN_DIAMOND_BLOCK), new ItemStack(BlockInit.CHICKEN_BLOCK), new ItemStack(BlockInit.ULTIMATE_BLOCK), 999f);
        addSmeltingRecipe(new ItemStack(BlockInit.CHICKEN_BLOCK), new ItemStack(BlockInit.CHICKEN_DIAMOND_BLOCK), new ItemStack(BlockInit.ULTIMATE_BLOCK), 999f);
    }

    public void addSmeltingRecipe(ItemStack input1, ItemStack input2, ItemStack result, float experience)
    {
        if (this.getSmeltingResult(input1, input2) != ItemStack.EMPTY) return;
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
