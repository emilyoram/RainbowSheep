package com.gmail.sheepingtoninc.rainbowsheep.data;

import com.gmail.sheepingtoninc.rainbowsheep.RainbowSheep;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.crafting.DifferenceIngredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public static final TagKey<Item> FLAG_WOOL = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "flag_wool"));

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        buildFlagWoolRecipe(output, RainbowSheep.RAINBOW_WOOL_ITEM.get(), RainbowSheep.RAINBOW_DYE_ITEM.get(), "rainbow");
        buildFlagWoolRecipe(output, RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), RainbowSheep.TRANSGENDER_DYE_ITEM.get(), "transgender");

        buildCarpetRecipe(output, RainbowSheep.RAINBOW_CARPET_ITEM.get(), RainbowSheep.RAINBOW_WOOL_ITEM.get(), "rainbow");
        buildCarpetRecipe(output, RainbowSheep.TRANSGENDER_CARPET_ITEM.get(), RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), "transgender");

        buildVanillaWoolRecipe(output, Items.WHITE_WOOL, Items.WHITE_DYE, "white");
        buildVanillaWoolRecipe(output, Items.ORANGE_WOOL, Items.ORANGE_DYE, "orange");
        buildVanillaWoolRecipe(output, Items.MAGENTA_WOOL, Items.MAGENTA_DYE, "magenta");
        buildVanillaWoolRecipe(output, Items.LIME_WOOL, Items.LIME_DYE, "lime");
        buildVanillaWoolRecipe(output, Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaWoolRecipe(output, Items.YELLOW_WOOL, Items.YELLOW_DYE, "yellow");
        buildVanillaWoolRecipe(output, Items.PINK_WOOL, Items.PINK_DYE, "pink");
        buildVanillaWoolRecipe(output, Items.GRAY_WOOL, Items.GRAY_DYE, "gray");
        buildVanillaWoolRecipe(output, Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaWoolRecipe(output, Items.CYAN_WOOL, Items.CYAN_DYE, "cyan");
        buildVanillaWoolRecipe(output, Items.PURPLE_WOOL, Items.PURPLE_DYE, "purple");
        buildVanillaWoolRecipe(output, Items.BLUE_WOOL, Items.BLUE_DYE, "blue");
        buildVanillaWoolRecipe(output, Items.BROWN_WOOL, Items.BROWN_DYE, "brown");
        buildVanillaWoolRecipe(output, Items.GREEN_WOOL, Items.GREEN_DYE, "green");
        buildVanillaWoolRecipe(output, Items.RED_WOOL, Items.RED_DYE, "red");
        buildVanillaWoolRecipe(output, Items.BLACK_WOOL, Items.BLACK_DYE, "black");
    }

    // Builds a recipe that means you can dye any wool block (except itself) into the wool
    protected void buildFlagWoolRecipe(RecipeOutput output, ItemLike wool, ItemLike dye, String name) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, wool)
                .requires(DifferenceIngredient.of(Ingredient.of(ItemTags.WOOL), Ingredient.of(wool)))
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("flag_wool")
                .save(output);
    }

    // Builds a recipe to dye any flag wool back into vanilla wool
    protected void buildVanillaWoolRecipe(RecipeOutput output, ItemLike wool, ItemLike dye, String name) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, wool)
                .requires(FLAG_WOOL)
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("wool")
                .save(output);
    }

    protected void buildCarpetRecipe(RecipeOutput output, ItemLike carpet, ItemLike wool, String name) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, carpet, 3)
                .pattern("XX")
                .define('X', wool)
                .unlockedBy("has_" + name + "_wool", has(wool))
                .group("carpet")
                .save(output);
    }
}
