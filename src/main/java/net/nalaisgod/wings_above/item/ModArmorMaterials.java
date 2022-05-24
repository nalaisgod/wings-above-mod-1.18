package net.nalaisgod.wings_above.item;


import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    WINGED_BOOTS("winged_boots", 30, new int[]{3, 3, 3, 3}, 4,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOPAZ)),
    SPRING_BOOTS("spring_boots", 30, new int[]{3, 3, 3, 3}, 14,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOPAZ)),
    GRAVITY_LEGS("gravity_legs", 30, new int[]{7, 7, 7, 7}, 24,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOPAZ)),
    WINGS("wings", 30, new int[]{1, 1, 1, 1}, 34,
    SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f, 0.0f,
            () -> Ingredient.ofItems(ModItems.TOPAZ));

    private static final int[] BASE_DURABILITY;
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Lazy<Ingredient> repairIngredientSupplier;

    private ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts,
                              int enchantability, SoundEvent equipSound, float toughness,
                              float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new Lazy<Ingredient>(repairIngredientSupplier);
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    static {
        BASE_DURABILITY = new int[]{13, 15, 16, 11};
    }
}
