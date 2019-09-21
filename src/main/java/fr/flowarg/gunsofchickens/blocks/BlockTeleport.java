package fr.flowarg.gunsofchickens.blocks;

import fr.flowarg.gunsofchickens.commands.util.Teleport;
import fr.flowarg.gunsofchickens.templates.BlockBase;
import fr.flowarg.gunsofchickens.utils.util.UtilLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTeleport extends BlockBase
{
    public BlockTeleport(String name)
    {
        super(name, Material.ROCK, 500f, 32f, "pickaxe", 1);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            Teleport.teleportDimension(playerIn, 2, getX(playerIn), getY(playerIn) + 5, getZ(playerIn));
            return true;
        }
        return false;
    }

    private static UtilLocation getInstance()
    {
        return UtilLocation.getInstance();
    }

    private double getX(EntityPlayer playerIn)
    {
        return getInstance().getPlayerX(playerIn);
    }

    private double getY(EntityPlayer playerIn)
    {
        return getInstance().getPlayerY(playerIn);
    }

    private double getZ(EntityPlayer playerIn)
    {
        return getInstance().getPlayerZ(playerIn);
    }
}
