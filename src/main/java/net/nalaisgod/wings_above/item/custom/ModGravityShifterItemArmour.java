package net.nalaisgod.wings_above.item.custom;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.nalaisgod.wings_above.item.ModArmorMaterials;
import net.nalaisgod.wings_above.item.ModItems;
import org.lwjgl.glfw.GLFW;


import java.util.*;

public class ModGravityShifterItemArmour extends ArmorItem {

    private static final Map<ArmorMaterial, StatusEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterials.GRAVITY_LEGS,
                            new StatusEffectInstance(StatusEffects.RESISTANCE, 400, 1)).build();


    public ModGravityShifterItemArmour(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity)entity;

                if(player.getInventory().getArmorStack(1).isOf(ModItems.GRAVITY_SHIFTER)) {
                    evaluateArmorEffects(player, stack);
                } else {
                    player.setNoGravity(false);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player, ItemStack stack) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            StatusEffectInstance mapStatusEffect = entry.getValue();
                if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_P)) {
                    player.setNoGravity(true);

                }
        }
    }






}