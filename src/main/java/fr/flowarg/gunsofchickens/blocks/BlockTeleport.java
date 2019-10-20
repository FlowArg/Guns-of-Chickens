package fr.flowarg.gunsofchickens.blocks;

import fr.flowarg.flowutils.UtilLocation;
import fr.flowarg.gunsofchickens.commands.util.Teleport;
import fr.flowarg.gunsofchickens.templates.BlockBase;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.block.SoundType;
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
        super(name, Material.ROCK, 500f, 32f, "pickaxe", 1, SoundType.METAL);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if (!worldIn.isRemote)
        {
            Teleport.teleportDimension(playerIn, ConfigHandler.CHICKEN_DIM, UtilLocation.getPlayerX(playerIn), UtilLocation.getPlayerY(playerIn) + 5, UtilLocation.getPlayerZ(playerIn));
            return true;
        }
        return false;
    }
}
