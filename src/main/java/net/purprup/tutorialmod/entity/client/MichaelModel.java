package net.purprup.tutorialmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.purprup.tutorialmod.TutorialMod;

// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MichaelModel extends EntityModel<MichaelRenderState>
{
    public static final EntityModelLayer MICHAEL = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "michael"), "main");

    private final ModelPart root;
    private final ModelPart Michael;
    private final ModelPart head;

    // Might not need to initialize all these
    public MichaelModel(ModelPart root) {
        super(root);
        this.root = root.getChild("root");
        this.Michael = this.root.getChild("Michael");
        this.head = this.Michael.getChild("head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.rotation(0.0F, 24.0F, 0.0F));

        ModelPartData Michael = root.addChild("Michael", ModelPartBuilder.create(), ModelTransform.of(0.0F, -1.0F, -3.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData legs = Michael.addChild("legs", ModelPartBuilder.create().uv(10, 57).cuboid(2.5F, 0.0F, 0.0F, 1.0F, 3.5F, 1.0F, new Dilation(0.0F))
                .uv(38, 58).cuboid(-3.5F, 0.0F, 0.0F, 1.0F, 3.5F, 1.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -7.0F, 1.0F));

        ModelPartData cube_r1 = legs.addChild("cube_r1", ModelPartBuilder.create().uv(56, 51).cuboid(-1.0F, 0.4142F, -1.1716F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F))
                .uv(56, 46).cuboid(-7.0F, 0.4142F, -1.1716F, 2.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 5.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData cube_r2 = legs.addChild("cube_r2", ModelPartBuilder.create().uv(34, 62).cuboid(-0.5F, -0.3787F, -0.2218F, 1.0F, 2.5F, 1.0F, new Dilation(0.0F))
                .uv(54, 61).cuboid(-6.5F, -0.3787F, -0.2218F, 1.0F, 2.5F, 1.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 3.5F, 0.0F, -0.7854F, 0.0F, 0.0F));

        ModelPartData torso = Michael.addChild("torso", ModelPartBuilder.create().uv(0, 32).cuboid(-5.0F, -5.0F, -2.0F, 10.0F, 10.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 57).cuboid(1.0F, -4.0F, 2.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 61).cuboid(0.0F, 0.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(42, 61).cuboid(0.0F, 2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(48, 61).cuboid(-2.0F, 2.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(6, 62).cuboid(-2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(28, 58).cuboid(-5.0F, -4.0F, 2.0F, 4.0F, 3.0F, 1.0F, new Dilation(0.0F)), ModelTransform.rotation(0.0F, -12.0F, 1.0F));

        ModelPartData rightshoulder = Michael.addChild("rightshoulder", ModelPartBuilder.create().uv(28, 50).cuboid(0.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(28, 39).cuboid(5.0F, 7.0F, -2.0F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.rotation(5.0F, -15.0F, 1.0F));

        ModelPartData cube_r3 = rightshoulder.addChild("cube_r3", ModelPartBuilder.create().uv(14, 46).cuboid(0.0F, -2.0F, -1.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 5.0F, -1.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r4 = rightshoulder.addChild("cube_r4", ModelPartBuilder.create().uv(42, 63).cuboid(0.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(46, 37).cuboid(-1.0F, -2.0F, 3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(28, 32).cuboid(-2.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 2.0F, -1.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData righthand = rightshoulder.addChild("righthand", ModelPartBuilder.create().uv(46, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.rotation(7.0F, 14.0F, 0.0F));

        ModelPartData rightpinky = righthand.addChild("rightpinky", ModelPartBuilder.create(), ModelTransform.rotation(2.0F, 1.0F, -2.0F));

        ModelPartData cube_r5 = rightpinky.addChild("cube_r5", ModelPartBuilder.create().uv(28, 62).cuboid(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r6 = rightpinky.addChild("cube_r6", ModelPartBuilder.create().uv(54, 37).cuboid(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData rightindex = righthand.addChild("rightindex", ModelPartBuilder.create(), ModelTransform.rotation(2.0F, 1.0F, 1.0F));

        ModelPartData cube_r7 = rightindex.addChild("cube_r7", ModelPartBuilder.create().uv(62, 32).cuboid(0.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        ModelPartData cube_r8 = rightindex.addChild("cube_r8", ModelPartBuilder.create().uv(58, 56).cuboid(0.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData rightthumb = righthand.addChild("rightthumb", ModelPartBuilder.create().uv(60, 43).cuboid(0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(-2.0F, 1.0F, 2.0F));

        ModelPartData cube_r9 = rightthumb.addChild("cube_r9", ModelPartBuilder.create().uv(0, 63).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData leftshoulder = Michael.addChild("leftshoulder", ModelPartBuilder.create().uv(14, 56).cuboid(-3.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new Dilation(0.0F))
                .uv(0, 46).cuboid(-8.0F, 7.0F, -2.0F, 3.0F, 7.0F, 4.0F, new Dilation(0.0F)), ModelTransform.rotation(-5.0F, -15.0F, 1.0F));

        ModelPartData cube_r10 = leftshoulder.addChild("cube_r10", ModelPartBuilder.create().uv(42, 46).cuboid(-3.0F, -2.0F, -1.0F, 3.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, 5.0F, -1.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube_r11 = leftshoulder.addChild("cube_r11", ModelPartBuilder.create().uv(46, 63).cuboid(-1.0F, -2.0F, 4.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(58, 58).cuboid(-2.0F, -2.0F, 3.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
                .uv(42, 39).cuboid(-3.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 2.0F, -1.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData lefthand = leftshoulder.addChild("lefthand", ModelPartBuilder.create().uv(42, 56).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.rotation(-7.0F, 14.0F, 0.0F));

        ModelPartData leftpinky = lefthand.addChild("leftpinky", ModelPartBuilder.create(), ModelTransform.rotation(-2.0F, 1.0F, -2.0F));

        ModelPartData cube_r12 = leftpinky.addChild("cube_r12", ModelPartBuilder.create().uv(62, 34).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube_r13 = leftpinky.addChild("cube_r13", ModelPartBuilder.create().uv(60, 39).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData leftindex = lefthand.addChild("leftindex", ModelPartBuilder.create(), ModelTransform.rotation(-1.0F, 1.0F, 0.0F));

        ModelPartData cube_r14 = leftindex.addChild("cube_r14", ModelPartBuilder.create().uv(62, 36).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData cube_r15 = leftindex.addChild("cube_r15", ModelPartBuilder.create().uv(60, 41).cuboid(-3.0F, -1.0F, 0.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 1.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData leftthumb = lefthand.addChild("leftthumb", ModelPartBuilder.create().uv(58, 60).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.rotation(2.0F, 1.0F, 2.0F));

        ModelPartData cube_r16 = leftthumb.addChild("cube_r16", ModelPartBuilder.create().uv(38, 63).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData head = Michael.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new Dilation(-7.0F)), ModelTransform.rotation(0.0F, -18.0F, 1.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(MichaelRenderState state)
    {
        super.setAngles(state);
//        this.setHeadAngles(state.relativeHeadYaw, state.pitch);

        this.animateWalking(MichaelAnimations.MICHAEL_WALK, state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2f, 2.5f);
        this.animate(state.idleAnimationState, MichaelAnimations.MICHAEL_IDLE, state.age, 1f);
        this.animate(state.attackAnimationState, MichaelAnimations.MICHAEL_ATTACK, state.age, 1f);
    }

//    private void setHeadAngles(float headYaw, float headPitch)
//    {
//        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
//        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);
//
//        this.head.yaw = headYaw * 0.017453292F;
//        this.head.pitch = headPitch * 0.017453292F;
//    }

    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        root.render(matrices, vertexConsumer, light, overlay);
    }
}
