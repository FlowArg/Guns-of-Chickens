package fr.flowarg.gunsofchickens.utils.handlers;

import fr.flowarg.gunsofchickens.utils.References;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

/**
 * @author FlowArg
 * @see net.minecraftforge.common.config.Configuration
 */
public class ConfigHandler
{
    public static File configFile;
    private static Configuration config;

    public static int GUI_CHICKEN_FURNACE = 5;
    public static int GUI_CHICKEN_CHEST = 1;
    public static int KIKI = 120;
    public static int CHICKEN_TNT = 121;
    public static int CHICKEN_DIM = 2;
    public static double spawnX = 0;
    public static double spawnY = 80;
    public static double spawnZ = 0;
    public static int tntReachDistance = 25;
    public static int tntReachDistancechDistancePlus = 25;
    static String welcomeMessage = "";
    static boolean showWelcomeMessage = true;
    public static float strength = 5f;
    public static int money = 0;


    public static void registerConfig(FMLPreInitializationEvent event)
    {
        configFile = new File(event.getModConfigurationDirectory() + "/" + References.MODID);
        configFile.mkdirs();
        syncConfig(new File(configFile.getPath(), References.MODID + ".cfg"));
    }

    public static Configuration getConfig()
    {
        return config;
    }

    public static void syncConfig(File file)
    {
        config = new Configuration(file);

        String category;

        category = "Locations";
        config.addCustomCategoryComment(category, "Set the location of the world spawn");
        spawnX = (double)config.getInt("X Spawn", category, 0, 0, 29999999, "X coordinate for the world spawn");
        spawnY = (double)config.getInt("Y Spawn", category, 80, 0, 256, "Y coordinate for the world spawn");
        spawnZ = (double)config.getInt("Z Spawn", category, 0, 0, 29999999, "Z coordinate for the world spawn");

        category = "IDs";
        config.addCustomCategoryComment(category, "Set the different IDs for Entities and GUIs");
        KIKI = config.getInt("Kiki ID", category, 120, 120, 999, "ID for the kiki entity");
        CHICKEN_TNT = config.getInt("Chicken TNT ID", category, 121, 120, 999, "ID for the Chicken TNT entity");
        GUI_CHICKEN_CHEST = config.getInt("Chicken Chest GUI ID", category, 1, 1, 999, "ID for the Chicken Chest GUI");
        GUI_CHICKEN_FURNACE = config.getInt("Chicken Furnace ID", category, 5, 5, 999, "ID for the Chicken Furnace GUI");
        CHICKEN_DIM = config.getInt("Chicken Dimension ID", category, 2, 2, 999, "ID for the Chicken Dimension");

        category = "Other";
        config.addCustomCategoryComment(category, "Set other variables");
        tntReachDistance = config.getInt("TNT Reach Distance", category, 25, 5, 999, "Minimal distance of the launcher and the `Destination` of the TNT");
        tntReachDistancechDistancePlus = config.getInt("TNT Reach Distance + ", category, 25, 0, 999, "Supplemental distance of the launcher and the `Destination` of the TNT");
        welcomeMessage = config.getString("Welcome Message", category, "Welcome %player%", "The code %player% will be replaced by player's name");
        showWelcomeMessage = config.getBoolean("Enable/Disable the Welcome Message", category, true, "Set false to disable this");
        strength = config.getFloat("Chicken TNT strength", category, 15f, 1f, Float.MAX_VALUE, "Set the tnt strength when it explode");
        money = config.getInt("DON'T TOUCH !!!!!", category, 0, 0, Integer.MAX_VALUE, "DON'T TOUCH PLEASE !!!");

        if (config.hasChanged())
        {
            config.save();
        }
    }

}
