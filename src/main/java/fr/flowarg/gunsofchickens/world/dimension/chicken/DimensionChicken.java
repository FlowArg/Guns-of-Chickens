package fr.flowarg.gunsofchickens.world.dimension.chicken;

import fr.flowarg.gunsofchickens.init.BiomeInit;
import fr.flowarg.gunsofchickens.init.DimensionInit;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.IChunkGenerator;

public class DimensionChicken extends WorldProvider
{
    public DimensionChicken()
    {
        this.biomeProvider = new BiomeProviderSingle(BiomeInit.CHICKEN_DIMENSION);
    }

    @Override
    public DimensionType getDimensionType()
    {
        return DimensionInit.CHICKEN;
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkGeneratorChickenDimension(world, true, world.getSeed());
    }

    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public boolean isSurfaceWorld()
    {
        return false;
    }
}
