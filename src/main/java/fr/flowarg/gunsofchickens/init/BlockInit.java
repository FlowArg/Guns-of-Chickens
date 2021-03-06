package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.blocks.ChickenChest;
import fr.flowarg.gunsofchickens.blocks.ChickenLadder;
import fr.flowarg.gunsofchickens.blocks.ChickenTNT;
import fr.flowarg.gunsofchickens.blocks.machines.chickenfurnace.ChickenFurnace;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenCoalOre;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenDiamondOre;
import fr.flowarg.gunsofchickens.blocks.ores.ChickenOre;
import fr.flowarg.gunsofchickens.templates.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block BLACK_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("black_chicken_block",Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block WHITE_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("white_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block BLUE_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("blue_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block RED_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("red_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block YELLOW_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("yellow_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block MULTICOLORED_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("multicolored_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block PINK_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("pink_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block ORANGE_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("orange_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block GREEN_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("green_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block GRAY_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("gray_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block BROW_CHICKEN_BLOCK = new BlockBase.ChickenBlocks("brown_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block CHICKEN_BLOCK = new BlockBase.ChickenBlocks("chicken_block", Material.ROCK, 1000.0f, 50f, "pickaxe", 2);
    public static final Block CHICKEN_TNT = new ChickenTNT("chicken_tnt");
    public static final Block CHICKEN_ORE = new ChickenOre("chicken_ore");
    public static final Block CHICKEN_COAL_ORE = new ChickenCoalOre("chicken_coal_ore");
    public static final Block CHICKEN_DIAMOND_ORE = new ChickenDiamondOre("chicken_diamond_ore");
    public static final Block CHICKEN_LADDER = new ChickenLadder("chicken_ladder");
    public static final Block CHICKEN_DIAMOND_BLOCK = new BlockBase.ChickenBlocks("chicken_diamond_block", Material.ROCK, 2000.0f, 100f, "pickaxe", 2);
    public static final Block CHICKEN_WOOD = new BlockBase.ChickenWood();
    public static final Block CHICKEN_FURNACE = new ChickenFurnace("chicken_furnace");
    public static final Block ULTIMATE_BLOCK = new BlockBase.ChickenBlocks("ultimate_block", Material.ROCK, Float.MAX_VALUE, Float.MAX_VALUE, "pickaxe", 6);
    public static final Block CHICKEN_CHEST = new ChickenChest("chicken_chest");
    public static final Block CHICKEN_DIRT = new BlockBase.ChickenDirt();
}
