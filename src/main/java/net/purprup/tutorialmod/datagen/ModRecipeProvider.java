package net.purprup.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.purprup.tutorialmod.block.ModBlocks;
import net.purprup.tutorialmod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider
{
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture)
    {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter)
    {
        return new RecipeGenerator(wrapperLookup, recipeExporter)
        {
            @Override
            public void generate()
            {
                List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY, ModBlocks.RUBY_ORE, ModBlocks.RUBY_DEEPSLATE_ORE);

                offerSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 2477, 200, "ruby");
                offerBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 2477, 100, "ruby");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);

                createShaped(RecipeCategory.MISC, ModBlocks.RAW_RUBY_BLOCK)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .input('R', ModItems.RAW_RUBY)
                        .criterion(hasItem(ModItems.RAW_RUBY), conditionsFromItem(ModItems.RAW_RUBY))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModBlocks.RAW_RUBY_BLOCK, 9)
                        .input(ModBlocks.RAW_RUBY_BLOCK)
                        .criterion(hasItem(ModBlocks.RAW_RUBY_BLOCK), conditionsFromItem(ModBlocks.RAW_RUBY_BLOCK))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName()
    {
        return "Purprup Mod Recipes";
    }
}
