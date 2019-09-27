package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.util.UtilLocation;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
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
            UtilLocation utils = UtilLocation.getInstance();

            double randomX = random.nextInt((int)utils.getMaxWorldX(minecraftServer, player)) + (int)utils.getMinWorldX(minecraftServer, player);
            double randomY = random.nextInt((int)utils.getMaxWorldY()) + (int)utils.getMinWorldY();
            double randomZ = random.nextInt((int)utils.getMaxWorldZ(minecraftServer, player)) + (int)utils.getMinWorldZ(minecraftServer, player);

            player.setPositionAndUpdate(randomX, randomY, randomZ);
        }
        else
        {
            UtilObjects.getInstance().sendYouMustToBeAPlayerToUseThisCommandToSender(sender);
        }
    }
}