package net.nalaisgod.wings_above.entity.client;

import net.minecraft.util.Identifier;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.entity.mob.Sand_Elemental;
import net.nalaisgod.wings_above.entity.projectile.Wind_Gust;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class Wind_Gust_Model extends AnimatedGeoModel<Wind_Gust> {
    @Override
    public Identifier getModelLocation(Wind_Gust entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "geo/wind_gust.geo.json");
    }

    @Override
    public Identifier getTextureLocation(Wind_Gust entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "textures/entity/wind_gust/wind_gust.png");
    }

    @Override
    public Identifier getAnimationFileLocation(Wind_Gust entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "animations/wind_gust.animation.json");
    }
}
