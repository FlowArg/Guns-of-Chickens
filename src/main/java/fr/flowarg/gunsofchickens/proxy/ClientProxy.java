package fr.flowarg.gunsofchickens.proxy;

import fr.flowarg.gunsofchickens.gui.ShowLogo;
import fr.flowarg.gunsofchickens.utils.handlers.RegistryHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

import java.util.Date;

import static fr.flowarg.gunsofchickens.utils.References.NAME;
import static fr.flowarg.gunsofchickens.utils.References.VERSION;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    private static final Minecraft MC = Minecraft.getMinecraft();
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        Display.setTitle("Minecraft 1.12.2 " + NAME + "-" + VERSION);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
        RegistryHandler.postInitRegistriesCLP(event);
    }

    @Override
    public void registerItemRenderer(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

    private static String cdc = " ";

    private static KeyBinding keyBindLogo;
    private static KeyBinding keyBindModVersion;
    private static KeyBinding keyBindHour;

    public ClientProxy()
    {
        MinecraftForge.EVENT_BUS.register(this);

        keyBindLogo = new KeyBinding("logo.key", Keyboard.KEY_K, "key.categories.gunsofchickens");
        keyBindModVersion = new KeyBinding("modversion.key", Keyboard.KEY_M, "key.categories.gunsofchickens");
        keyBindHour = new KeyBinding("hour.key", Keyboard.KEY_H, "key.categories.gunsofchickens");

        registerKeys(keyBindLogo);
        registerKeys(keyBindModVersion);
        registerKeys(keyBindHour);
    }

    @SubscribeEvent
    public void onEvent(InputEvent.KeyInputEvent event)
    {
        if (keyBindLogo.isKeyDown())
            Minecraft.getMinecraft().displayGuiScreen(new ShowLogo());
    }

    @SubscribeEvent
    public void onOverlay(RenderGameOverlayEvent.Text e)
    {
        if(keyBindHour.isKeyDown() && keyBindModVersion.isKeyDown()) return;

        if (keyBindModVersion.isKeyDown())
        {
            cdc = NAME + " : " + VERSION;
            e.getLeft().add(cdc);
        }
        else if(keyBindHour.isKeyDown())
        {
            cdc = new Date().toString();
            e.getLeft().add(cdc);
        }
        else
        {
            cdc = " ";
            e.getLeft().clear();
        }
    }

    private void registerKeys(KeyBinding key)
    {
        ClientRegistry.registerKeyBinding(key);
    }
}
