package net.nalaisgod.wings_above.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.item.custom.PenatratorItem;


public class ModItems {

    public static final Item CHARGE_ORB_LEVEL_1 = registerItem("charge_orb_level_1",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item CHARGE_ORB_LEVEL_2 = registerItem("charge_orb_level_2",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item CHARGE_ORB_LEVEL_3 = registerItem("charge_orb_level_3",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item CHARGE_ORB_LEVEL_4 = registerItem("charge_orb_level_4",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item GRIFFIN_FEATHERS = registerItem("griffin_feathers",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item DOUBLE_JUMP_BOOTS = registerItem("double_jump_boots",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item WINGED_CAP = registerItem("winged_cap",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item GRAVITY_SHIFTER = registerItem("gravity_shifter",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item BROKEN_WINGS = registerItem("broken_wings",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item FIRE_WINGS = registerItem("fire_wings",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item ICE_WINGS = registerItem("ice_wings",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item ANGLE_WINGS = registerItem("angle_wings",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item JETPACK = registerItem("jetpack",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item ICE_WAND = registerItem("ice_wand",
            new Item(new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));

    public static final Item PENATRATOR = registerItem("penatrator",
            new PenatratorItem(ToolMaterials.NETHERITE, 3, -3.2F,
                    new FabricItemSettings().group(ItemGroup.MISC).rarity(Rarity.EPIC)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(WingsAboveMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        WingsAboveMod.LOGGER.info("Registering Mod Items for " + WingsAboveMod.MOD_ID);
    }
}

