package net.purprup.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.TutorialMod;
import net.purprup.tutorialmod.block.custom.PinkGarnetLampBlock;

import java.util.function.Function;

public class ModBlocks
{
    public static final Block RUBY_BLOCK = registerBlockItem(
            "ruby_block",
            Block::new,
            AbstractBlock.Settings.create().strength(1f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );

    public static final Block RAW_RUBY_BLOCK = registerBlockItem(
            "raw_ruby_block",
            Block::new,
            AbstractBlock.Settings.create().strength(1f).requiresTool(),
            true
    );

    public static final Block RUBY_ORE = registerBlockItem(
            "ruby_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(1f).requiresTool(),
            true
    );

    public static final Block RUBY_DEEPSLATE_ORE = registerBlockItem(
            "ruby_deepslate_ore",
            Block::new,
            AbstractBlock.Settings.create().strength(1.5f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
            true
    );

    public static final Block PINK_GARNET_LAMP = registerBlockItem(
            "pink_garnet_lamp",
            PinkGarnetLampBlock::new,
            AbstractBlock.Settings.create().strength(1f).luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0),
            true
    );

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(RUBY_BLOCK);
        entries.add(RAW_RUBY_BLOCK);
    }

    private static Block registerBlockItem(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem)
    {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.

            Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                    new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name)))));
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name)
    {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name)
    {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
    }

    // Static Initialization
    public static void registerModBlocks()
    {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToIngredientItemGroup);
    }
}
