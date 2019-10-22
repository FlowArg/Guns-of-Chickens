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

import static fr.flowarg.gunsofchickens.utils.References.*;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    private String cdc = null;

    private final KeyBinding keyBindLogo;
    private final KeyBinding keyBindModVersion;
    private final KeyBinding keyBindHour;

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
        Display.setTitle(DISPLAY_TITLE);
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
        RegistryHandler.postInitRegistriesCLP();
    }

    @Override
    public void registerItemRenderer(Item item, int meta)
    {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(),"inventory"));
    }

    public ClientProxy()
    {
        MinecraftForge.EVENT_BUS.register(this);

        this.keyBindLogo = new KeyBinding("logo.key", Keyboard.KEY_K, "key.categories.gunsofchickens");
        this.keyBindModVersion = new KeyBinding("modversion.key", Keyboard.KEY_M, "key.categories.gunsofchickens");
        this.keyBindHour = new KeyBinding("hour.key", Keyboard.KEY_H, "key.categories.gunsofchickens");

        this.registerKeys(keyBindLogo);
        this.registerKeys(keyBindModVersion);
        this.registerKeys(keyBindHour);
    }

    @SubscribeEvent
    public void onKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        if (this.keyBindLogo.isKeyDown())
            Minecraft.getMinecraft().displayGuiScreen(new ShowLogo());
    }

    @SubscribeEvent
    public void onOverlay(RenderGameOverlayEvent.Text event)
    {
        if(this.keyBindHour.isKeyDown() && this.keyBindModVersion.isKeyDown()) return;

        if (this.keyBindModVersion.isKeyDown())
        {
            this.cdc = NAME + " : " + VERSION;
            event.getLeft().add(cdc);
        }
        else if(this.keyBindHour.isKeyDown())
        {
            this.cdc = new Date().toString();
            event.getRight().add(cdc);
        }
        else
        {
            this.cdc = null;
        }
    }

    private void registerKeys(KeyBinding key)
    {
        ClientRegistry.registerKeyBinding(key);
    }
}
