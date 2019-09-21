package fr.flowarg.gunsofchickens.utils.handlers;

import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenFurnace;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler
{
    public static void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityChickenChest.class, new ResourceLocation(References.MODID + ":chicken_chest"));
        GameRegistry.registerTileEntity(TileEntityChickenFurnace.class, new ResourceLocation(References.MODID + ":chicken_furnace"));
    }
}
