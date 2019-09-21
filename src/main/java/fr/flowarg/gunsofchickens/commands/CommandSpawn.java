package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class CommandSpawn extends CommandBase
{
    @Override
    public String getName()
    {
        return "spawn";
    }

    @Override
    public String getUsage(ICommandSender iCommandSender)
    {
        return "/spawn";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;
            player.setPositionAndUpdate(ConfigHandler.spawnX, ConfigHandler.spawnY, ConfigHandler.spawnZ);
            sendMessageToPlayer(player, "Successfully teleport to the spawn.");
        }
        else{
            sender.sendMessage(new TextComponentString("You must to be a player to use this command."));
        }
    }

    private void sendMessageToPlayer(EntityPlayer player, String msg)
    {
        player.sendMessage(new TextComponentString(msg));
    }
}
