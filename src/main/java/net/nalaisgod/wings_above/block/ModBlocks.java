package net.nalaisgod.wings_above.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.nalaisgod.wings_above.WingsAboveMod;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModBlocks {

    public static final Block CLOUD_BLOCK = registerBlock("cloud_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block CLOUD_BRICKS = registerBlock("cloud_bricks",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICKS = registerBlock("sky_bricks",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICK_SLAB = registerBlock("sky_brick_slab",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICK_STAIRS = registerBlock("sky_brick_stairs",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICK_DOOR = registerBlock("sky_brick_stairs_door",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICK_TRAPDOOR = registerBlock("sky_brick_trapdoor",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block SKY_BRICK_CHEST = registerBlock("sky_brick_chest",
            new Block(FabricBlockSettings.of(Material.METAL).strength(0.1f, 10f).requiresTool().breakInstantly()),
            ItemGroup.MISC);

    public static final Block TOPAZ_ORE = registerBlock("topaz_ore",
            new OreBlock(FabricBlockSettings.of(Material.STONE).strength(4.5f, 8f).requiresTool(),
                    UniformIntProvider.create(3, 7)), ItemGroup.MISC);





    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(WingsAboveMod.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group, String tooltipKey) {
        registerBlockItem(name, block, group, tooltipKey);
        return Registry.register(Registry.BLOCK, new Identifier(WingsAboveMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group, String tooltipKey) {
        return Registry.register(Registry.ITEM, new Identifier(WingsAboveMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)) {
                    @Override
                    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                        tooltip.add(new TranslatableText(tooltipKey));
                    }
                });
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(WingsAboveMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        return Registry.register(Registry.ITEM, new Identifier(WingsAboveMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        WingsAboveMod.LOGGER.info("registering ModBlocks for " + WingsAboveMod.MOD_ID);
    }

}