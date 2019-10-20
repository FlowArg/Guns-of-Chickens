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
    public static void initRecipes()
    {
        Main.LOGGER.debug("Registering recipes...");
        addSmelt(CHICKEN_WITH_TNT, CHICKEN_TNT, 8, 3.75f);
        addSmelt(CHICKEN_HELMET, CHICKEN_INGOT, 4, 4f);
        addSmelt(CHICKEN_CHESTPLATE, CHICKEN_INGOT, 7, 7f);
        addSmelt(CHICKEN_LEGGINGS, CHICKEN_INGOT, 6, 6f);
        addSmelt(CHICKEN_BOOTS, CHICKEN_INGOT, 3, 3f);
        addSmelt(CHICKEN_ORE, CHICKEN_INGOT, 1, 2f);
        addSmelt(CHICKEN_DIAMOND_HELMET, CHICKEN_DIAMOND, 4, 40f);
        addSmelt(CHICKEN_DIAMOND_CHESTPLATE, CHICKEN_DIAMOND, 7, 70f);
        addSmelt(CHICKEN_DIAMOND_LEGGINGS, CHICKEN_DIAMOND, 6, 60f);
        addSmelt(CHICKEN_DIAMOND_BOOTS, CHICKEN_DIAMOND, 3, 30f);
        addSmelt(CHICKEN_DIAMOND_ORE, CHICKEN_DIAMOND, 1, 20f);
        addSmelt(ULTIMATE_HELMET, ULTIMATE_INGOT,4, 9999f);
        addSmelt(ULTIMATE_CHESTPLATE, ULTIMATE_INGOT, 7, 9999f);
        addSmelt(ULTIMATE_LEGGINGS, ULTIMATE_INGOT, 6, 9999f);
        addSmelt(ULTIMATE_BOOTS, ULTIMATE_INGOT, 3, 9999f);
    }

    private static void addSmelt(Item item, Item result, int amount, float xp)
    {
        GameRegistry.addSmelting(item, new ItemStack(result, amount), xp);
    }

    private static void addSmelt(Block block, Item result, int amount, float xp)
    {
        GameRegistry.addSmelting(block, new ItemStack(result, amount), xp);
    }

    private static void addSmelt(Item item, Block result, int amount, float xp)
    {
        GameRegistry.addSmelting(item, new ItemStack(result, amount), xp);
    }

    private static void addSmelt(Block block, Block result, int amount, float xp)
    {
        GameRegistry.addSmelting(block, new ItemStack(result, amount), xp);
    }
}
