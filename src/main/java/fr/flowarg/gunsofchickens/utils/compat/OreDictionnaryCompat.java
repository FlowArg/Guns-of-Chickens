package fr.flowarg.gunsofchickens.utils.compat;

import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionnaryCompat
{
    public static void registerOres()
    {
        OreDictionary.registerOre("oreChicken", BlockInit.chicken_ore);
        OreDictionary.registerOre("oreChickenDiamond", BlockInit.chicken_diamond_ore);
        OreDictionary.registerOre("ingotChicken", ItemInit.chicken_ingot);
        OreDictionary.registerOre("gemChickenDiamond", ItemInit.chicken_diamond);
        OreDictionary.registerOre("gemChickenCoal", ItemInit.chicken_coal);
        OreDictionary.registerOre("oreChickenCoal", BlockInit.chicken_coal_ore);
    }
}
