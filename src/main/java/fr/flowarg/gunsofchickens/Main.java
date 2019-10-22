package fr.flowarg.gunsofchickens;

import fr.flowarg.gunsofchickens.creativetabs.ModTabBlocks;
import fr.flowarg.gunsofchickens.creativetabs.ModTabItems;
import fr.flowarg.gunsofchickens.creativetabs.ModTabUtils;
import fr.flowarg.gunsofchickens.proxy.CommonProxy;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

/**
 * @author FlowArg
 * @since alpha1.0
 * @see Mod
 */
// TEST : @Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, modLanguage = "java", serverSideOnly = false, updateJSON = "https://raw.githubusercontent.com/FlowArg/Guns-of-Chickens/master/update.json", clientSideOnly = false, canBeDeactivated = false, guiFactory = "fr.flowarg.gunsofchickens.gui.GUIFactory", dependencies = "required-after:redstoneflux@[1.0.6,2.2.0)")
@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, modLanguage = "java", serverSideOnly = false, updateJSON = "https://raw.githubusercontent.com/FlowArg/Guns-of-Chickens/master/update.json", clientSideOnly = false, canBeDeactivated = false, guiFactory = "fr.flowarg.gunsofchickens.gui.GUIFactory", dependencies = "required-before:flowutils@[0.1.0,1.0.0)")
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger(References.MODID);

    @Instance(References.MODID)
    public static Main instance;

    @SidedProxy(modId = References.MODID, clientSide = References.CLIENTPROXY, serverSide = References.COMMON)
    public static CommonProxy proxy;

    public static final CreativeTabs MOD_TAB_ITEMS = new ModTabItems("modtabitems");
    public static final CreativeTabs MOD_TAB_BLOCKS = new ModTabBlocks("modtabblocks");
    public static final CreativeTabs MOD_TAB_UTILS = new ModTabUtils("modtabutils");

    public Main()
    {
        LOGGER.info(Biome.getBiome(3));
    }

    @EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
        LOGGER.info("Mod PreInitialization complete !");
    }

    @EventHandler
    public static void init(FMLInitializationEvent event)
    {
        proxy.init(event);
        LOGGER.info("Mod Initialization complete !");
    }

    @EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);
        LOGGER.info("Mod PostInitialization complete !");
    }
    @EventHandler
    public static void onServerStarting(FMLServerStartingEvent e)
    {
        LOGGER.info("Starting server...");
        RegistryHandler.registerCommands(e);
    }

    @EventHandler
    public static void onServerStarted(FMLServerStartedEvent event)
    {
        LOGGER.info("Server started !");
    }

    @EventHandler
    public static void onServerStopping(FMLServerStoppingEvent event)
    {
        LOGGER.info("Stopping server...");
    }

    @EventHandler
    public static void onServerStopped(FMLServerStoppedEvent event)
    {
        LOGGER.info("Server stopped !");
    }
}
