package fr.flowarg.gunsofchickens.utils.handlers;

import fr.flowarg.flowutils.UtilLocation;
import fr.flowarg.gunsofchickens.Main;
import fr.flowarg.gunsofchickens.blocks.animation.chickenchest.RenderChickenChest;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import fr.flowarg.gunsofchickens.commands.*;
import fr.flowarg.gunsofchickens.entity.EntityChickenTNTPrimed;
import fr.flowarg.gunsofchickens.entity.EntityKikiChicken;
import fr.flowarg.gunsofchickens.init.*;
import fr.flowarg.gunsofchickens.utils.IHasModel;
import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.compat.OreDictionnaryCompat;
import fr.flowarg.gunsofchickens.world.gen.GenOres;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

import java.util.Objects;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = References.MODID)
public class RegistryHandler
{
    public static void preInitRegistriesCOP(FMLPreInitializationEvent event)
    {
        Main.LOGGER.debug("Registering config...");
        ConfigHandler.registerConfig(event);
        Main.LOGGER.debug("Config registered.");
        EntityInit.registerEntities();
        Main.LOGGER.debug("Entities registered.");
        addSpawnOfEntity();
        Main.LOGGER.debug("Added spawn of entities in world.");
        BiomeInit.registerBiomes();
        Main.LOGGER.debug("Registered biomes.");
        DimensionInit.registerDimensions();
        Main.LOGGER.debug("Registered dimensions.");
    }

    private static void addSpawnOfEntity()
    {
        Main.LOGGER.debug("Adding spawn of entities in world...");
        EntityRegistry.addSpawn(EntityKikiChicken.class, 10, 2, 5, EnumCreatureType.AMBIENT, BiomeInit.CHICKEN, Biome.getBiome(3));
    }

    @SideOnly(Side.CLIENT)
    public static void postInitRegistriesCLP()
    {
        //RenderHandler.registerEntitiesRenders();
        EntityInit.registerEntitiesRender();
        Main.LOGGER.debug("Registered entities renders.");
    }

