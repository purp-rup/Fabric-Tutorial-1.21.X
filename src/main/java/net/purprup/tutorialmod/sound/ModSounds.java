package net.purprup.tutorialmod.sound;

import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
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

    public static final SoundEvent ARIA_OF_THE_SOUL = registerSound("aria_of_the_soul");
    public static final RegistryKey<JukeboxSong> ARIA_OF_THE_SOUL_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "aria_of_the_soul"));

    public static final SoundEvent BLUES_IN_VELVET_ROOM = registerSound("blues_in_velvet_room");
    public static final RegistryKey<JukeboxSong> BLUES_IN_VELVET_ROOM_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "blues_in_velvet_room"));

    public static final SoundEvent LIFE_WILL_CHANGE = registerSound("life_will_change");
    public static final RegistryKey<JukeboxSong> LIFE_WILL_CHANGE_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "life_will_change"));

    public static final SoundEvent NO_MORE_WHAT_IFS = registerSound("no_more_what_ifs");
    public static final RegistryKey<JukeboxSong> NO_MORE_WHAT_IFS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "no_more_what_ifs"));

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
