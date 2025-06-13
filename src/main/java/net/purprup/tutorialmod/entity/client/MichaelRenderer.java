package net.purprup.tutorialmod.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.entity.custom.MichaelEntity;
import net.purprup.tutorialmod.entity.custom.MichaelVariant;

import java.util.Map;

public class MichaelRenderer extends MobEntityRenderer<MichaelEntity, MichaelRenderState, MichaelModel>
{
    private static final Map<MichaelVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(MichaelVariant.class), map -> {
               map.put(MichaelVariant.DEFAULT,
                       Identifier.of(TutorialMod.MOD_ID, "textures/entity/michael/michael_mob.png"));
               map.put(MichaelVariant.ORCHID,
                       Identifier.of(TutorialMod.MOD_ID, "textures/entity/michael/michael_mob2.png"));
            });

    public MichaelRenderer(EntityRendererFactory.Context context) {
        super(context, new MichaelModel(context.getPart(MichaelModel.MICHAEL)), 1f);
    }

    @Override
    public Identifier getTexture(MichaelRenderState state) {
        return LOCATION_BY_VARIANT.get(state.variant);
    }

    @Override
    public void render(MichaelRenderState state, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(state.baby) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(2f, 2f, 2f);
        }

        super.render(state, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public MichaelRenderState createRenderState() {
        return new MichaelRenderState();
    }

    @Override
    public void updateRenderState(MichaelEntity livingEntity, MichaelRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
        livingEntityRenderState.variant = livingEntity.getVariant();
    }
}