    public static void registerCommands(FMLServerStartingEvent event)
    {
        Main.LOGGER.debug("Registering commands...");
        Main.LOGGER.debug("Registering command Dimension Teleport.");
        event.registerServerCommand(new CommandDimensionTeleport());
        Main.LOGGER.debug("Registering command GameMode...");
        event.registerServerCommand(new CommandGamemode());
        Main.LOGGER.debug("Registering command Flow...");
        event.registerServerCommand(new CommandFlow());
        Main.LOGGER.debug("Registering command Spawn...");
        event.registerServerCommand(new CommandSpawn());
        Main.LOGGER.debug("Registering command Random TP...");
        event.registerServerCommand(new CommandRandomTP());
        Main.LOGGER.debug("Registering command ID...");
        event.registerServerCommand(new CommandID());
        Main.LOGGER.debug("Registering command Teleport Biome...");
        event.registerServerCommand(new CommandBiomeTeleport());
        Main.LOGGER.debug("Registered commands.");
    }

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event)
    {
        Main.LOGGER.debug("Registering Items...");
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
        Main.LOGGER.debug("Registered Items.");
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        Main.LOGGER.debug("Registering Blocks...");
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
        Main.LOGGER.debug("Registered Blocks.");
        Main.LOGGER.debug("Registering TileEntities...");
        TileEntityHandler.registerTileEntities();
        Main.LOGGER.debug("Registered TileEntities.");
    }

    public static void initRegistriesCOP()
    {
        Main.LOGGER.debug("Registering TNT in Dispenser...");
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(BlockInit.CHICKEN_TNT), new BehaviorDefaultDispenseItem()
        {
            public ItemStack dispenseStack(IBlockSource source, ItemStack stack)
            {
                World world = source.getWorld();
                BlockPos blockpos = source.getBlockPos().offset(source.getBlockState().getValue(BlockDispenser.FACING));
                EntityChickenTNTPrimed entityChickenTNTPrimed = new EntityChickenTNTPrimed(world, (double)blockpos.getX() + 0.5D, blockpos.getY(), (double)blockpos.getZ() + 0.5D, null);
                world.spawnEntity(entityChickenTNTPrimed);
                world.playSound(null, entityChickenTNTPrimed.posX, entityChickenTNTPrimed.posY, entityChickenTNTPrimed.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
                stack.shrink(1);
                return stack;
            }
        });
        Main.LOGGER.debug("Registered TNT in Dispenser.");
        RecipesInit.initRecipes();
        Main.LOGGER.debug("Recipes registered.");
        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GUIHandler());
        Main.LOGGER.debug("GUIs registered.");
        OreDictionnaryCompat.registerOres();
        Main.LOGGER.debug("Ores registered.");
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for (Item item : ItemInit.ITEMS)
        {
            if(item == Item.getItemFromBlock(BlockInit.CHICKEN_CHEST))
            {
                Main.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.CHICKEN_CHEST), 0);
            }
            else if (item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
                Main.LOGGER.debug("Model registered for : " + item.getItemStackDisplayName(new ItemStack(item)));
            }
        }
        Main.LOGGER.debug("Models registered for Items.");

        for (Block block : BlockInit.BLOCKS)
        {
            if(block == BlockInit.CHICKEN_CHEST)
            {
                Main.LOGGER.debug("Registering TileEntities rendered...");
                ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChickenChest.class, new RenderChickenChest());
                Main.LOGGER.debug("Model registered for : " + BlockInit.CHICKEN_CHEST.getLocalizedName());
                Main.LOGGER.debug("Registered TileEntities rendered.");
            }
            else if (block instanceof IHasModel)
            {
                ((IHasModel)block).registerModels();
                Main.LOGGER.debug("Model registered for : " + block.getLocalizedName());
            }
        }
        Main.LOGGER.debug("Models registered for Blocks.");

        Main.LOGGER.debug("Models registered.");
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event)
    {
        if(ConfigHandler.showWelcomeMessage)
        {
            event.player.sendMessage(new TextComponentString(References.CHAT_REF +"§2" + ConfigHandler.welcomeMessage.replaceAll("%player%", event.player.getName())));
        }
    }

    @SubscribeEvent
    public static void onEntityHurt(LivingHurtEvent event)
    {
        if(event.getSource().getImmediateSource() instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer)event.getSource().getImmediateSource();
            World world = event.getEntityLiving().world;
            if(player.inventory.getCurrentItem().getItem() == ItemInit.ULTIMATE_SWORD || player.inventory.getCurrentItem().getItem() == ItemInit.CHICKEN_DIAMOND_SWORD || player.inventory.getCurrentItem().getItem() == ItemInit.CHICKEN_SWORD)
            {
                double mX = UtilLocation.getPlayerMotionX(player);
                double mY = UtilLocation.getPlayerMotionY(player);
                double mZ = UtilLocation.getPlayerMotionZ(player);
                double x = UtilLocation.getEntityX(event.getEntityLiving());
                double y = UtilLocation.getEntityY(event.getEntityLiving());
                double z = UtilLocation.getEntityZ(event.getEntityLiving());

                player.motionX = mX - 1;
                player.motionY = mY + 5;

                EntityLightningBolt bolt = new EntityLightningBolt(world, x, y, z, false);
                bolt.setPosition(x, y, z);
                world.spawnEntity(bolt);
                world.playSound(player, x, y, z, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.WEATHER, 20f, 1f);
                if (event.getEntityLiving() instanceof EntityPlayer)
                {
                    EntityPlayer playerHurted = (EntityPlayer)event.getEntityLiving();
                    world.playSound(playerHurted, x, y, z, SoundEvents.ENTITY_LIGHTNING_IMPACT, SoundCategory.WEATHER, 20f, 1f);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(References.MODID))
        {
            if (ConfigHandler.config.hasChanged())
            {
                ConfigHandler.config.save();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {
        EntityPlayer player = (EntityPlayer) event.player;
        ItemStack helmet = player.inventory.armorInventory.get(3);
        ItemStack chestplate = player.inventory.armorInventory.get(2);
        ItemStack leggings = player.inventory.armorInventory.get(1);
        ItemStack boots = player.inventory.armorInventory.get(0);
        if (helmet.getItem() == ItemInit.ULTIMATE_HELMET && chestplate.getItem() == ItemInit.ULTIMATE_CHESTPLATE && leggings.getItem() == ItemInit.ULTIMATE_LEGGINGS && boots.getItem() == ItemInit.ULTIMATE_BOOTS)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.INVISIBILITY, 5, 3, false, false));
            player.capabilities.allowFlying = true;
        }
    }

    @SubscribeEvent
    public static void onExplosion(ExplosionEvent.Detonate event)
    {
        event.getAffectedBlocks().removeIf(pos -> event.getWorld().getBlockState(pos).getBlock() == BlockInit.CHICKEN_DIAMOND_ORE);
        event.getAffectedBlocks().removeIf(pos -> event.getWorld().getBlockState(pos).getBlock() == BlockInit.CHICKEN_ORE);
        event.getAffectedBlocks().removeIf(pos -> event.getWorld().getBlockState(pos).getBlock() == BlockInit.CHICKEN_DIAMOND_BLOCK);
        event.getAffectedBlocks().removeIf(pos -> event.getWorld().getBlockState(pos).getBlock() == BlockInit.CHICKEN_BLOCK);
        event.getAffectedBlocks().removeIf(pos -> event.getWorld().getBlockState(pos).getBlock() == BlockInit.ULTIMATE_BLOCK);
        event.getAffectedEntities().removeIf(entity -> entity instanceof EntityKikiChicken);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onShowTooltip(ItemTooltipEvent event)
    {
        Item eventItem = event.getItemStack().getItem();

        for (Item item : ItemInit.ITEMS)
        {
            if(eventItem == item)
            {
                if(!Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
                    event.getToolTip().add("Press Left Shift for more informations.");
                if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
                {
                    if(item == Item.getItemFromBlock(BlockInit.CHICKEN_FURNACE))
                    {
                        event.getToolTip().add("This block doesn't correctly work.");
                    }
                }
            }
        }
    }

    public static void otherRegistries()
    {
        GameRegistry.registerWorldGenerator(new GenOres(), 0);
    }
}
