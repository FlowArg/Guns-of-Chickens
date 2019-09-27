package fr.flowarg.gunsofchickens.utils.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class UtilLocation
{
    private static final UtilLocation INSTANCE = new UtilLocation();

    public static UtilLocation getInstance()
    {
        return INSTANCE;
    }

    public double getPlayerX(EntityPlayer player)
    {
        return player.getPosition().getX();
    }
    public double getPlayerY(EntityPlayer player)
    {
        return player.getPosition().getY();
    }
    public double getPlayerZ(EntityPlayer player)
    {
        return player.getPosition().getZ();
    }
    public double getEntityX(Entity entity)
    {
        return entity.getPosition().getX();
    }
    public double getEntityY(Entity entity)
    {
        return entity.getPosition().getY();
    }
    public double getEntityZ(Entity entity)
    {
        return entity.getPosition().getZ();
    }
    public double getEntityX(EntityLiving entity)
    {
        return entity.getPosition().getX();
    }
    public double getEntityY(EntityLiving entity)
    {
        return entity.getPosition().getY();
    }
    public double getEntityZ(EntityLiving entity)
    {
        return entity.getPosition().getZ();
    }

    public double getMaxWorldX(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().maxX();
    }
    public double getMaxWorldY()
    {
        return 256d;
    }
    public double getMaxWorldZ(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().maxZ();
    }
    public double getMinWorldX(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().minX();
    }
    public double getMinWorldY()
    {
        return 2d;
    }
    public double getMinWorldZ(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().minZ();
    }

    private int getDimension(EntityPlayer player)
    {
        return player.dimension;
    }
}
