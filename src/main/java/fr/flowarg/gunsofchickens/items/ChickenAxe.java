package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.item.ItemAxe;

public class ChickenAxe extends ItemAxe implements IHasModel
{
    public ChickenAxe(String name, ToolMaterial material, float damage, float speed)
    {
        super(material, damage, speed);
        setRegistryName(name).setUnlocalizedName(name);
        setMaxStackSize(1);
        setCreativeTab(Main.MOD_TAB_ITEMS);

        UtilObjects.registerItem(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }
}