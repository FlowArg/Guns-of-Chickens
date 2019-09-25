package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.item.ItemHoe;

public class ChickenHoe extends ItemHoe implements IHasModel
{
    public ChickenHoe(String name, ToolMaterial material)
    {
        super(material);

        setRegistryName(name).setUnlocalizedName(name);

        setMaxStackSize(1);

        setCreativeTab(Main.modtabItems);

        UtilObjects.getInstance().registerItem(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}