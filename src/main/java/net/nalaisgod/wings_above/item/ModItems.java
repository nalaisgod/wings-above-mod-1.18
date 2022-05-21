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

    public static final Item TEST = registerItem("test",
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

