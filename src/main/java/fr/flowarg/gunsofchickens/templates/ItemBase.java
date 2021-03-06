package fr.flowarg.gunsofchickens.templates;

import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel
{
    public ItemBase(String name)
    {
        setRegistryName(name).setUnlocalizedName(name);
        setCreativeTab(Main.MOD_TAB_ITEMS);

        UtilObjects.UtilItems.registerItem(ItemInit.ITEMS, this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }

    public static class ChickenWithTNT extends ItemBase
    {
        public ChickenWithTNT(String name)
        {
            super(name);
            setCreativeTab(Main.MOD_TAB_UTILS);
            setMaxDamage(64);
            setMaxStackSize(1);
        }
    }
}
