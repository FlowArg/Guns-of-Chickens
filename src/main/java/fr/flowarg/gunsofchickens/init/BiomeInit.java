package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.world.biomes.BiomeChickenDimension;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BiomeInit
{
    public static final Biome CHICKEN_DIMENSION = new BiomeChickenDimension();

    public static void registerBiomes()
    {
        Main.LOGGER.debug("Registering biomes...");
        initBiome(CHICKEN_DIMENSION, "ChickenDimension", BiomeManager.BiomeType.WARM, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.MOUNTAIN);
    }

    private static Biome initBiome(Biome biome, String name, BiomeManager.BiomeType biomeType, BiomeDictionary.Type... types)
    {
        Main.LOGGER.debug("Initializing biomes...");
        biome.setRegistryName(name);
        ForgeRegistries.BIOMES.register(biome);
        Main.LOGGER.debug("Initialized biomes.");
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, 10));
        BiomeManager.addSpawnBiome(biome);
        Main.LOGGER.debug("Biomes added.");
        return biome;
    }
}
