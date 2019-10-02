package fr.flowarg.gunsofchickens.proxy;

import fr.flowarg.gunsofchickens.utils.handlers.RegistryHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        RegistryHandler.preInitRegistriesCOP(event);
        RegistryHandler.otherRegistries();
    }

    public void init(FMLInitializationEvent event)
    {
        RegistryHandler.initRegistriesCOP();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }

    @SideOnly(Side.CLIENT)
    public void registerItemRenderer(Item item, int meta) {}

    @SideOnly(Side.CLIENT)
    public void registerVariantRenderer(Item item, int meta, String fileName, String id) {}
}
