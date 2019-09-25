package fr.flowarg.gunsofchickens.gui;

import fr.flowarg.gunsofchickens.utils.References;
import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GUIFactory implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft minecraftInstance)
    {

    }

    @Override
    public boolean hasConfigGui()
    {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen)
    {
        return new GUIConfig(parentScreen);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    public static class GUIConfig extends GuiConfig
    {
        public GUIConfig(GuiScreen parent)
        {
            super(parent, getConfigElements(), References.MODID, false, false, "Guns of Chickens CONFIG");
        }

        private static List <IConfigElement>getConfigElements()
        {
            List<IConfigElement> list = new ArrayList<IConfigElement>();
            list.add(new DummyConfigElement.DummyCategoryElement("Locations", "", new ConfigElement(ConfigHandler.getConfig().getCategory("Locations")).getChildElements()));
            list.add(new DummyConfigElement.DummyCategoryElement("IDs", "", new ConfigElement(ConfigHandler.getConfig().getCategory("IDs")).getChildElements()));
            list.add(new DummyConfigElement.DummyCategoryElement("Other", "", new ConfigElement(ConfigHandler.getConfig().getCategory("Other")).getChildElements()));
            return list;
        }

    }
}
