package fr.flowarg.gunsofchickens.world.gen;

import fr.flowarg.gunsofchickens.init.BlockInit;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class GenOres implements IWorldGenerator
{
    private WorldGenerator chicken_ore, chicken_coal_ore;

    public GenOres()
    {
        chicken_ore = new WorldGenMinable(BlockInit.CHICKEN_ORE.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
        chicken_coal_ore = new WorldGenMinable(BlockInit.CHICKEN_COAL_ORE.getDefaultState(), 20, BlockMatcher.forBlock(Blocks.COAL_ORE));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.getDimension())
        {
            case -1:
                runGenerator(chicken_coal_ore, world, random, chunkX, chunkZ, 60, 11, 39);
                break;
            case 0:
                runGenerator(chicken_ore, world, random, chunkX, chunkZ, 30, 2, 21);
                break;
        }
    }

    private void runGenerator(WorldGenerator gen, World world, Random random, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
    {
        if (minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chance; i++)
        {
            int x = chunkX * 16 + random.nextInt(16);
            int y = minHeight + random.nextInt(heightDiff);
            int z = chunkZ * 16 + random.nextInt(16);

            gen.generate(world, random, new BlockPos(x, y, z));
        }
    }
}
