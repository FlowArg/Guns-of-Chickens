package fr.flowarg.gunsofchickens.commands;

import com.google.common.collect.Lists;
import fr.flowarg.flowutils.UtilLocation;
import fr.flowarg.flowutils.UtilObjects;
import fr.flowarg.gunsofchickens.commands.util.Teleport;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class CommandDimensionTeleport extends CommandBase
{
    private static final List<String> ALIASES = Lists.newArrayList(References.MODID, "tpdim", "teleportdim", "tpdimension", "teleportdimension");

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
        return ALIASES;
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
            UtilObjects.sendMessageToSender(sender, TextFormatting.DARK_RED + "Dimension ID Invalid");
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
                if (player.experienceLevel < 25)
                {
                    UtilObjects.sendMessageToPlayer(player, TextFormatting.GOLD + "You must to have 25 levels !");
                }
                else
                {
                    Teleport.teleportDimension(player, dimID, UtilLocation.getPlayerX(player), UtilLocation.getPlayerY(player), UtilLocation.getPlayerZ(player));
                }
            }
            else if (dimID == -1 || dimID == 0)
            {
                Teleport.teleportDimension(player, dimID, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
            }
        }
        else
        {
            UtilObjects.sendYouMustToBeAPlayerToUseThisCommandToSender(sender);
        }
    }

}
