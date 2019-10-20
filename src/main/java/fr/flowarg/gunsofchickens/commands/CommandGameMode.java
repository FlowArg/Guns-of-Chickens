package fr.flowarg.gunsofchickens.commands;

import net.minecraft.command.CommandException;
import net.minecraft.command.CommandGameMode;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandGamemode extends CommandGameMode
{
    @Override
    public String getName() {
        return "gm";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return super.getRequiredPermissionLevel();
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "gm";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        super.execute(server, sender, args);
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        if (args.length == 1)
        {
            return getListOfStringsMatchingLastWord(args, new String[] {"survival", "creative", "adventure", "spectator"});
        }
        else
        {
            return args.length == 2 ? getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames()) : Collections.emptyList();
        }
    }
}
