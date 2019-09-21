package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import fr.flowarg.gunsofchickens.world.dimension.chicken.DimensionChicken;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class DimensionInit
{
    public static final DimensionType CHICKEN = DimensionType.register("Chicken", "_chicken", ConfigHandler.CHICKEN_DIM, DimensionChicken.class, false);

    public static void registerDimensions()
    {
        registerDimension(ConfigHandler.CHICKEN_DIM, CHICKEN);
    }

    private static void registerDimension(int id, DimensionType type)
    {
        DimensionManager.registerDimension(id, type);
    }
}
