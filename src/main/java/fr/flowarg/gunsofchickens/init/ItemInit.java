package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.items.*;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
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

    public static final ArmorMaterial ultimateArmorMat = EnumHelper.addArmorMaterial("ultimateArmorMat", "gunsofchickens:ultimate_armor", Integer.MAX_VALUE, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, 100, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ArmorMaterial chickenArmorMat = EnumHelper.addArmorMaterial("chickenArmorMat", "gunsofchickens:chicken_armor", 500, new int[]{12, 18, 24, 18}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ArmorMaterial chickenDiamondArmorMat = EnumHelper.addArmorMaterial("chickenArmorMat", "gunsofchickens:chicken_diamond_armor", 2000, new int[]{40, 50, 60, 50}, 75, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0f);
    public static final ToolMaterial chickenToolMat = EnumHelper.addToolMaterial("chickenToolMat", 4, 1600, 35f, 7f, 10);
    public static final ToolMaterial chickenDiamondToolMat = EnumHelper.addToolMaterial("chickenToolMat", 5, 10000, 50f, 30f, 75);
    public static final ToolMaterial ultimateToolMat = EnumHelper.addToolMaterial("ultimateToolMat", 6, Integer.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, 100);

    public static final Item chicken_launcher_black = new ChickenLaunchers("chicken_launcher_black");
    public static final Item chicken_with_tnt = new ItemBase("chicken_with_tnt").setCreativeTab(Main.modtabUtils).setMaxDamage(64).setMaxStackSize(1);
    public static final Item chicken_launcher_blue = new ChickenLaunchers("chicken_launcher_blue");
    public static final Item chicken_launcher_brown = new ChickenLaunchers("chicken_launcher_brown");
    public static final Item chicken_launcher_gray = new ChickenLaunchers("chicken_launcher_gray");
    public static final Item chicken_launcher_green = new ChickenLaunchers("chicken_launcher_green");
    public static final Item chicken_launcher_multicolored = new ChickenLaunchers("chicken_launcher_multicolored");
    public static final Item chicken_launcher_orange = new ChickenLaunchers("chicken_launcher_orange");
    public static final Item chicken_launcher_pink = new ChickenLaunchers("chicken_launcher_pink");
    public static final Item chicken_launcher_red = new ChickenLaunchers("chicken_launcher_red");
    public static final Item chicken_launcher_white = new ChickenLaunchers("chicken_launcher_white");
    public static final Item chicken_launcher_yellow = new ChickenLaunchers("chicken_launcher_yellow");
    public static final Item chicken_ingot = new ItemBase("chicken_ingot");
    public static final ItemArmor chicken_helmet = new ChickenHelmet("chicken_helmet",chickenArmorMat, 2,EntityEquipmentSlot.HEAD);
    public static final ItemArmor chicken_chestplate = new ChickenChestplate("chicken_chestplate", chickenArmorMat, 2, EntityEquipmentSlot.CHEST);
    public static final ItemArmor chicken_leggings = new ChickenLeggings("chicken_leggings", chickenArmorMat, 2, EntityEquipmentSlot.LEGS);
    public static final ItemArmor chicken_boots = new ChickenBoots("chicken_boots", chickenArmorMat, 2, EntityEquipmentSlot.FEET);
    public static final Item chicken_sword = new ChickenSword("chicken_sword", chickenToolMat);
    public static final Item chicken_pickaxe = new ChickenPickaxe("chicken_pickaxe", chickenToolMat);
    public static final Item chicken_hoe = new ChickenHoe("chicken_hoe", chickenToolMat);
    public static final Item chicken_shovel = new ChickenShovel("chicken_shovel", chickenToolMat);
    public static final Item chicken_axe = new ChickenAxe("chicken_axe", chickenToolMat, 7f, 1.4f);
    public static final Item chicken_gunpowder = new ItemBase("chicken_gunpowder");
    public static final ItemFood chicken_mining_apple = new ChickenMiningApple("chicken_mining_apple", 15, 5);
    public static final Item block_decrafter = new BlockDecrafter("block_decrafter");
    public static final Item inverser = new ItemBase("inverser").setCreativeTab(Main.modtabUtils).setMaxStackSize(3);
    public static final ItemFood chicken_pvp_apple = new ChickenPVPApple("chicken_pvp_apple", 20, 41, false);
    public static final Item chicken_medkit = new ChickenMedkit("chicken_medkit");
    public static final Item chicken_heart = new ChickenHeart("chicken_heart");
    public static final Item chicken_coal = new ChickenCoal("chicken_coal");
    public static final ItemArmor chicken_diamond_helmet = new ChickenDiamondHelmet("chicken_diamond_helmet", chickenDiamondArmorMat, 2, EntityEquipmentSlot.HEAD);
    public static final ItemArmor chicken_diamond_chestplate = new ChickenDiamondChestplate("chicken_diamond_chestplate", chickenDiamondArmorMat, 2, EntityEquipmentSlot.CHEST);
    public static final ItemArmor chicken_diamond_leggings = new ChickenDiamondLeggings("chicken_diamond_leggings", chickenDiamondArmorMat, 2, EntityEquipmentSlot.LEGS);
    public static final ItemArmor chicken_diamond_boots = new ChickenDiamondBoots("chicken_diamond_boots", chickenDiamondArmorMat, 2, EntityEquipmentSlot.FEET);
    public static final Item chicken_diamond_sword = new ChickenSword("chicken_diamond_sword", chickenDiamondToolMat);
    public static final Item chicken_diamond_pickaxe = new ChickenPickaxe("chicken_diamond_pickaxe", chickenDiamondToolMat);
    public static final Item chicken_diamond_hoe = new ChickenHoe("chicken_diamond_hoe", chickenDiamondToolMat);
    public static final Item chicken_diamond_shovel = new ChickenShovel("chicken_diamond_shovel", chickenDiamondToolMat);
    public static final Item chicken_diamond_axe = new ChickenAxe("chicken_diamond_axe", chickenDiamondToolMat, 8f, 1.7f);
    public static final Item chicken_diamond = new ItemBase("chicken_diamond");
    public static final Item chicken_stick = new ItemBase("chicken_stick");
    public static final Item ultimate_ingot = new ItemBase("ultimate_ingot");
    public static final ItemArmor ultimate_helmet = new ChickenDiamondHelmet("ultimate_helmet", ultimateArmorMat, 2, EntityEquipmentSlot.HEAD);
    public static final ItemArmor ultimate_chestplate = new ChickenDiamondChestplate("ultimate_chestplate", ultimateArmorMat, 2, EntityEquipmentSlot.CHEST);
    public static final ItemArmor ultimate_leggings = new ChickenDiamondLeggings("ultimate_leggings", ultimateArmorMat, 2, EntityEquipmentSlot.LEGS);
    public static final ItemArmor ultimate_boots = new ChickenDiamondBoots("ultimate_boots", ultimateArmorMat, 2, EntityEquipmentSlot.FEET);
    public static final Item ultimate_sword = new ChickenSword("ultimate_sword", ultimateToolMat);
    public static final Item ultimate_pickaxe = new ChickenPickaxe("ultimate_pickaxe", ultimateToolMat);
    public static final Item ultimate_hoe = new ChickenHoe("ultimate_hoe", ultimateToolMat);
    public static final Item ultimate_shovel = new ChickenShovel("ultimate_shovel", ultimateToolMat);
    public static final Item ultimate_axe = new ChickenAxe("ultimate_axe", ultimateToolMat, 1f, 25f);
}
