package net.purprup.tutorialmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.purprup.tutorialmod.TutorialMod;

public class MessageEntity extends PathAwareEntity
{
    private static final Identifier MESSAGE_ID = Identifier.of(TutorialMod.MOD_ID, "message");
    public static final RegistryKey<EntityType<?>> MESSAGE_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, MESSAGE_ID);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public MessageEntity(EntityType<? extends PathAwareEntity> entityType, World world)
    {
        super(entityType, world);
    }

    private void setupAnimationStates()
    {
        if(this.idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = 10;
            this.idleAnimationState.start(this.age);
        }
        else
        {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.getWorld().isClient())
        {
            this.setupAnimationStates();
        }
    }
}
