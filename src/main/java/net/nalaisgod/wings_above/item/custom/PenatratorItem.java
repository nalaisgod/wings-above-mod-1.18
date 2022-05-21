package net.nalaisgod.wings_above.item.custom;


import java.util.UUID;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

import java.util.UUID;
public class PenatratorItem extends SwordItem {
    private final ToolMaterial material;
    private final float attackDamage;
    public final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;
    private static final UUID ATTACK_BONUS_MODIFIER_ID = UUID.fromString("fbd4e4e4-62f7-4108-9be3-eb6781231298");
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER;
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER_1;
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER_2;
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER_3;
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER_4;
    private static final EntityAttributeModifier ATTACK_BONUS_MODIFIER_5;


    public PenatratorItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.material = material;
        this.attackDamage = attackDamage + material.getAttackDamage();
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Tool modifier", this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Tool modifier", attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.MAINHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot);
    }

    @Override
    public ToolMaterial getMaterial() {
        return this.material;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity && !world.isClient) {
            PlayerEntity player = (PlayerEntity) entity;
            if (selected && player.speed >= 0 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER);
            }
             if (selected && player.speed >= 1 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER_1);
            }
             if (selected && player.speed >= 2 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER_2);
            }
             if (selected && player.speed >= 3 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER_3);
            }
             if (selected && player.speed >= 4 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER_4);
            }
             if (selected && player.speed >= 5 && !player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                EntityAttributeInstance entityAttributeInstance = player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
                entityAttributeInstance.addTemporaryModifier(ATTACK_BONUS_MODIFIER_5);
            }



            else if (player.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, ATTACK_BONUS_MODIFIER_ID)) {
                player.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_BONUS_MODIFIER_ID);
            }
        }
    }

    static {
        ATTACK_BONUS_MODIFIER = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_BONUS_MODIFIER_1 = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_BONUS_MODIFIER_2 = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_BONUS_MODIFIER_3 = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_BONUS_MODIFIER_4 = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);
        ATTACK_BONUS_MODIFIER_5 = new EntityAttributeModifier(ATTACK_BONUS_MODIFIER_ID, "Sneaking attack bonus", 2.0D, EntityAttributeModifier.Operation.ADDITION);

    }

}




