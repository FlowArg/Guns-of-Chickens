package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.blocks.BlockTeleport;
import fr.flowarg.gunsofchickens.blocks.ChickenChest;
import fr.flowarg.gunsofchickens.blocks.ChickenLadder;
import fr.flowarg.gunsofchickens.blocks.ChickenTNT;
import fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace.ChickenFurnace;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenCoalOre;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenDiamondOre;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenOre;
import fr.flowarg.gunsofchickens.templates.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLACK_CHICKEN_BLOCK = new BlockBase("black_chicken_block",Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block WHITE_CHICKEN_BLOCK = new BlockBase("white_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block BLUE_CHICKEN_BLOCK = new BlockBase("blue_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block RED_CHICKEN_BLOCK = new BlockBase("red_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block YELLOW_CHICKEN_BLOCK = new BlockBase("yellow_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block MULTICOLORED_CHICKEN_BLOCK = new BlockBase("multicolored_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block PINK_CHICKEN_BLOCK = new BlockBase("pink_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block ORANGE_CHICKEN_BLOCK = new BlockBase("orange_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block GREEN_CHICKEN_BLOCK = new BlockBase("green_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block GRAY_CHICKEN_BLOCK = new BlockBase("gray_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block BROW_CHICKEN_BLOCK = new BlockBase("brown_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block CHICKEN_BLOCK = new BlockBase("chicken_block", Material.ROCK, 1000.0f, 50f, "pickaxe", 2);
    public static final Block CHICKEN_TNT = new ChickenTNT("chicken_tnt");
    public static final Block CHICKEN_ORE = new ChickenOre("chicken_ore");
    public static final Block CHICKEN_COAL_ORE = new ChickenCoalOre("chicken_coal_ore");
    public static final Block CHICKEN_DIAMOND_ORE = new ChickenDiamondOre("chicken_diamond_ore");
    /*
    public static final Block CHICKEN_ORE = new ChickenOres("chicken_ore", "overworld", 25f, 3, 35.7f);
    public static final Block CHICKEN_COAL_ORE = new ChickenOres("chicken_coal_ore", "nether", 4, 18, 30.7f);
    public static final Block CHICKEN_DIAMOND_ORE = new ChickenOres("chicken_diamond_ore", "chicken", 90f, 4, 5000f);
      */
    public static final Block CHICKEN_LADDER = new ChickenLadder("chicken_ladder");
    public static final Block CHICKEN_DIAMOND_BLOCK = new BlockBase("chicken_diamond_block", Material.ROCK, 2000.0f, 100f, "pickaxe", 2);
    public static final Block CHICKEN_WOOD = new BlockBase("chicken_wood", Material.WOOD, 10.0f, 5.0f, "axe", 1);
    public static final Block CHICKEN_FURNACE = new ChickenFurnace("chicken_furnace");
    public static final Block ULTIMATE_BLOCK = new BlockBase("ultimate_block", Material.ROCK, Float.MAX_VALUE, Float.MAX_VALUE, "pickaxe", 6);
    public static final Block DIMENSION_CHANGER = new BlockTeleport("dimension_changer", SoundType.METAL);
    public static final Block CHICKEN_CHEST = new ChickenChest("chicken_chest");
    public static final Block CHICKEN_DIRT = new BlockBase("chicken_dirt", Material.CLAY, 5f, 2f, "shovel", 1);
}
