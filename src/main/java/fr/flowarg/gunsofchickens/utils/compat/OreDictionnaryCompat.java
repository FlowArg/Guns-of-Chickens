package fr.flowarg.gunsofchickens.utils.compat;

import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionnaryCompat
{
    public static void registerOres()
    {
        registerOre("oreChicken", BlockInit.CHICKEN_ORE);
        registerOre("oreChickenDiamond", BlockInit.CHICKEN_DIAMOND_ORE);
        registerOre("ingotChicken", ItemInit.CHICKEN_COAL);
        registerOre("gemChickenDiamond", ItemInit.CHICKEN_DIAMOND);
        registerOre("gemChickenCoal", ItemInit.CHICKEN_COAL);
        registerOre("oreChickenCoal", BlockInit.CHICKEN_COAL_ORE);
        registerOre("ingotUltimate", ItemInit.ULTIMATE_INGOT);
    }

    private static void registerOre(String name, Block ore)
    {
        OreDictionary.registerOre(name, ore);
    }

    private static void registerOre(String name, Item ore)
    {
        OreDictionary.registerOre(name, ore);
    }
}
