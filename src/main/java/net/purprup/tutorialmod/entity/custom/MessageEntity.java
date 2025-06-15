package net.purprup.tutorialmod.entity.custom;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.TutorialModClient;
import net.purprup.tutorialmod.gui.MessageScreen;

import javax.swing.*;

public class MessageEntity extends PathAwareEntity
{
    private static final Identifier MESSAGE_ID = Identifier.of(TutorialMod.MOD_ID, "message");
    public static final RegistryKey<EntityType<?>> MESSAGE_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, MESSAGE_ID);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private Box defaultBoundingBox;

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

    private double getDistance(Vec3d pos1, Vec3d pos2)
    {
        double x = pos1.x - pos2.x;
        double z = pos1.z - pos2.z;

        return Math.sqrt(x * x + z * z);
    }

    @Override
    public void onDamaged(DamageSource damageSource) {
        Entity player = damageSource.getAttacker();

        ClientCommandRegistrationCallback.EVENT.register(((commandDispatcher, commandRegistryAccess) ->
                commandDispatcher.register(ClientCommandManager.literal("message-screen")
                        .executes(commandContext -> {
                            MinecraftClient client = commandContext.getSource().getClient();
                            client.send(() -> client.setScreen(new MessageScreen(Text.of("Message Screen"))));
                            return 1;
                        })
                )
        ));
    }

    @Override
    public void tick()
    {
        super.tick();

        this.getWorld().addParticleClient(ParticleTypes.FIREFLY,
                this.getParticleX(0.3),
                this.getRandomBodyY(),
                this.getParticleZ(0.3),
                0.0, 2,
                0.0);



        if(this.getWorld().isClient())
        {
            this.setupAnimationStates();
        }
    }
}
