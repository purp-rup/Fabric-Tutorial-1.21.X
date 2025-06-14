package net.purprup.tutorialmod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.entity.custom.MessageEntity;

public class MessageRenderer extends MobEntityRenderer<MessageEntity, MessageRenderState, MessageEntityModel>
{


    public MessageRenderer(EntityRendererFactory.Context context) {
        super(context, new MessageEntityModel(context.getPart(MessageEntityModel.MESSAGE)), 0f);
    }

    @Override
    public void render(MessageRenderState livingEntityRenderState, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i)
    {
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i);
    }

    @Override
    public Identifier getTexture(MessageRenderState state) {
        return Identifier.of(TutorialMod.MOD_ID, "textures/entity/message/message.png");
    }

    @Override
    public MessageRenderState createRenderState() {
        return new MessageRenderState();
    }

    @Override
    public void updateRenderState(MessageEntity livingEntity, MessageRenderState livingEntityRenderState, float f) {
        super.updateRenderState(livingEntity, livingEntityRenderState, f);
        livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
    }
}
