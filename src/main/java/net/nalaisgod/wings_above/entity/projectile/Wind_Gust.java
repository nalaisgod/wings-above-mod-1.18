package net.nalaisgod.wings_above.entity.projectile;

/*
 * Decompiled with CFR 0.0.9 (FabricMC cc05e23f).
 */

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Wind_Gust
        extends ExplosiveProjectileEntity implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    public Wind_Gust(EntityType<? extends Wind_Gust> entityType, World world) {
        super((EntityType<? extends ExplosiveProjectileEntity>)entityType, world);
    }

    public Wind_Gust(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ) {
        super((EntityType<? extends ExplosiveProjectileEntity>)EntityType.SMALL_FIREBALL, owner, velocityX, velocityY, velocityZ, world);
    }

    public Wind_Gust(World world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super((EntityType<? extends ExplosiveProjectileEntity>)EntityType.SMALL_FIREBALL, x, y, z, velocityX, velocityY, velocityZ, world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (this.world.isClient) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        if (!entity.isFireImmune()) {
            Entity entity2 = this.getOwner();
            int i = entity.getFireTicks();
            entity.setOnFireFor(5);
            boolean bl = entity.damage(DamageSource.MAGIC, 5.0f);
            if (!bl) {
                entity.setFireTicks(i);
            } else if (entity2 instanceof LivingEntity) {
                this.applyDamageEffects((LivingEntity)entity2, entity);
            }
        }
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockPos blockPos;
        super.onBlockHit(blockHitResult);
        if (this.world.isClient) {
            return;
        }
        Entity entity = this.getOwner();
        if ((!(entity instanceof MobEntity) || this.world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) && this.world.isAir(blockPos = blockHitResult.getBlockPos().offset(blockHitResult.getSide()))) {
            this.world.setBlockState(blockPos, AbstractFireBlock.getState(this.world, blockPos));
        }
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.world.isClient) {
            this.discard();
        }
    }

    @Override
    public boolean collides() {
        return false;
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        return false;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    // ANIMATIONS
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.wind_gust.idle", true));
        return PlayState.CONTINUE;
    }
}


