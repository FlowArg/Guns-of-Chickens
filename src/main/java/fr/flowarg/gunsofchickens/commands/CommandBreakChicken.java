package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandBreakChicken extends CommandBase
{
    @Override
    public String getName()
    {
        return "Chicken Ores Mined";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "/COM";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;
            player.sendMessage(new TextComponentString(TextFormatting.GREEN + "You have : " + ConfigHandler.money));
        }
    }
}
