package net.nalaisgod.wings_above.entity.projectile;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.nalaisgod.wings_above.effect.ModPotions;
import net.nalaisgod.wings_above.item.ModItems;

public class HealBall extends ThrownItemEntity{
    private int duration = 200;


    public HealBall(EntityType<? extends HealBall> entityType, World world) {
        super((EntityType<? extends ThrownItemEntity>)entityType, world);
    }

    public HealBall(World world, LivingEntity owner) {
        super(EntityType.SNOWBALL, owner, world);
    }

    public HealBall(World world, double x, double y, double z) {
        super(EntityType.SNOWBALL, x, y, z, world);
    }


    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (this.world.isClient) {
            return;
        }
        ItemStack itemStack = this.getItem();
        Potion potion = PotionUtil.getPotion(itemStack);
        this.applyLingeringPotion(itemStack, potion);
    }



    private void applyLingeringPotion(ItemStack stack, Potion potion) {
        AreaEffectCloudEntity areaEffectCloudEntity = new AreaEffectCloudEntity(this.world, this.getX(), this.getY(), this.getZ());
        Entity entity = this.getOwner();
        if (entity instanceof LivingEntity) {
            areaEffectCloudEntity.setOwner((LivingEntity)entity);
        }
        areaEffectCloudEntity.setRadius(3.0f);
        areaEffectCloudEntity.setRadiusOnUse(-0.5f);
        areaEffectCloudEntity.setWaitTime(5);
        areaEffectCloudEntity.setPotion(Potions.HEALING);
        areaEffectCloudEntity.setRadiusGrowth(-areaEffectCloudEntity.getRadius() / (float)areaEffectCloudEntity.getDuration());
        for (StatusEffectInstance statusEffectInstance : PotionUtil.getCustomPotionEffects(stack)) {
            areaEffectCloudEntity.addEffect(new StatusEffectInstance(statusEffectInstance));
        }
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound != null && nbtCompound.contains("CustomPotionColor", 99)) {
            areaEffectCloudEntity.setColor(nbtCompound.getInt("CustomPotionColor"));
        }
        this.world.spawnEntity(areaEffectCloudEntity);
    }



    @Override
    public void tick() {
        super.tick();
        if (this.world.isClient && !this.onGround) {
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    this.world.addParticle(ParticleTypes.HEART, this.getX() + 0.5d, this.getY() + 1, this.getZ() + 0.5d,
                            Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
                }
            }
        }
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ICE_WAND;
    }

}
