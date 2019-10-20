package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.flowutils.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import java.util.Date;

public class CommandFlow extends CommandBase
{
    @Override
    public String getName() {
        return "flow";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "flow";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        UtilObjects.sendMessageToSender(sender,"It is : " + new Date().toString());
    }
}
