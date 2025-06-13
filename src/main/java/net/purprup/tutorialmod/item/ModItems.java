package net.purprup.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.entity.ModEntities;
import net.purprup.tutorialmod.item.custom.ChiselItem;
import net.purprup.tutorialmod.sound.ModSounds;

import java.util.function.Function;

public class ModItems
{
    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item RAW_RUBY = registerItem("raw_ruby", Item::new, new Item.Settings());
    public static final Item CHISEL = registerItem("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));

    public static final Item MICHAEL_SPAWN_EGG = registerItem("michael_spawn_egg",
            setting -> new Item(setting.maxCount(1)), new Item.Settings());

//    public static final Item RUBY_HELMET = Items.register(
//            "ruby_helmet",
//            settings -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.HELMET, settings),
//            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
//    );
//    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
//            settings -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.CHESTPLATE, settings),
//            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
//    );
//
//    public static final Item RUBY_LEGGINGS = registerItem(
//            "ruby_leggings",
//            settings -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.LEGGINGS, settings),
//            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
//    );
//
//    public static final Item RUBY_BOOTS = registerItem(
//            "ruby_boots",
//            settings -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.BOOTS, settings),
//            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
//    );

    // TO MAKE CUSTOM ARMOR:
    // - Goto ModArmorMaterials, create material
    // - Come to ModItems, register them as below
    // - Goto datagen/ModModelProvider and generateItemModels()

    public static final Item RUBY_HELMET = Items.register("ruby_helmet", new Item.Settings().armor(ModArmorMaterials.RUBY, EquipmentType.HELMET));
    public static final Item RUBY_CHESTPLATE = Items.register("ruby_chestplate", new Item.Settings().armor(ModArmorMaterials.RUBY, EquipmentType.CHESTPLATE));
    public static final Item RUBY_LEGGINGS = Items.register("ruby_leggings", new Item.Settings().armor(ModArmorMaterials.RUBY, EquipmentType.LEGGINGS));
    public static final Item RUBY_BOOTS = Items.register("ruby_boots", new Item.Settings().armor(ModArmorMaterials.RUBY, EquipmentType.BOOTS));

    // TO MAKE CUSTOM DISC:
    // - Goto ModSounds, add custom sound event
    // - Goto ModItems (here), register Item
    // - Goto ModModelProvider, create datagen for disc models
    // - Add to creative mode tab
    // - Goto en_us.json, add translation
    // - Add .ogg file to sounds folder
    // - Add textures
    // - Goto sounds.json, add disc
    // - Goto data/jukebox_song folder, add .json for song
    // - Run datagen

    public static final Item ARIA_OF_THE_SOUL_MUSIC_DISC = registerItem("aria_of_the_soul_music_disc", Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.ARIA_OF_THE_SOUL_KEY).maxCount(1));

    public static final Item BLUES_IN_VELVET_ROOM_MUSIC_DISC = registerItem("blues_in_velvet_room_music_disc", Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.BLUES_IN_VELVET_ROOM_KEY).maxCount(1));

    public static final Item LIFE_WILL_CHANGE_MUSIC_DISC = registerItem("life_will_change_music_disc", Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.LIFE_WILL_CHANGE_KEY).maxCount(1));

    public static final Item NO_MORE_WHAT_IFS_MUSIC_DISC = registerItem("no_more_what_ifs_music_disc", Item::new,
            new Item.Settings().jukeboxPlayable(ModSounds.NO_MORE_WHAT_IFS_KEY).maxCount(1));

    // Add new items here!
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    public static Item registerItem(String path, Function<Item.Settings, Item> factory, Item.Settings settings)
    {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, path));
        return Items.register(registryKey, factory, settings);
    }

    // Static Initialization
    public static void registerModItems()
    {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
