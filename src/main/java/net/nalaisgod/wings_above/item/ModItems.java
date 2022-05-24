package net.nalaisgod.wings_above.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.item.custom.*;


public class ModItems {

    public static final Item CHARGE_ORB_LEVEL_1 = registerItem("charge_orb_level_1",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.COMMON)));

    public static final Item CHARGE_ORB_LEVEL_2 = registerItem("charge_orb_level_2",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item CHARGE_ORB_LEVEL_3 = registerItem("charge_orb_level_3",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.RARE)));

    public static final Item CHARGE_ORB_LEVEL_4 = registerItem("charge_orb_level_4",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.EPIC)));

    public static final Item TOPAZ = registerItem("topaz",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.COMMON)));

    public static final Item SKY_BRICK = registerItem("sky_brick",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.COMMON)));

    public static final Item GRIFFIN_FEATHERS = registerItem("griffin_feathers",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item DOUBLE_JUMP_BOOTS = registerItem("double_jump_boots",
            new ModDoublejumpbootsArmourItem(ModArmorMaterials.SPRING_BOOTS, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item WINGED_CAP = registerItem("winged_cap",
            new ModFallingCapItemArmour(ModArmorMaterials.WINGED_BOOTS, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item GRAVITY_SHIFTER = registerItem("gravity_shifter",
            new ModGravityShifterItemArmour(ModArmorMaterials.GRAVITY_LEGS, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item BROKEN_WINGS = registerItem("broken_wings",
            new ModBasicWings(ModArmorMaterials.WINGS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));

    public static final Item FIRE_WINGS = registerItem("fire_wings",
            new ModOtherOtherBasicWings(ModArmorMaterials.WINGS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.RARE)));

    public static final Item ICE_WINGS = registerItem("ice_wings",
            new ArmorItem(ModArmorMaterials.WINGS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.RARE)));

    public static final Item ANGEL_WINGS = registerItem("angel_wings",
            new ModComplexWings(ModArmorMaterials.WINGS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.EPIC)));

    public static final Item JETPACK = registerItem("jetpack",
            new ModOtherBasicWings(ModArmorMaterials.WINGS, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.RARE)));

    public static final Item ICE_WAND = registerItem("ice_wand",
            new Item(new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.RARE)));

    public static final Item PENATRATOR = registerItem("penatrator",
            new PenatratorItem(ToolMaterials.NETHERITE, 3, -3.2F,
                    new FabricItemSettings().group(ModItemGroup.WINGS_ABOVE).rarity(Rarity.UNCOMMON)));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(WingsAboveMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WingsAboveMod.LOGGER.info("Registering Mod Items for " + WingsAboveMod.MOD_ID);
    }
}

