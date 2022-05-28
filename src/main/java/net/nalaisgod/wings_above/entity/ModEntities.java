package net.nalaisgod.wings_above.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.entity.mob.Sand_Elemental;
import net.nalaisgod.wings_above.entity.projectile.Wind_Gust;
import software.bernie.example.entity.*;
import software.bernie.example.registry.EntityRegistryBuilder;
import software.bernie.geckolib3.GeckoLib;

public class ModEntities {
    public static final EntityType<Sand_Elemental> SAND_ELEMENTAL = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(WingsAboveMod.MOD_ID, "raccoon"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Sand_Elemental::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 1.3f)).build());



    public static EntityType<Wind_Gust> WIND_GUST = buildEntity(Wind_Gust::new, Wind_Gust.class, 1F,
            1F, SpawnGroup.MISC);

    public static <T extends Entity> EntityType<T> buildEntity(EntityType.EntityFactory<T> entity, Class<T> entityClass,
                                                               float width, float height, SpawnGroup group) {
            String name = entityClass.getSimpleName().toLowerCase();
            return EntityRegistryBuilder.<T>createBuilder(new Identifier(WingsAboveMod.MOD_ID, name)).entity(entity)
                    .category(group).dimensions(EntityDimensions.changing(width, height)).build();
    }
}
