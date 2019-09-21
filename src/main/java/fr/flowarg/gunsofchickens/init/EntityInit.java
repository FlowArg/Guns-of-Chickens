package fr.flowarg.gunsofchickens.init;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.entity.EntityChickenTNTPrimed;
import fr.flowarg.gunsofchickens.entity.EntityKikiChicken;
import fr.flowarg.gunsofchickens.entity.render.RenderChickenTNTPrimed;
import fr.flowarg.gunsofchickens.entity.render.RenderKikiChicken;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityInit
{
    private static void registerEntity(String name, Class<? extends Entity> entityClass, int mobID, int range, int color1, int color2)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name), entityClass, name, mobID , Main.instance, range, 1, true, color1, color2);
    }

    private static void registerEntity(String name, Class<? extends Entity> entityClass, int mobID, int range)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(References.MODID + ":" + name), entityClass, name, mobID, Main.instance, range, 1, true);
    }

    public static void registerEntities()
    {
        Main.LOGGER.debug("Registering entities...");
        registerEntity("chicken_kiki", EntityKikiChicken.class, ConfigHandler.KIKI, 60, 16776960, 5688147);
        registerEntity("chicken_tnt", EntityChickenTNTPrimed.class, ConfigHandler.CHICKEN_TNT, 40);
    }

    @SideOnly(Side.CLIENT)
    public static void registerEntitiesRender()
    {
        Main.LOGGER.debug("Registering entities renders...");
        RenderingRegistry.registerEntityRenderingHandler(EntityChickenTNTPrimed.class, new RenderChickenTNTPrimed(Minecraft.getMinecraft().getRenderManager()));
        RenderingRegistry.registerEntityRenderingHandler(EntityKikiChicken.class, new RenderKikiChicken(Minecraft.getMinecraft().getRenderManager()));
    }

}
