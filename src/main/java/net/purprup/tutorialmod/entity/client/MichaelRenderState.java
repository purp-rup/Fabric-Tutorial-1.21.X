package net.purprup.tutorialmod.entity.client;

import net.purprup.tutorialmod.entity.custom.MichaelVariant;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;

public class MichaelRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();
    public MichaelVariant variant;
}
