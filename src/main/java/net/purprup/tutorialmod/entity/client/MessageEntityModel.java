package net.purprup.tutorialmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MessageEntityModel extends EntityModel<MessageRenderState>
{
    public static final EntityModelLayer MESSAGE = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "message"), "main");

    private final ModelPart message;
    private final ModelPart lines;
    private final ModelPart text;

    public MessageEntityModel(ModelPart root)
    {
        super(root);
        this.message = root.getChild("message");
        this.lines = this.message.getChild("lines");
        this.text = this.message.getChild("text");
    }

    public static TexturedModelData getTexturedModelData()
    {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData message = modelPartData.addChild("message", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 0F, 0F));

        ModelPartData lines = message.addChild("lines", ModelPartBuilder.create().uv(0, 31).cuboid(-1.0F, 22F, -15.0F, 2.0F, 1.0F, 30.0F, new Dilation(0.0F))
                .uv(68, 0).cuboid(4.0F, 22F, -9.0F, 2.0F, 1.0F, 18.0F, new Dilation(0.0F))
                .uv(56, 62).cuboid(-6.0F, 22F, -12.0F, 2.0F, 1.0F, 24.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));

        ModelPartData text = message.addChild("text", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, 21.0F, -15.0F, 4.0F, 1.0F, 30.0F, new Dilation(0.0F))
                .uv(64, 31).cuboid(3.0F, 21.0F, -9.0F, 4.0F, 1.0F, 18.0F, new Dilation(0.0F))
                .uv(0, 62).cuboid(-7.0F, 21.0F, -12.0F, 4.0F, 1.0F, 24.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(MessageRenderState state)
    {
        super.setAngles(state);

        this.animate(state.idleAnimationState, MessageAnimations.MESSAGE_IDLE, state.age, 1f);
    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        message.render(matrices, vertexConsumer, light, overlay);
    }
}