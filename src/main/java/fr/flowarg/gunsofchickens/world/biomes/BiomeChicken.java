package fr.flowarg.gunsofchickens.world.biomes;

import fr.flowarg.gunsofchickens.entity.EntityKikiChicken;
import fr.flowarg.gunsofchickens.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.biome.Biome;

public class BiomeChicken extends Biome
{
    private IBlockState myTopBlock = BlockInit.CHICKEN_DIRT.getDefaultState();
    private IBlockState myFillerBlock = BlockInit.CHICKEN_DIRT.getDefaultState();

    public BiomeChicken()
    {
        super(new BiomeProperties("ChickenDimension").setBaseHeight(1.5f).setHeightVariation(1.2f).setRainDisabled().setTemperature(2.f).setWaterColor(16772608));
        this.topBlock = this.myTopBlock;
        this.fillerBlock = this.myFillerBlock;
        this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntityKikiChicken.class, 100, 20, 30));
    }
}
