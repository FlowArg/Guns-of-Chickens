package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.Main;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import static fr.flowarg.gunsofchickens.init.BlockInit.*;
import static fr.flowarg.gunsofchickens.init.ItemInit.*;

public class RecipesInit
{
    public static RecipesInit instance = new RecipesInit();

    public void initRecipes()
    {
        Main.LOGGER.debug("Registering recipes...");
        addSmelt(chicken_with_tnt, chicken_tnt, 8, 3.75f);
        addSmelt(chicken_helmet, chicken_ingot, 4, 4f);
        addSmelt(chicken_chestplate, chicken_ingot, 7, 7f);
        addSmelt(chicken_leggings, chicken_ingot, 6, 6f);
        addSmelt(chicken_boots, chicken_ingot, 3, 3f);
        addSmelt(chicken_ore, chicken_ingot, 1, 2f);
        addSmelt(chicken_diamond_helmet, chicken_diamond, 4, 40f);
        addSmelt(chicken_diamond_chestplate, chicken_diamond, 7, 70f);
        addSmelt(chicken_diamond_leggings, chicken_diamond, 6, 60f);
        addSmelt(chicken_diamond_boots, chicken_diamond, 3, 30f);
        addSmelt(chicken_diamond_ore, chicken_diamond, 1, 20f);
        addSmelt(ultimate_helmet, ultimate_ingot,4, 9999f);
        addSmelt(ultimate_chestplate, ultimate_ingot, 7, 9999f);
        addSmelt(ultimate_leggings, ultimate_ingot, 6, 9999f);
        addSmelt(ultimate_boots, ultimate_ingot, 3, 9999f);
    }

    private void addSmelt(Item item, Item result, int amount, float xp)
    {
        GameRegistry.addSmelting(item, new ItemStack(result, amount), xp);
    }

    private void addSmelt(Block block, Item result, int amount, float xp)
    {
        GameRegistry.addSmelting(block, new ItemStack(result, amount), xp);
    }

    private void addSmelt(Item item, Block result, int amount, float xp)
    {
        GameRegistry.addSmelting(item, new ItemStack(result, amount), xp);
    }

    private void addSmelt(Block block, Block result, int amount, float xp)
    {
        GameRegistry.addSmelting(block, new ItemStack(result, amount), xp);
    }

}
