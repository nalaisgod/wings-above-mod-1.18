package net.nalaisgod.wings_above.entity.client;

import net.minecraft.util.Identifier;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.entity.mob.Sand_Elemental;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Sand_elemental_Model extends AnimatedGeoModel<Sand_Elemental> {
    @Override
    public Identifier getModelLocation(Sand_Elemental entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "geo/sand_elemental.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Sand_Elemental entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "textures/entity/sand_elemental/sand_elemental.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Sand_Elemental entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "animations/sand_elemental.animation.json");
    }
}
