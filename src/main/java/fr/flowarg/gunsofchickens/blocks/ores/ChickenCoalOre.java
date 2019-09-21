package fr.flowarg.gunsofchickens.blocks.ores;

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

public class ChickenCoalOre extends BlockBase
{
    public ChickenCoalOre(String name)
    {
        super(name, Material.IRON, 30.7f, 18.0f, "pickaxe", 3);;
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this == BlockInit.chicken_coal_ore ? ItemInit.chicken_coal : Item.getItemFromBlock(this);
    }

    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = 0;

            if (this == BlockInit.chicken_coal_ore)
            {
                i = MathHelper.getInt(rand, 1, 20);
            }

            return i;
        }
        return 0;
    }

}
