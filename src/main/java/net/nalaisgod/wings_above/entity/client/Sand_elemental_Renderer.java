package net.nalaisgod.wings_above.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.entity.mob.Sand_Elemental;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class Sand_elemental_Renderer extends GeoEntityRenderer<Sand_Elemental> {
    public Sand_elemental_Renderer(EntityRendererFactory.Context ctx) {
        super(ctx, new Sand_elemental_Model());
        this.shadowRadius = 0.3f;
    }

    @Override
    public Identifier getTextureLocation(Sand_Elemental entity) {
        return new Identifier(WingsAboveMod.MOD_ID, "textures/entity/sand_elemental/sand_elemental.png");
    }

}
