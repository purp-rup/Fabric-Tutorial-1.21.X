package net.purprup.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;

import java.util.function.Function;

public class ModItems
{
    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item RAW_RUBY = registerItem("raw_ruby", Item::new, new Item.Settings());

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
