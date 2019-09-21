package fr.flowarg.gunsofchickens;

import fr.flowarg.gunsofchickens.ct.ModTabBlocks;
import fr.flowarg.gunsofchickens.ct.ModTabItems;
import fr.flowarg.gunsofchickens.ct.ModTabUtils;
import fr.flowarg.gunsofchickens.proxy.CommonProxy;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import fr.flowarg.gunsofchickens.utils.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraftforge.fml.common.Mod.EventHandler;
import static net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, modLanguage = "java", serverSideOnly = false, updateJSON = "https://gist.githubusercontent.com/FlowArg/cf597ce990703151e2f580d59b4e26c2/raw/update.json", clientSideOnly = false, canBeDeactivated = false, guiFactory = "fr.flowarg.gunsofchickens.gui.GUIFactory")
public class Main
{
    public static final Logger LOGGER = LogManager.getLogger(References.MODID);

    @Instance(References.MODID)
    public static Main instance;

    @SidedProxy(modId = References.MODID, clientSide = References.CLIENTPROXY, serverSide = References.COMMON)
    public static CommonProxy proxy;

    public static final CreativeTabs modtabItems = new ModTabItems("modtabitems");
    public static final CreativeTabs modtabBlocks = new ModTabBlocks("modtabblocks");
    public static final CreativeTabs modtabUtils = new ModTabUtils("modtabutils");

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
    public static void serverStarting(FMLServerStartingEvent e)
    {
        RegistryHandler.serverRegistries(e);
        LOGGER.info("Starting server...");
    }

    @EventHandler
    public static void serverStarted(FMLServerStartedEvent event)
    {
        LOGGER.info("Server started !");
    }

    @EventHandler
    public static void serverStopping(FMLServerStoppingEvent event)
    {
        LOGGER.info("Stopping server...");
        ConfigHandler.getConfig().save();
    }

    @EventHandler
    public static void serverStopped(FMLServerStoppedEvent event)
    {
        LOGGER.info("Server stopped !");
    }
}
