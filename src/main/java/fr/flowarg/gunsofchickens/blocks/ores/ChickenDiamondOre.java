package fr.flowarg.gunsofchickens.blocks.ores;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.templates.BlockBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class ChickenDiamondOre extends BlockBase
{
    public ChickenDiamondOre(String name)
    {
        super(name, Material.IRON, 5000.0f, 90.0f, "pickaxe", 4);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == BlockInit.CHICKEN_DIAMOND_ORE ? ItemInit.CHICKEN_DIAMOND : Item.getItemFromBlock(this);
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == BlockInit.CHICKEN_DIAMOND_ORE)
            {
                i = MathHelper.getInt(rand, 500, 1000);
            }

            return i;
        }
        return 0;
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}