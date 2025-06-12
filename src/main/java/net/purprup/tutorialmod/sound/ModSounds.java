package net.purprup.tutorialmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;

public class ModSounds
{
    private ModSounds()
    {
        // avoids accidental instantiation
    }

    public static final SoundEvent CHISEL_USE = registerSound("chisel_use");

    // actual registration of all the custom SoundEvents
    private static SoundEvent registerSound(String id) {
        Identifier identifier = Identifier.of(TutorialMod.MOD_ID, id);
        return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
    }

    // Static Initialization
    public static void registerSounds()
    {
        TutorialMod.LOGGER.info("Registering sounds for " + TutorialMod.MOD_ID);
    }
}
