package fr.flowarg.gunsofchickens.commands;

import com.google.common.collect.Lists;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.command.ICommandSender;

import java.util.List;

public class CommandGameMode extends net.minecraft.command.CommandGameMode
{
    private final List<String> aliases = Lists.newArrayList(References.MODID + "gmode" + "gmod");

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

    @Override
    public List<String> getAliases()
    {
        return this.aliases;
    }
}
