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
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class BlockInit
{
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block black_chicken_block = new BlockBase("black_chicken_block",Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block white_chicken_block = new BlockBase("white_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block blue_chicken_block = new BlockBase("blue_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block red_chicken_block = new BlockBase("red_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block yellow_chicken_block = new BlockBase("yellow_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block multicolored_chicken_block = new BlockBase("multicolored_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block pink_chicken_block = new BlockBase("pink_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block orange_chicken_block = new BlockBase("orange_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block green_chicken_block = new BlockBase("green_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block gray_chicken_block = new BlockBase("gray_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block brown_chicken_block = new BlockBase("brown_chicken_block", Material.ROCK, 11.0f, 15.0f, "pickaxe", 2);
    public static final Block chicken_block = new BlockBase("chicken_block", Material.ROCK, 1000.0f, 50f, "pickaxe", 2);
    public static final Block chicken_tnt = new ChickenTNT("chicken_tnt");
    public static final Block chicken_ore = new ChickenOre("chicken_ore");
    public static final Block chicken_coal_ore = new ChickenCoalOre("chicken_coal_ore");
    public static final Block chicken_ladder = new ChickenLadder("chicken_ladder");
    public static final Block chicken_diamond_ore = new ChickenDiamondOre("chicken_diamond_ore");
    public static final Block chicken_diamond_block = new BlockBase("chicken_diamond_block", Material.ROCK, 2000.0f, 100f, "pickaxe", 2);
    public static final Block chicken_wood = new BlockBase("chicken_wood", Material.WOOD, 10.0f, 5.0f, "axe", 1);
    public static final Block chicken_furnace = new ChickenFurnace("chicken_furnace");
    public static final Block ultimate_block = new BlockBase("ultimate_block", Material.ROCK, Float.MAX_VALUE, Float.MAX_VALUE, "pickaxe", 6);
    public static final Block dimensionChanger = new BlockTeleport("dimension_changer");
    public static final Block chicken_chest = new ChickenChest("chicken_chest");
    public static final Block chicken_dirt = new BlockBase("chicken_dirt", Material.CLAY, 5f, 2f, "shovel", 1);
}
