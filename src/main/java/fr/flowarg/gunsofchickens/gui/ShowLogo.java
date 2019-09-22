package fr.flowarg.gunsofchickens.gui;

import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class  ShowLogo extends GuiScreen
{
    private static final ResourceLocation LOGO = new ResourceLocation(References.MODID + ":textures/gui/showlogo/chickenlogo.png");

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        drawDefaultBackground();
        mc.getTextureManager().bindTexture(LOGO);
        //drawModalRectWithCustomSizedTexture(210, 80, 0, 0, 190, 190, 190, 190);
        drawModalRectWithCustomSizedTexture(210, 80, 0, 0, this.width / 2 , this.height / 2, 190, 190);
    }

}
