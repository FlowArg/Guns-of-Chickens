package fr.flowarg.gunsofchickens.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomeChickenDimension extends Biome
{
    public BiomeChickenDimension()
    {
        super(new BiomeProperties("ChickenDimension").setBaseHeight(1.5f).setHeightVariation(1.2f).setRainDisabled().setTemperature(2.f).setWaterColor(16772608));
    }
}
