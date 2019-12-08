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

public class ChickenOre extends BlockBase
{
    public ChickenOre(String name)
    {
        super(name, Material.IRON, 35.7f, 25.0f, "pickaxe", 3);
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == BlockInit.CHICKEN_ORE ? ItemInit.CHICKEN_INGOT : Item.getItemFromBlock(this);
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == BlockInit.CHICKEN_ORE)
            {
                i = MathHelper.getInt(rand, 250, 500);
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
