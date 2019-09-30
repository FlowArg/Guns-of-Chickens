package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

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
        UtilObjects.sendMessageToSender(sender,"Hour : " + new Date().toString());
    }
}
