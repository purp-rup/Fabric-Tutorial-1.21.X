package net.purprup.tutorialmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.entity.custom.MessageEntity;
import net.purprup.tutorialmod.entity.custom.MichaelEntity;

public class ModEntities
{
    public static final EntityType<MichaelEntity> MICHAEL = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TutorialMod.MOD_ID, "michael"),
            EntityType.Builder.create(MichaelEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1.5f).build(MichaelEntity.MICHAEL_KEY));

    public static final EntityType<MessageEntity> MESSAGE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(TutorialMod.MOD_ID, "message"),
            EntityType.Builder.create(MessageEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f, 1f).build(MessageEntity.MESSAGE_KEY)
    );

    public static void registerModEntities()
    {
        TutorialMod.LOGGER.info("Registering Mod Entities for " + TutorialMod.MOD_ID);
    }
}
