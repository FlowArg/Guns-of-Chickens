package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.items.*;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.item.Item.ToolMaterial;
import static net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemInit
{
    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static final ArmorMaterial ULTIMATE_ARMOR_MAT = EnumHelper.addArmorMaterial("ultimateArmorMat", "gunsofchickens:ultimate_armor", Integer.MAX_VALUE, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, 100, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ArmorMaterial CHICKEN_ARMOR_MAT = EnumHelper.addArmorMaterial("chickenArmorMat", "gunsofchickens:chicken_armor", 500, new int[]{12, 18, 24, 18}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ArmorMaterial CHICKEN_DIAMOND_ARMOR_MAT = EnumHelper.addArmorMaterial("chickenArmorMat", "gunsofchickens:chicken_diamond_armor", 2000, new int[]{40, 50, 60, 50}, 75, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ToolMaterial CHICKEN_TOOL_MAT = EnumHelper.addToolMaterial("chickenToolMat", 4, 1600, 35f, 7f, 10);
    public static final ToolMaterial CHICKEN_DIAMOND_TOOL_MAT = EnumHelper.addToolMaterial("chickenToolMat", 5, 10000, 50f, 30f, 75);
    public static final ToolMaterial ULTIMATE_TOOL_MAT = EnumHelper.addToolMaterial("ultimateToolMat", 6, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 100);

    public static final Item CHICKEN_LAUNCHER_BLACK = new ChickenLaunchers("chicken_launcher_black");
    public static final Item CHICKEN_WITH_TNT = new ItemBase.ChickenWithTNT("chicken_with_tnt");
    public static final Item CHICKEN_LAUNCHER_BLUE = new ChickenLaunchers("chicken_launcher_blue");
    public static final Item CHICKEN_LAUNCHER_BROWN = new ChickenLaunchers("chicken_launcher_brown");
    public static final Item CHICKEN_LAUNCHER_GRAY = new ChickenLaunchers("chicken_launcher_gray");
    public static final Item CHICKEN_LAUNCHER_GREEN = new ChickenLaunchers("chicken_launcher_green");
    public static final Item CHICKEN_LAUNCHER_MULTICOLORED = new ChickenLaunchers("chicken_launcher_multicolored");
    public static final Item CHICKEN_LAUNCHER_ORANGE = new ChickenLaunchers("chicken_launcher_orange");
    public static final Item CHICKEN_LAUNCHER_PINK = new ChickenLaunchers("chicken_launcher_pink");
    public static final Item CHICKEN_LAUNCHER_RED = new ChickenLaunchers("chicken_launcher_red");
    public static final Item CHICKEN_LAUNCHER_WHITE = new ChickenLaunchers("chicken_launcher_white");
    public static final Item CHICKEN_LAUNCHER_YELLOW = new ChickenLaunchers("chicken_launcher_yellow");
    public static final Item CHICKEN_INGOT = new ItemBase("chicken_ingot");
    public static final ItemArmor CHICKEN_HELMET = new ChickenHelmet("chicken_helmet",CHICKEN_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_CHESTPLATE = new ChickenChestplate("chicken_chestplate", CHICKEN_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_LEGGINGS = new ChickenLeggings("chicken_leggings", CHICKEN_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_BOOTS = new ChickenBoots("chicken_boots", CHICKEN_ARMOR_MAT, 2);
    public static final Item CHICKEN_SWORD = new ChickenSword("chicken_sword", CHICKEN_TOOL_MAT);
    public static final Item CHICKEN_PICKAXE = new ChickenPickaxe("chicken_pickaxe", CHICKEN_TOOL_MAT);
    public static final Item CHICKEN_HOE = new ChickenHoe("chicken_hoe", CHICKEN_TOOL_MAT);
    public static final Item CHICKEN_SHOVEL = new ChickenShovel("chicken_shovel", CHICKEN_TOOL_MAT);
    public static final Item CHICKEN_AXE = new ChickenAxe("chicken_axe", CHICKEN_TOOL_MAT, 7f, 1.4f);
    public static final Item CHICKEN_GUNPOWDER = new ItemBase("chicken_gunpowder");
    public static final ItemFood CHICKEN_MINING_APPLE = new ChickenMiningApple("chicken_mining_apple", 15, 5);
    public static final Item BLOCK_DRECRAFTER = new BlockDecrafter("block_decrafter");
    public static final Item INVERSER = new ItemBase("inverser").setCreativeTab(Main.modtabUtils).setMaxStackSize(3);
    public static final ItemFood CHICKEN_PVP_APPLE = new ChickenPVPApple("chicken_pvp_apple", 20, 41, false);
    public static final Item CHICKEN_MEDKIT = new ChickenMedkit("chicken_medkit");
    public static final Item CHICKEN_HEART = new ChickenHeart("chicken_heart");
    public static final Item CHICKEN_COAL = new ChickenCoal("chicken_coal");
    public static final ItemArmor CHICKEN_DIAMOND_HELMET = new ChickenDiamondHelmet("chicken_diamond_helmet", CHICKEN_DIAMOND_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_DIAMOND_CHESTPLATE = new ChickenDiamondChestplate("chicken_diamond_chestplate", CHICKEN_DIAMOND_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_DIAMOND_LEGGINGS = new ChickenDiamondLeggings("chicken_diamond_leggings", CHICKEN_DIAMOND_ARMOR_MAT, 2);
    public static final ItemArmor CHICKEN_DIAMOND_BOOTS = new ChickenDiamondBoots("chicken_diamond_boots", CHICKEN_DIAMOND_ARMOR_MAT, 2);
    public static final Item CHICKEN_DIAMOND_SWORD = new ChickenSword("chicken_diamond_sword", CHICKEN_DIAMOND_TOOL_MAT);
    public static final Item CHICKEN_DIAMOND_PICKAXE = new ChickenPickaxe("chicken_diamond_pickaxe", CHICKEN_DIAMOND_TOOL_MAT);
    public static final Item CHICKEN_DIAMOND_HOE = new ChickenHoe("chicken_diamond_hoe", CHICKEN_DIAMOND_TOOL_MAT);
    public static final Item CHICKEN_DIAMOND_SHOVEL = new ChickenShovel("chicken_diamond_shovel", CHICKEN_DIAMOND_TOOL_MAT);
    public static final Item CHICKEN_DIAMOND_AXE = new ChickenAxe("chicken_diamond_axe", CHICKEN_DIAMOND_TOOL_MAT, 8f, 1.7f);
    public static final Item CHICKEN_DIAMOND = new ItemBase("chicken_diamond");
    public static final Item CHICKEN_STICK = new ItemBase("chicken_stick");
    public static final Item ULTIMATE_INGOT = new ItemBase("ultimate_ingot");
    public static final ItemArmor ULTIMATE_HELMET = new UltimateHelmet("ultimate_helmet", ULTIMATE_ARMOR_MAT, 2);
    public static final ItemArmor ULTIMATE_CHESTPLATE = new UltimateChestplate("ultimate_chestplate", ULTIMATE_ARMOR_MAT, 2);
    public static final ItemArmor ULTIMATE_LEGGINGS = new UltimateLeggings("ultimate_leggings", ULTIMATE_ARMOR_MAT, 2);
    public static final ItemArmor ULTIMATE_BOOTS = new UltimateBoots("ultimate_boots", ULTIMATE_ARMOR_MAT, 2);
    public static final Item ULTIMATE_SWORD = new ChickenSword("ultimate_sword", ULTIMATE_TOOL_MAT);
    public static final Item ULTIMATE_PICKAXE = new ChickenPickaxe("ultimate_pickaxe", ULTIMATE_TOOL_MAT);
    public static final Item ULTIMATE_HOE = new ChickenHoe("ultimate_hoe", ULTIMATE_TOOL_MAT);
    public static final Item ULTIMATE_SHOVEL = new ChickenShovel("ultimate_shovel", ULTIMATE_TOOL_MAT);
    public static final Item ULTIMATE_AXE = new ChickenAxe("ultimate_axe", ULTIMATE_TOOL_MAT, 1f, 25f);
}
