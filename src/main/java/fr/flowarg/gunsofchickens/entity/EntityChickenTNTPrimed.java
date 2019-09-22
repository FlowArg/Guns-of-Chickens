package fr.flowarg.gunsofchickens.entity;

import fr.flowarg.gunsofchickens.utils.handlers.ConfigHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityChickenTNTPrimed extends EntityTNTPrimed
{
    private int fuseII = super.getFuse();
    public EntityChickenTNTPrimed(World world)
    {
        super(world);
    }

    public EntityChickenTNTPrimed(World worldIn, double x, double y, double z, EntityLivingBase igniter)
    {
        super(worldIn, x, y, z, igniter);
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (!this.hasNoGravity())
        {
            this.motionY -= 0.03999999910593033D;
        }

        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        --this.fuseII;

        if (this.fuseII <= 0)
        {
            this.setDead();

            if (!this.world.isRemote)
            {
                explode();
            }
        }
        else
        {
            this.handleWaterMovement();
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private void explode()
    {
        float strength = ConfigHandler.strength;
        this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / strength), this.posZ, strength, true);
    }

    public int getFuseII() {
        return fuseII;
    }
}