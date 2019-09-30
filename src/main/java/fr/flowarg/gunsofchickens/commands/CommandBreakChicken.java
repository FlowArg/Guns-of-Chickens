package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextFormatting;

public class CommandBreakChicken extends CommandBase
{
    @Override
    public String getName()
    {
        return "com";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "com";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;
            UtilObjects.sendMessageToPlayer(player, TextFormatting.GREEN + "You have : " + ConfigHandler.money);
        }
        else
        {
            UtilObjects.sendYouMustToBeAPlayerToUseThisCommandToSender(sender);
        }
    }
}
