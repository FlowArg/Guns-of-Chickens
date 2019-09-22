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
        registerOre("oreChicken", BlockInit.chicken_ore);
        registerOre("oreChickenDiamond", BlockInit.chicken_diamond_ore);
        registerOre("ingotChicken", ItemInit.chicken_ingot);
        registerOre("gemChickenDiamond", ItemInit.chicken_diamond);
        registerOre("gemChickenCoal", ItemInit.chicken_coal);
        registerOre("oreChickenCoal", BlockInit.chicken_coal_ore);
        registerOre("ingotUltimate", ItemInit.ultimate_ingot);
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
