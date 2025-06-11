package net.purprup.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.item.custom.ChiselItem;

import java.util.function.Function;

public class ModItems
{
    public static final Item RUBY = registerItem("ruby", Item::new, new Item.Settings());
    public static final Item RAW_RUBY = registerItem("raw_ruby", Item::new, new Item.Settings());
    public static final Item CHISEL = registerItem("chisel", ChiselItem::new, new Item.Settings().maxDamage(32));

    public static final Item RUBY_HELMET = registerItem(
            "ruby_helmet",
            settings -> new ArmorItem(ModArmorMaterials.INSTANCE, EquipmentType.HELMET, settings),
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );
    public static final Item RUBY_CHESTPLATE = registerItem("ruby_chestplate",
            settings -> new ArmorItem(ModArmorMaterials.INSTANCE, EquipmentType.CHESTPLATE, settings),
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

    public static final Item RUBY_LEGGINGS = registerItem(
            "ruby_leggings",
            settings -> new ArmorItem(ModArmorMaterials.INSTANCE, EquipmentType.LEGGINGS, settings),
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

    public static final Item RUBY_BOOTS = registerItem(
            "ruby_boots",
            settings -> new ArmorItem(ModArmorMaterials.INSTANCE, EquipmentType.BOOTS, settings),
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(ModArmorMaterials.BASE_DURABILITY))
    );

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
