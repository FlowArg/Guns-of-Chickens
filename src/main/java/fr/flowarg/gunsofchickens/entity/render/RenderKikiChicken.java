package fr.flowarg.gunsofchickens.entity.render;

import fr.flowarg.gunsofchickens.entity.EntityKikiChicken;
import fr.flowarg.gunsofchickens.utils.References;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderKikiChicken extends RenderLiving<EntityKikiChicken>
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(References.MODID + ":textures/entity/chicken/kiki/texture.png");

    public RenderKikiChicken(RenderManager manager)
    {
        super(manager, new ModelChicken(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKikiChicken entity)
    {
        return TEXTURES;
    }
}