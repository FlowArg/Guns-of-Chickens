package fr.flowarg.gunsofchickens.utils.handlers;

import fr.flowarg.gunsofchickens.blocks.containers.ContainerChickenChest;
import fr.flowarg.gunsofchickens.blocks.containers.ContainerChickenFurnace;
import fr.flowarg.gunsofchickens.blocks.gui.GUIChickenChest;
import fr.flowarg.gunsofchickens.blocks.gui.GUIChickenFurnace;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == ConfigHandler.GUI_CHICKEN_FURNACE) return new ContainerChickenFurnace(player.inventory, (TileEntityChickenFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_CHICKEN_CHEST) return new ContainerChickenChest(player.inventory, (TileEntityChickenChest)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if (ID == ConfigHandler.GUI_CHICKEN_FURNACE) return new GUIChickenFurnace(player.inventory, (TileEntityChickenFurnace)world.getTileEntity(new BlockPos(x, y, z)));
        if (ID == ConfigHandler.GUI_CHICKEN_CHEST) return new GUIChickenChest(player.inventory, (TileEntityChickenChest)world.getTileEntity(new BlockPos(x, y, z)));
        return null;
    }
}
