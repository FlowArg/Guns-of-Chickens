package fr.flowarg.gunsofchickens.commands;

import com.google.common.collect.Lists;
import fr.flowarg.gunsofchickens.commands.util.Teleport;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class CommandDimensionTeleport extends CommandBase
{
    private final List<String> aliases = Lists.newArrayList(References.MODID, "tpdim", "teleportdim", "tpdimension", "teleportdimension");

    @Override
    public String getName()
    {
        return "tpdimension";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "tpdimension <id>";
    }

    @Override
    public List<String> getAliases()
    {
        return aliases;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 1) return;

        String s = args[0];
        int dimID;

        try
        {
            dimID = Integer.parseInt(s);
        } catch (NumberFormatException e)
        {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID Invalid"));
            return;
        }

        if(sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;
            if (dimID == 1)
            {
                Teleport.teleportDimension((EntityPlayer)sender, dimID, 0, 70, 0);
            }
            else if(dimID == 2)
            {
                if (ConfigHandler.money >= 1000)
                {
                    Teleport.teleportDimension(player, dimID, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
                }
                else
                {
                    player.sendMessage(new TextComponentString(TextFormatting.GOLD + "You must to mine 1000 chickens ores !"));
                }
            }
            else
            {
                Teleport.teleportDimension(player, dimID, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
            }
        }
        else
        {
            UtilObjects.getInstance().sendYouMustToBeAPlayerToUseThisCommandToSender(sender);
        }
    }

}
