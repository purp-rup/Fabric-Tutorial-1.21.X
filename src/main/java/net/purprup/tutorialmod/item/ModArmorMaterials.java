package net.purprup.tutorialmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;

import java.util.Map;

public class ModArmorMaterials
{
    public static final int BASE_DURABILITY = 15;
    public static final RegistryKey<EquipmentAsset> RUBY_ARMOR_MATERIAL_KEY = RegistryKey.of(
            EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(TutorialMod.MOD_ID, "ruby"));
    // Cannot figure out how to set ruby for repair item
    private static final TagKey<Item> REPAIRS_RUBY_ARMOR = null;

    public static final ArmorMaterial RUBY = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_RUBY_ARMOR,
            RUBY_ARMOR_MATERIAL_KEY
    );

    // Static Initialization
    public static void registerModArmorMaterials()
    {
        TutorialMod.LOGGER.info("Registering Mod Armor Materials for " + TutorialMod.MOD_ID);
    }
}
