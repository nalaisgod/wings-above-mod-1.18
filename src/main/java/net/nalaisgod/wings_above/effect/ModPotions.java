package net.nalaisgod.wings_above.effect;


import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.item.ModItems;
import net.nalaisgod.wings_above.mixin.BrewingRecipeRegistryMixin;

public class ModPotions {
    public static Potion FREEZE_POTION;

    public static Potion registerPotion(String name) {
        return Registry.register(Registry.POTION, new Identifier(WingsAboveMod.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.FREEZE, 200, 0)));
    }

    public static void registerPotions() {
        FREEZE_POTION = registerPotion("freeze_potion");


        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.ICE_WAND,
                ModPotions.FREEZE_POTION);
    }
}
