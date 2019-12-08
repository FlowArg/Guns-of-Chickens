package fr.flowarg.gunsofchickens.items;

import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ChickenPickaxe extends ItemPickaxe implements IHasModel
{
    public ChickenPickaxe(String name, ToolMaterial material)
    {
        super(material);
        setRegistryName(name).setUnlocalizedName(name);

        setMaxStackSize(1);

        setCreativeTab(Main.MOD_TAB_ITEMS);

        UtilObjects.UtilItems.registerItem(ItemInit.ITEMS, this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public boolean hasEffect(ItemStack stack)
    {
        return UtilObjects.isStackEqualToAnotherStack(stack, UtilObjects.UtilItems.getItemStackFromItem(ItemInit.ULTIMATE_PICKAXE));
    }
}
