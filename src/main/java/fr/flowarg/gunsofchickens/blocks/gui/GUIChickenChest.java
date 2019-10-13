package fr.flowarg.gunsofchickens.blocks.gui;

import fr.flowarg.gunsofchickens.blocks.containers.ContainerChickenChest;
import fr.flowarg.gunsofchickens.blocks.tileentities.TileEntityChickenChest;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIChickenChest extends GuiContainer
{
    private static final ResourceLocation GUI_CHEST = new ResourceLocation(References.MODID + ":textures/gui/container/chicken_chest.png");
    private final InventoryPlayer playerInv;
    private final TileEntityChickenChest te;

    public GUIChickenChest(InventoryPlayer playerInventory, TileEntityChickenChest chestInventory)
    {
        super(new ContainerChickenChest(playerInventory, chestInventory));
        this.playerInv = playerInventory;
        this.te = chestInventory;

        this.xSize = 179;
        this.ySize = 256;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(), 8, 6, 16086784);
        this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, this.ySize - 92, 16086784);
    }

    @Override
    public boolean doesGuiPauseGame()
    {
        return false;
    }
}
