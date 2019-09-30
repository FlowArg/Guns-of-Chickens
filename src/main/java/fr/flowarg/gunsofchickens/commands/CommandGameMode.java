package fr.flowarg.gunsofchickens.commands;

import net.minecraft.command.CommandGameMode;
import net.minecraft.command.ICommandSender;

public class CommandGamemode extends CommandGameMode
{
    @Override
    public String getName() {
        return "gm";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "gm";
    }
}
