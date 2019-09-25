package fr.flowarg.gunsofchickens.commands;

import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandID extends CommandBase
{
    @Override
    public String getName()
    {
        return "id";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "id";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if(sender instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)sender;

            if (player.inventory.hasItemStack(player.inventory.getCurrentItem()))
            {
                Item item = UtilObjects.getInstance().getItemFromItemStack(player.inventory.getCurrentItem());
                int itemID = Item.getIdFromItem(item);
                player.sendMessage(new TextComponentString(TextFormatting.GREEN + "Id of " + item.getItemStackDisplayName(new ItemStack(item)) + " is : " + itemID));
            }
            else
            {
                player.sendMessage(new TextComponentString(TextFormatting.GOLD + "Id of Air is : 0 !"));
            }
        }
        else
        {
            sender.sendMessage(new TextComponentString(TextFormatting.DARK_RED + "You must to be a player to use this command !"));
        }
    }
}
