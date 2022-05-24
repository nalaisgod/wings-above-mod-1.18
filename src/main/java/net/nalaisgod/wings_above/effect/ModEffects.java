package net.nalaisgod.wings_above.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nalaisgod.wings_above.WingsAboveMod;

public class ModEffects {
    public static StatusEffect FREEZE;
    public static StatusEffect DIZZY;
    public static StatusEffect FLIGHT;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registry.STATUS_EFFECT,
                new Identifier(WingsAboveMod.MOD_ID, name),
                new FreezeEffect(StatusEffectCategory.HARMFUL, 3124687));
    }
    public static StatusEffect registerStatusEffect1(String name) {
        return Registry.register(Registry.STATUS_EFFECT,
                new Identifier(WingsAboveMod.MOD_ID, name),
                new DizzyEffect(StatusEffectCategory.HARMFUL, 3124687));
    }
    public static StatusEffect registerStatusEffect2(String name) {
        return Registry.register(Registry.STATUS_EFFECT,
                new Identifier(WingsAboveMod.MOD_ID, name),
                new FlightEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        FREEZE = registerStatusEffect("freeze");
        DIZZY = registerStatusEffect1("dizzy");
        FLIGHT = registerStatusEffect2("flight");

    }

}