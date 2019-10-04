package fr.flowarg.gunsofchickens.world.biomes;

import com.google.common.collect.Lists;
import fr.flowarg.gunsofchickens.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class BiomeChicken extends Biome
{
    private IBlockState myTopBlock = BlockInit.CHICKEN_DIRT.getDefaultState();
    private IBlockState myFillerBlock = BlockInit.CHICKEN_DIRT.getDefaultState();

    public BiomeChicken()
    {
        super(new BiomeProperties("ChickenDimension").setBaseHeight(1.5f).setHeightVariation(1.2f).setRainDisabled().setTemperature(2.f).setWaterColor(16772608));
        this.topBlock = this.myTopBlock;
        this.fillerBlock = this.myFillerBlock;
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityChicken.class, 100, 10,20));
    }

    @Override
    public boolean canRain() {
        return false;
    }

    @Override
    public int getSkyColorByTemp(float currentTemperature)
    {
        currentTemperature = 2.f;
        return (int)currentTemperature;
    }

    @Override
    public List<SpawnListEntry> getSpawnableList(EnumCreatureType creatureType)
    {
        switch (creatureType)
        {
            case MONSTER:
                return this.spawnableMonsterList;
            case CREATURE:
                return this.spawnableCreatureList;
            case WATER_CREATURE:
                return this.spawnableWaterCreatureList;
            case AMBIENT:
                return this.spawnableCaveCreatureList;
            default:
                if (!this.modSpawnableLists.containsKey(creatureType)) this.modSpawnableLists.put(creatureType, Lists.<Biome.SpawnListEntry>newArrayList());
                return this.modSpawnableLists.get(creatureType);
        }
    }
}
