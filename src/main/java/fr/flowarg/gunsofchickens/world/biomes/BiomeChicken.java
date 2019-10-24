package fr.flowarg.gunsofchickens.world.biomes;

import com.google.common.collect.Lists;
import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.init.BlockInit;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.world.biome.Biome;

import java.util.List;

public class BiomeChicken extends Biome
{
    private IBlockState myTopBlock = UtilObjects.UtilBlocks.getStateFromBlock(BlockInit.CHICKEN_DIRT);

    public BiomeChicken()
    {
        super(new BiomeProperties("ChickenDimension").setBaseHeight(1.5f).setHeightVariation(1.2f).setRainDisabled().setTemperature(2.f).setWaterColor(16772608));
        super.topBlock = this.myTopBlock;
        super.fillerBlock = this.myTopBlock;
        super.spawnableCaveCreatureList.add(new SpawnListEntry(EntityChicken.class, 100, 10,20));
    }

    @Override
    public boolean canRain() {
        return false;
    }
}
