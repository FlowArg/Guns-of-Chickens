package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import fr.flowarg.gunsofchickens.utils.util.UtilObjects;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static fr.flowarg.gunsofchickens.init.BlockInit.*;
import static fr.flowarg.gunsofchickens.init.ItemInit.*;
import static net.minecraft.init.Blocks.CONCRETE;
import static net.minecraft.init.Blocks.PLANKS;

public class BlockDecrafter extends ItemBase
{
    public BlockDecrafter(String name)
    {
        super(name);
        setMaxStackSize(1);
        setMaxDamage(64);
        setCreativeTab(Main.modtabUtils);
    }

    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        if(!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos).getBlock();

            if(block == MULTICOLORED_CHICKEN_BLOCK)
            {
                Random random = new Random();
                int metaRandom = 0;
                int randomNumber;
                int max = 11;
                randomNumber = random.nextInt(max) + 1;

                switch (randomNumber)
                {
                    case 1:
                        metaRandom = 0;
                        break;
                    case 2:
                        metaRandom = 1;
                        break;
                    case 3:
                        metaRandom = 4;
                        break;
                    case 4:
                        metaRandom = 5;
                        break;
                    case 5:
                        metaRandom = 6;
                        break;
                    case 6:
                        metaRandom = 7;
                        break;
                    case 7:
                        metaRandom = 11;
                        break;
                    case 8:
                        metaRandom = 12;
                        break;
                    case 9:
                        metaRandom = 14;
                        break;
                    case 10:
                        metaRandom = 15;
                        break;
                }

                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, metaRandom, 1);
            }
            if (block == BLACK_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 15, 1);
            }
            if (block == BLUE_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7f, 0d, 1, 11, 1);
            }
            if (block == BROW_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 12, 1);
            }
            if (block == GRAY_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 7, 1);
            }
            if (block == GREEN_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 5, 1);
            }
            if (block == ORANGE_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 1, 1);
            }
            if (block == PINK_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 6, 1);
            }
            if (block == YELLOW_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 4, 1);
            }
            if (block == RED_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 14, 1);
            }
            if(block == WHITE_CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 0, 1);
            }

            if(block == CHICKEN_TNT)
            {
                createSpawnEntityLoot(false, CHICKEN_WITH_TNT, worldIn, pos, player, 0d, 0.7d, 0d, 1, 1);
            }
            if(block == CHICKEN_ORE)
            {
                messageRIP(player, worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == CHICKEN_COAL_ORE)
            {
                messageRIP(player, worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == CHICKEN_DIAMOND_ORE)
            {
                messageRIP(player, worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == CHICKEN_LADDER)
            {
                createSpawnEntityLoot(false, CHICKEN_STICK, worldIn, pos, player, 0d, 0.7d, 0d, 3, 1);
            }
            if(block == CHICKEN_BLOCK)
            {
                createSpawnEntityLoot(false, CHICKEN_INGOT, worldIn, pos, player, 0d, 0.7d, 0d, 9, 1);
            }

            if(block == CHICKEN_DIAMOND_BLOCK)
            {
                createSpawnEntityLoot(false, CHICKEN_DIAMOND, worldIn, pos, player, 0D, 1D, 0D, 9, 1);
            }

            if(block == PLANKS)
            {
                createSpawnEntityLoot(false, CHICKEN_WOOD, worldIn, pos, player, 0D, 1D, 0D,1, 1);
            }
            if (block == CHICKEN_WOOD)
            {
                createSpawnEntityLoot(false, CHICKEN_STICK, worldIn, pos, player, 0d, 1D, 0D, 2, 1);
            }
            if (block == CHICKEN_FURNACE)
            {
                createSpawnEntityLoot(false, CHICKEN_BLOCK, worldIn, pos, player, 0d, 1d, 0d, 8, 1);
            }
            if (block == ULTIMATE_BLOCK)
            {
                createSpawnEntityLoot(false, ULTIMATE_INGOT, worldIn, pos, player, 0d, 1d, 0d, 9, 1);
            }
            if (block == DIMENSION_CHANGER)
            {
                createSpawnEntityLoot(DIMENSION_CHANGER, worldIn, pos, player);
            }
            if (block == CHICKEN_CHEST)
            {
                createSpawnEntityLoot(false, CHICKEN_BLOCK, worldIn, pos, player, 0d, 1d, 0d, 8, 1);
            }

        }

        return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
    }

    private void createSpawnEntityLoot(boolean isBlockDrop,Block blockToSpawn, World world, BlockPos pos, EntityPlayer player, double plusPosX, double plusPosY, double plusPosZ, int amountIS, int amountDI)
    {
        world.destroyBlock(pos, isBlockDrop);

        EntityItem loot = new EntityItem(world);
        loot.setPosition(pos.getX() + plusPosX, pos.getY() + plusPosY, pos.getZ() + plusPosZ) ;
        loot.setItem(new ItemStack(blockToSpawn, amountIS));
        player.getHeldItemMainhand().damageItem(amountDI, player);

        world.spawnEntity(loot);
    }

    private void createSpawnEntityLoot(boolean isBlockDrop,Block blockToSpawn, World world, BlockPos pos, EntityPlayer player, double plusPosX, double plusPosY, double plusPosZ, int amountIS, int metadata, int amountDI)
    {
        world.destroyBlock(pos, isBlockDrop);

        EntityItem loot = new EntityItem(world);
        loot.setPosition(pos.getX() + plusPosX, pos.getY() + plusPosY, pos.getZ() + plusPosZ) ;
        loot.setItem(new ItemStack(blockToSpawn, amountIS, metadata));
        player.getHeldItemMainhand().damageItem(amountDI, player);

        world.spawnEntity(loot);
    }

    private void createSpawnEntityLoot(boolean isBlockDrop,Item itemToSpawn, World world, BlockPos pos, EntityPlayer player, double plusPosX, double plusPosY, double plusPosZ, int amountIS, int amountDI)
    {
        world.destroyBlock(pos, isBlockDrop);

        EntityItem loot = new EntityItem(world);
        loot.setPosition(pos.getX() + plusPosX, pos.getY() + plusPosY, pos.getZ() + plusPosZ) ;
        loot.setItem(new ItemStack(itemToSpawn, amountIS));
        player.getHeldItemMainhand().damageItem(amountDI, player);

        world.spawnEntity(loot);
    }

    private void createSpawnEntityLoot(Block blockDecrafter, World world, BlockPos pos, EntityPlayer player)
    {
        world.destroyBlock(pos, true);

        EntityItem loot = new EntityItem(world);
        loot.setPosition(pos.getX(), pos.getY(), pos.getZ()) ;
        loot.setItem(new ItemStack(blockDecrafter, 1));
        player.getHeldItemMainhand().damageItem(1, player);

        world.spawnEntity(loot);
    }

    private void messageRIP(EntityPlayer player, World world, BlockPos pos, boolean isBlockDrop, String message)
    {
        world.destroyBlock(pos, isBlockDrop);
        UtilObjects.getInstance().sendMessageToPlayer(player, message);
    }

}
