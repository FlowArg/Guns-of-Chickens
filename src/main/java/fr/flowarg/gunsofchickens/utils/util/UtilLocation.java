package fr.flowarg.gunsofchickens.utils.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class UtilLocation
{
    public static double getPlayerX(EntityPlayer player)
    {
        return player.getPosition().getX();
    }
    public static double getPlayerY(EntityPlayer player)
    {
        return player.getPosition().getY();
    }
    public static double getPlayerZ(EntityPlayer player)
    {
        return player.getPosition().getZ();
    }
    public static double getPlayerMotionX(EntityPlayer player)
    {
        return player.motionX;
    }
    public static double getPlayerMotionY(EntityPlayer player)
    {
        return player.motionY;
    }
    public static double getPlayerMotionZ(EntityPlayer player)
    {
        return player.motionZ;
    }
    public static double getEntityX(Entity entity)
    {
        return entity.getPosition().getX();
    }
    public static double getEntityY(Entity entity)
    {
        return entity.getPosition().getY();
    }
    public static double getEntityZ(Entity entity)
    {
        return entity.getPosition().getZ();
    }
    public static double getEntityMotionX(Entity entity)
    {
        return entity.motionX;
    }
    public static double getEntityMotionY(Entity entity)
    {
        return entity.motionY;
    }
    public static double getEntityMotionZ(Entity entity)
    {
        return entity.motionZ;
    }
    public static double getEntityLivingX(EntityLiving entity)
    {
        return entity.getPosition().getX();
    }
    public static double getEntityLivingY(EntityLiving entity)
    {
        return entity.getPosition().getY();
    }
    public static double getEntityLivingZ(EntityLiving entity)
    {
        return entity.getPosition().getZ();
    }
    public static double getEntityLivingMotionX(EntityLiving entity)
    {
        return entity.motionX;
    }
    public static double getEntityLivingMotionY(EntityLiving entity)
    {
        return entity.motionY;
    }
    public static double getEntityLivingMotionZ(EntityLiving entity)
    {
        return entity.motionZ;
    }

    public static double getMaxWorldX(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().maxX();
    }
    public static double getMaxWorldY()
    {
        return 256d;
    }
    public static double getMaxWorldZ(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().maxZ();
    }
    public static double getMinWorldX(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().minX();
    }
    public static double getMinWorldY()
    {
        return 2d;
    }
    public static double getMinWorldZ(MinecraftServer minecraftServer, EntityPlayer player)
    {
        return minecraftServer.getWorld(getDimension(player)).getWorldBorder().minZ();
    }

    public static int getDimension(EntityPlayer player)
    {
        return player.dimension;
    }
}
