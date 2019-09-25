package fr.flowarg.gunsofchickens.utils.handlers;

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
import fr.flowarg.gunsofchickens.world.biomes.BiomeChicken;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;

import static net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = References.MODID)
public class RegistryHandler
{
    public static void preInitRegistriesCOP(FMLPreInitializationEvent event)
    {
        EntityInit.registerEntities();
        Main.LOGGER.debug("Entities registered.");
        addSpawnOfEntity();
        Main.LOGGER.debug("Added spawn of entities in world.");
        Main.LOGGER.debug("Registering config...");
        ConfigHandler.registerConfig(event);
        Main.LOGGER.debug("Config registered.");
        BiomeInit.registerBiomes();
        Main.LOGGER.debug("Registered biomes.");
        DimensionInit.registerDimensions();
        Main.LOGGER.debug("Registered dimensions.");
    }

    private static void addSpawnOfEntity()
    {
        Main.LOGGER.debug("Adding spawn of entities in world...");
        Set<Biome> validBiomes = new HashSet<>();
        validBiomes.add(new BiomeChicken());
        EntityRegistry.addSpawn(EntityKikiChicken.class, 10, 2, 5, EnumCreatureType.AMBIENT, validBiomes.toArray(new Biome[validBiomes.size()]));
    }

    public static void postInitRegistriesCLP(FMLPostInitializationEvent event)
    {
        //RenderHandler.registerEntitiesRenders();
        EntityInit.registerEntitiesRender();
        Main.LOGGER.debug("Registered entities renders.");
    }

    public static void serverRegistries(FMLServerStartingEvent event)
    {
        registerCommands(event);
        Main.LOGGER.debug("Registered commands.");
    }

    private static void registerCommands(FMLServerStartingEvent event)
    {
        Main.LOGGER.debug("Registering commands...");
        event.registerServerCommand(new CommandDimensionTeleport());
        Main.LOGGER.debug("Registering command Dimension Teleport.");
        event.registerServerCommand(new CommandGameMode());
        Main.LOGGER.debug("Registering command GameMode...");
        event.registerServerCommand(new CommandFlow());
        Main.LOGGER.debug("Registering command Flow...");
        event.registerServerCommand(new CommandSpawn());
        Main.LOGGER.debug("Registering command Spawn...");
        event.registerServerCommand(new CommandRandomTP());
        Main.LOGGER.debug("Registering command Random TP...");
        event.registerServerCommand(new CommandBreakChicken());
        Main.LOGGER.debug("Registering command Break Chicken...");
        event.registerServerCommand(new CommandID());
        Main.LOGGER.debug("Registering command ID...");
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
        BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(Item.getItemFromBlock(BlockInit.chicken_tnt), new BehaviorDefaultDispenseItem()
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
        RecipesInit.instance.initRecipes();
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
        Main.proxy.registerItemRenderer(Item.getItemFromBlock(BlockInit.chicken_chest), 0);
        Main.LOGGER.debug("Registering TileEntities rendered...");
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityChickenChest.class, new RenderChickenChest());
        Main.LOGGER.debug("Registered TileEntities rendered.");
        Main.LOGGER.debug("Model registered for : " + BlockInit.chicken_chest.getLocalizedName());

        for (Item item : ItemInit.ITEMS)
        {
            if (item instanceof IHasModel)
            {
                ((IHasModel)item).registerModels();
                Main.LOGGER.debug("Model registered for : " + item.getItemStackDisplayName(new ItemStack(item)));
            }
        }
        Main.LOGGER.debug("Models registered for Items.");

        for (Block block : BlockInit.BLOCKS)
        {
            if (block instanceof IHasModel)
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
            event.player.sendMessage(new TextComponentString("§e[Guns of Chickens] " +"§2" + ConfigHandler.welcomeMessage.replaceAll("%player%", event.player.getName())));
        }
    }

    @SubscribeEvent
    public static void onConfigChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.getModID().equals(References.MODID))
        {
            ConfigHandler.syncConfig(ConfigHandler.configFile);
        }
    }
}
