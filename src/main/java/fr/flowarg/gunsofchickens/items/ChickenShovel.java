package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.item.ItemSpade;

public class ChickenShovel extends ItemSpade implements IHasModel
{
    public ChickenShovel(String name, ToolMaterial material)
    {
        super(material);

        setRegistryName(name).setUnlocalizedName(name);

        setMaxStackSize(1);
        setCreativeTab(Main.modtabItems);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
