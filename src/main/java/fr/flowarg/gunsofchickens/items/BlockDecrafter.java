package fr.flowarg.gunsofchickens.items;

import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.init.BlockInit;
import fr.flowarg.gunsofchickens.init.ItemInit;
import fr.flowarg.gunsofchickens.templates.ItemBase;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.Random;

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

            if(block == BlockInit.multicolored_chicken_block)
            {
                Random random = new Random();
                int metaRandom = 0;
                int randomNumber;
                int min = 1;
                int max = 11;
                randomNumber = random.nextInt(max - min) + min;

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

                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, metaRandom, 1);
            }
            if (block == BlockInit.black_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 15, 1);
            }
            if (block == BlockInit.blue_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7f, 0d, 1, 11, 1);
            }
            if (block == BlockInit.brown_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 12, 1);
            }
            if (block == BlockInit.gray_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 7, 1);
            }
            if (block == BlockInit.green_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 5, 1);
            }
            if (block == BlockInit.orange_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 1, 1);
            }
            if (block == BlockInit.pink_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 6, 1);
            }
            if (block == BlockInit.yellow_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 4, 1);
            }
            if (block == BlockInit.red_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 14, 1);
            }
            if(block == BlockInit.white_chicken_block)
            {
                createSpawnEntityLoot(false, Blocks.CONCRETE, worldIn, pos, player, 0d, 0.7d, 0d, 1, 0, 1);
            }

            if(block == BlockInit.chicken_tnt)
            {
                createSpawnEntityLoot(false, ItemInit.chicken_with_tnt, worldIn, pos, player, 0d, 0.7d, 0d, 1, 1);
            }
            if(block == BlockInit.chicken_ore)
            {
                messageRIP(worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == BlockInit.chicken_coal_ore)
            {
                messageRIP(worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == BlockInit.chicken_diamond_ore)
            {
                messageRIP(worldIn, pos, false, "R.I.P ! Don't use the BlockDecrafter on Ore !!");
            }
            if(block == BlockInit.chicken_ladder)
            {
                createSpawnEntityLoot(false, ItemInit.chicken_stick, worldIn, pos, player, 0d, 0.7d, 0d, 3, 1);
            }
            if(block == BlockInit.chicken_block)
            {
                createSpawnEntityLoot(false, ItemInit.chicken_ingot, worldIn, pos, player, 0d, 0.7d, 0d, 9, 1);
            }

            if(block == BlockInit.chicken_diamond_block)
            {
                createSpawnEntityLoot(false, ItemInit.chicken_diamond, worldIn, pos, player, 0D, 1D, 0D, 9, 1);
            }

            if(block == Blocks.PLANKS)
            {
                createSpawnEntityLoot(false, BlockInit.chicken_wood, worldIn, pos, player, 0D, 1D, 0D,1, 1);
            }
            if (block == BlockInit.chicken_furnace)
            {
                createSpawnEntityLoot(false, BlockInit.chicken_block, worldIn, pos, player, 0d, 1d, 0d, 8, 1);
            }
            if (block == BlockInit.ultimate_block)
            {
                createSpawnEntityLoot(false, ItemInit.ultimate_ingot, worldIn, pos, player, 0d, 1d, 0d, 9, 1);
            }
            if (block == BlockInit.dimensionChanger)
            {
                createSpawnEntityLoot(BlockInit.dimensionChanger, worldIn, pos, player);
            }
            if (block == BlockInit.chicken_chest)
            {
                createSpawnEntityLoot(false, BlockInit.chicken_block, worldIn, pos, player, 0d, 1d, 0d, 8, 1);
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

    private void messageRIP(World world, BlockPos pos, boolean isBlockDrop, String message)
    {
        world.destroyBlock(pos, isBlockDrop);
        Minecraft.getMinecraft().getIntegratedServer().sendMessage(new TextComponentString(message));
    }

}
