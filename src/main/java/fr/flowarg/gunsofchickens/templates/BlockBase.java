package fr.flowarg.gunsofchickens.templates;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel, ITooltipFlag {

    public BlockBase(String name, Material materialIn, float resistance, float hardness, String harvestType, int harvestLevel)
    {
        super(materialIn);
        setRegistryName(name).setUnlocalizedName(name);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(harvestType, harvestLevel);

        setCreativeTab(Main.modtabBlocks);

        BlockInit.BLOCKS.add(this);
        ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0);
    }

    @Override
    public boolean isAdvanced()
    {
        return true;
    }
}
