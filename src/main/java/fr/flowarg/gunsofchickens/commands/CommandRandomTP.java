package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.flowutils.UtilLocation;
import fr.flowarg.flowutils.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

import java.util.Random;

public class CommandRandomTP extends CommandBase
{
    @Override
    public String getName()
    {
        return "rtp";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender)
    {
        return "rtp";
    }

    @Override
    public void execute(MinecraftServer minecraftServer, ICommandSender sender, String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;
            Random random = new Random();

            double randomX = random.nextInt((int)UtilLocation.getMaxWorldX(minecraftServer, player)) + (int)UtilLocation.getMinWorldX(minecraftServer, player);
            double randomY = random.nextInt((int)UtilLocation.getMaxWorldY()) + (int)UtilLocation.getMinWorldY();
            double randomZ = random.nextInt((int)UtilLocation.getMaxWorldZ(minecraftServer, player)) + (int)UtilLocation.getMinWorldZ(minecraftServer, player);

            player.setPositionAndUpdate(randomX, randomY, randomZ);
        }
        else
        {
            UtilObjects.sendYouMustToBeAPlayerToUseThisCommandToSender(sender);
        }
    }
}