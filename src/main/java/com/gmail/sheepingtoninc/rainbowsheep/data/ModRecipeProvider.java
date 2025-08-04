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
    public static final TagKey<Item> FLAG_CARPET = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "flag_carpet"));

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        buildFlagWoolRecipe(output, RainbowSheep.RAINBOW_WOOL_ITEM.get(), RainbowSheep.RAINBOW_DYE_ITEM.get(), "rainbow");
        buildFlagWoolRecipe(output, RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), RainbowSheep.TRANSGENDER_DYE_ITEM.get(), "transgender");
        buildFlagWoolRecipe(output, RainbowSheep.BISEXUAL_WOOL_ITEM.get(), RainbowSheep.BISEXUAL_DYE_ITEM.get(), "bisexual");
        buildFlagWoolRecipe(output, RainbowSheep.LESBIAN_WOOL_ITEM.get(), RainbowSheep.LESBIAN_DYE_ITEM.get(), "lesbian");
        buildFlagWoolRecipe(output, RainbowSheep.ASEXUAL_WOOL_ITEM.get(), RainbowSheep.ASEXUAL_DYE_ITEM.get(), "asexual");

        buildCarpetRecipe(output, RainbowSheep.RAINBOW_CARPET_ITEM.get(), RainbowSheep.RAINBOW_WOOL_ITEM.get(), RainbowSheep.RAINBOW_DYE_ITEM.get() , "rainbow");
        buildCarpetRecipe(output, RainbowSheep.TRANSGENDER_CARPET_ITEM.get(), RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), RainbowSheep.TRANSGENDER_DYE_ITEM.get() , "transgender");
        buildCarpetRecipe(output, RainbowSheep.BISEXUAL_CARPET_ITEM.get(), RainbowSheep.BISEXUAL_WOOL_ITEM.get(), RainbowSheep.BISEXUAL_DYE_ITEM.get(), "bisexual");
        buildCarpetRecipe(output, RainbowSheep.LESBIAN_CARPET_ITEM.get(), RainbowSheep.LESBIAN_WOOL_ITEM.get(), RainbowSheep.LESBIAN_DYE_ITEM.get(), "lesbian");
        buildCarpetRecipe(output, RainbowSheep.ASEXUAL_CARPET_ITEM.get(), RainbowSheep.ASEXUAL_WOOL_ITEM.get(), RainbowSheep.ASEXUAL_DYE_ITEM.get() , "asexual");

        buildVanillaWoolRecipe(output, Items.WHITE_WOOL, Items.WHITE_DYE, "white");
        buildVanillaCarpetRecipe(output, Items.WHITE_CARPET, Items.WHITE_DYE, "white");
        buildVanillaWoolRecipe(output, Items.ORANGE_WOOL, Items.ORANGE_DYE, "orange");
        buildVanillaCarpetRecipe(output, Items.ORANGE_CARPET, Items.ORANGE_DYE, "orange");
        buildVanillaWoolRecipe(output, Items.MAGENTA_WOOL, Items.MAGENTA_DYE, "magenta");
        buildVanillaCarpetRecipe(output, Items.MAGENTA_CARPET, Items.MAGENTA_DYE, "magenta");
        buildVanillaWoolRecipe(output, Items.LIME_WOOL, Items.LIME_DYE, "lime");
        buildVanillaCarpetRecipe(output, Items.LIME_CARPET, Items.LIME_DYE, "lime");
        buildVanillaWoolRecipe(output, Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaCarpetRecipe(output, Items.LIGHT_BLUE_CARPET, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaWoolRecipe(output, Items.YELLOW_WOOL, Items.YELLOW_DYE, "yellow");
        buildVanillaCarpetRecipe(output, Items.YELLOW_CARPET, Items.YELLOW_DYE, "yellow");
        buildVanillaWoolRecipe(output, Items.PINK_WOOL, Items.PINK_DYE, "pink");
        buildVanillaCarpetRecipe(output, Items.PINK_CARPET, Items.PINK_DYE, "pink");
        buildVanillaWoolRecipe(output, Items.GRAY_WOOL, Items.GRAY_DYE, "gray");
        buildVanillaCarpetRecipe(output, Items.GRAY_CARPET, Items.GRAY_DYE, "gray");
        buildVanillaWoolRecipe(output, Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaCarpetRecipe(output, Items.LIGHT_GRAY_CARPET, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaWoolRecipe(output, Items.CYAN_WOOL, Items.CYAN_DYE, "cyan");
        buildVanillaCarpetRecipe(output, Items.CYAN_CARPET, Items.CYAN_DYE, "cyan");
        buildVanillaWoolRecipe(output, Items.PURPLE_WOOL, Items.PURPLE_DYE, "purple");
        buildVanillaCarpetRecipe(output, Items.PURPLE_CARPET, Items.PURPLE_DYE, "purple");
        buildVanillaWoolRecipe(output, Items.BLUE_WOOL, Items.BLUE_DYE, "blue");
        buildVanillaCarpetRecipe(output, Items.BLUE_CARPET, Items.BLUE_DYE, "blue");
        buildVanillaWoolRecipe(output, Items.BROWN_WOOL, Items.BROWN_DYE, "brown");
        buildVanillaCarpetRecipe(output, Items.BROWN_CARPET, Items.BROWN_DYE, "brown");
        buildVanillaWoolRecipe(output, Items.GREEN_WOOL, Items.GREEN_DYE, "green");
        buildVanillaCarpetRecipe(output, Items.GREEN_CARPET, Items.GREEN_DYE, "green");
        buildVanillaWoolRecipe(output, Items.RED_WOOL, Items.RED_DYE, "red");
        buildVanillaCarpetRecipe(output, Items.RED_CARPET, Items.RED_DYE, "red");
        buildVanillaWoolRecipe(output, Items.BLACK_WOOL, Items.BLACK_DYE, "black");
        buildVanillaCarpetRecipe(output, Items.BLACK_CARPET, Items.BLACK_DYE, "black");
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

    protected void buildVanillaCarpetRecipe(RecipeOutput output, ItemLike carpet, ItemLike dye, String name) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, carpet)
                .requires(FLAG_CARPET)
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("carpet")
                .save(output);
    }

    protected void buildCarpetRecipe(RecipeOutput output, ItemLike carpet, ItemLike wool, ItemLike dye, String name) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, carpet, 3)
                .pattern("XX")
                .define('X', wool)
                .unlockedBy("has_" + name + "_wool", has(wool))
                .group("carpet")
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, carpet)
                .requires(DifferenceIngredient.of(Ingredient.of(ItemTags.WOOL_CARPETS), Ingredient.of(carpet)))
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("carpet")
                .save(output, name + "_carpet_2");
    }
}
