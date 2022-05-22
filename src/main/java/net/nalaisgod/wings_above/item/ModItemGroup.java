package net.nalaisgod.wings_above.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.nalaisgod.wings_above.WingsAboveMod;

import java.lang.reflect.WildcardType;

public class ModItemGroup {
    public static final ItemGroup WINGS_ABOVE = FabricItemGroupBuilder.build(new Identifier(WingsAboveMod.MOD_ID, "wings_above"),
            () -> new ItemStack(ModItems.TOPAZ));
}