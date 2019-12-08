package fr.flowarg.gunsofchickens;

import fr.flowarg.gunsofchickens.creativetabs.ModTabBlocks;
import fr.flowarg.gunsofchickens.creativetabs.ModTabItems;
import fr.flowarg.gunsofchickens.creativetabs.ModTabUtils;
import fr.flowarg.gunsofchickens.proxy.CommonProxy;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

/**
 * @author FlowArg
 * @since alpha1.0
 * @see Mod
 */

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, modLanguage = "java", serverSideOnly = false, updateJSON = "https://flowarg.github.io/minecraft/mods/Guns%20of%20Chickens/update.json", clientSideOnly = false, canBeDeactivated = false, guiFactory = "fr.flowarg.gunsofchickens.gui.GUIFactory", dependencies = "required-before:flowutils@[0.1.4,0.1.5);required-after:forge@[14.23.5.2768,)")
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger(References.MODID);

    @Instance(References.MODID)
    public static Main instance;

    @SidedProxy(modId = References.MODID, clientSide = References.CLIENTPROXY, serverSide = References.COMMONPROXY)
    public static CommonProxy proxy;

    public static final CreativeTabs MOD_TAB_ITEMS = new ModTabItems("modtabitems");
    public static final CreativeTabs MOD_TAB_BLOCKS = new ModTabBlocks("modtabblocks");
    public static final CreativeTabs MOD_TAB_UTILS = new ModTabUtils("modtabutils");

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }
    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }
    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
    }
    @EventHandler
    public static void onServerStarting(FMLServerStartingEvent e)
    {
        RegistryHandler.registerCommands(e);
    }
}
