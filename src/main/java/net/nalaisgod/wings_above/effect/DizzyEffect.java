package net.nalaisgod.wings_above.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.Random;
import java.util.random.RandomGenerator;

public class DizzyEffect extends StatusEffect {
    public DizzyEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity pLivingEntity, int pAmplifier) {
        int chance = pLivingEntity.getRandom().nextInt(3);

        if (!pLivingEntity.world.isClient()) {
            double x = pLivingEntity.getX();
            double y = pLivingEntity.getY();
            double z = pLivingEntity.getZ();

            pLivingEntity.teleport(x + chance, y + chance, z + chance);
            pLivingEntity.setVelocity(0 + chance, 0 + chance, 0 + chance);
        }

        super.applyUpdateEffect(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}