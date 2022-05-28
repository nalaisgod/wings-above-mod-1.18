package net.nalaisgod.wings_above.entity.client;

import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.nalaisgod.wings_above.WingsAboveMod;
import net.nalaisgod.wings_above.entity.mob.Sand_Elemental;
import net.nalaisgod.wings_above.entity.projectile.Wind_Gust;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoProjectilesRenderer;

public class Wind_Gust_Renderer extends GeoProjectilesRenderer<Wind_Gust> {

    public Wind_Gust_Renderer(EntityRendererFactory.Context renderManagerIn) {
        super(renderManagerIn, new Wind_Gust_Model());
    }

    protected int getBlockLight(Wind_Gust entityIn, BlockPos partialTicks) {
        return 15;
    }

    @Override
    public RenderLayer getRenderType(Wind_Gust animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                     Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
    }
}
