package fr.flowarg.gunsofchickens.templates;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockBase extends Block implements IHasModel
{
    public BlockBase(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel)
    {
        super(materialIn);
        setRegistryName(name).setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(harvestType, harvestLevel);

        setCreativeTab(Main.MOD_TAB_BLOCKS);

        UtilObjects.registerBlock(this);
    }

    public BlockBase(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel, SoundType soundType)
    {
        super(materialIn);
        this.setRegistryName(name).setUnlocalizedName(name);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setHarvestLevel(harvestType, harvestLevel);

        this.setCreativeTab(Main.MOD_TAB_BLOCKS);
        this.setSoundType(soundType);
        UtilObjects.registerBlock(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }
}
