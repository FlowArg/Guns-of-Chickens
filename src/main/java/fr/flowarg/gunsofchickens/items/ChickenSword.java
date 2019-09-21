package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.item.ItemSword;

public class ChickenSword extends ItemSword implements IHasModel
{
    public ChickenSword(String name, ToolMaterial material)
    {
        super(material);
        setRegistryName(name).setUnlocalizedName(name);

        setMaxStackSize(1);

        setCreativeTab(Main.modtabItems);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels()
    {
        Main.proxy.registerItemRenderer(this, 0);
    }
}
