package com.sheepingtoninc.rainbowsheep.data;

import com.sheepingtoninc.rainbowsheep.RainbowSheep;
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
    public static final TagKey<Item> FLAG_BED = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "flag_bed"));

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
        buildFlagWoolRecipe(output, RainbowSheep.NONBINARY_WOOL_ITEM.get(), RainbowSheep.NONBINARY_DYE_ITEM.get(), "nonbinary");

        buildCarpetRecipe(output, RainbowSheep.RAINBOW_CARPET_ITEM.get(), RainbowSheep.RAINBOW_WOOL_ITEM.get(), RainbowSheep.RAINBOW_DYE_ITEM.get() , "rainbow");
        buildCarpetRecipe(output, RainbowSheep.TRANSGENDER_CARPET_ITEM.get(), RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), RainbowSheep.TRANSGENDER_DYE_ITEM.get() , "transgender");
        buildCarpetRecipe(output, RainbowSheep.BISEXUAL_CARPET_ITEM.get(), RainbowSheep.BISEXUAL_WOOL_ITEM.get(), RainbowSheep.BISEXUAL_DYE_ITEM.get(), "bisexual");
        buildCarpetRecipe(output, RainbowSheep.LESBIAN_CARPET_ITEM.get(), RainbowSheep.LESBIAN_WOOL_ITEM.get(), RainbowSheep.LESBIAN_DYE_ITEM.get(), "lesbian");
        buildCarpetRecipe(output, RainbowSheep.ASEXUAL_CARPET_ITEM.get(), RainbowSheep.ASEXUAL_WOOL_ITEM.get(), RainbowSheep.ASEXUAL_DYE_ITEM.get() , "asexual");
        buildCarpetRecipe(output, RainbowSheep.NONBINARY_CARPET_ITEM.get(), RainbowSheep.NONBINARY_WOOL_ITEM.get(), RainbowSheep.NONBINARY_DYE_ITEM.get() , "nonbinary");

        buildBedRecipe(output, RainbowSheep.RAINBOW_BED_ITEM.get(), RainbowSheep.RAINBOW_WOOL_ITEM.get(), RainbowSheep.RAINBOW_DYE_ITEM.get(), "rainbow");
        buildBedRecipe(output, RainbowSheep.TRANSGENDER_BED_ITEM.get(), RainbowSheep.TRANSGENDER_WOOL_ITEM.get(), RainbowSheep.TRANSGENDER_DYE_ITEM.get(), "transgender");
        buildBedRecipe(output, RainbowSheep.BISEXUAL_BED_ITEM.get(), RainbowSheep.BISEXUAL_WOOL_ITEM.get(), RainbowSheep.BISEXUAL_DYE_ITEM.get(), "bisexual");
        buildBedRecipe(output, RainbowSheep.LESBIAN_BED_ITEM.get(), RainbowSheep.LESBIAN_WOOL_ITEM.get(), RainbowSheep.LESBIAN_DYE_ITEM.get(), "lesbian");
        buildBedRecipe(output, RainbowSheep.ASEXUAL_BED_ITEM.get(), RainbowSheep.ASEXUAL_WOOL_ITEM.get(), RainbowSheep.ASEXUAL_DYE_ITEM.get(), "asexual");
        buildBedRecipe(output, RainbowSheep.NONBINARY_BED_ITEM.get(), RainbowSheep.NONBINARY_WOOL_ITEM.get(), RainbowSheep.NONBINARY_DYE_ITEM.get(), "nonbinary");

        buildVanillaWoolRecipe(output, Items.WHITE_WOOL, Items.WHITE_DYE, "white");
        buildVanillaCarpetRecipe(output, Items.WHITE_CARPET, Items.WHITE_DYE, "white");
        buildVanillaBedRecipe(output, Items.WHITE_BED, Items.WHITE_DYE, "white");
        buildVanillaWoolRecipe(output, Items.ORANGE_WOOL, Items.ORANGE_DYE, "orange");
        buildVanillaCarpetRecipe(output, Items.ORANGE_CARPET, Items.ORANGE_DYE, "orange");
        buildVanillaBedRecipe(output, Items.ORANGE_BED, Items.ORANGE_DYE, "orange");
        buildVanillaWoolRecipe(output, Items.MAGENTA_WOOL, Items.MAGENTA_DYE, "magenta");
        buildVanillaCarpetRecipe(output, Items.MAGENTA_CARPET, Items.MAGENTA_DYE, "magenta");
        buildVanillaBedRecipe(output, Items.MAGENTA_BED, Items.MAGENTA_DYE, "magenta");
        buildVanillaWoolRecipe(output, Items.LIME_WOOL, Items.LIME_DYE, "lime");
        buildVanillaCarpetRecipe(output, Items.LIME_CARPET, Items.LIME_DYE, "lime");
        buildVanillaBedRecipe(output, Items.LIME_BED, Items.LIME_DYE, "lime");
        buildVanillaWoolRecipe(output, Items.LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaCarpetRecipe(output, Items.LIGHT_BLUE_CARPET, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaBedRecipe(output, Items.LIGHT_BLUE_BED, Items.LIGHT_BLUE_DYE, "light_blue");
        buildVanillaWoolRecipe(output, Items.YELLOW_WOOL, Items.YELLOW_DYE, "yellow");
        buildVanillaCarpetRecipe(output, Items.YELLOW_CARPET, Items.YELLOW_DYE, "yellow");
        buildVanillaBedRecipe(output, Items.YELLOW_BED, Items.YELLOW_DYE, "yellow");
        buildVanillaWoolRecipe(output, Items.PINK_WOOL, Items.PINK_DYE, "pink");
        buildVanillaCarpetRecipe(output, Items.PINK_CARPET, Items.PINK_DYE, "pink");
        buildVanillaBedRecipe(output, Items.PINK_BED, Items.PINK_DYE, "pink");
        buildVanillaWoolRecipe(output, Items.GRAY_WOOL, Items.GRAY_DYE, "gray");
        buildVanillaCarpetRecipe(output, Items.GRAY_CARPET, Items.GRAY_DYE, "gray");
        buildVanillaBedRecipe(output, Items.GRAY_BED, Items.GRAY_DYE, "gray");
        buildVanillaWoolRecipe(output, Items.LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaCarpetRecipe(output, Items.LIGHT_GRAY_CARPET, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaBedRecipe(output, Items.LIGHT_GRAY_BED, Items.LIGHT_GRAY_DYE, "light_gray");
        buildVanillaWoolRecipe(output, Items.CYAN_WOOL, Items.CYAN_DYE, "cyan");
        buildVanillaCarpetRecipe(output, Items.CYAN_CARPET, Items.CYAN_DYE, "cyan");
        buildVanillaBedRecipe(output, Items.CYAN_BED, Items.CYAN_DYE, "cyan");
        buildVanillaWoolRecipe(output, Items.PURPLE_WOOL, Items.PURPLE_DYE, "purple");
        buildVanillaCarpetRecipe(output, Items.PURPLE_CARPET, Items.PURPLE_DYE, "purple");
        buildVanillaBedRecipe(output, Items.PURPLE_BED, Items.PURPLE_DYE, "purple");
        buildVanillaWoolRecipe(output, Items.BLUE_WOOL, Items.BLUE_DYE, "blue");
        buildVanillaCarpetRecipe(output, Items.BLUE_CARPET, Items.BLUE_DYE, "blue");
        buildVanillaBedRecipe(output, Items.BLUE_BED, Items.BLUE_DYE, "blue");
        buildVanillaWoolRecipe(output, Items.BROWN_WOOL, Items.BROWN_DYE, "brown");
        buildVanillaCarpetRecipe(output, Items.BROWN_CARPET, Items.BROWN_DYE, "brown");
        buildVanillaBedRecipe(output, Items.BROWN_BED, Items.BROWN_DYE, "brown");
        buildVanillaWoolRecipe(output, Items.GREEN_WOOL, Items.GREEN_DYE, "green");
        buildVanillaCarpetRecipe(output, Items.GREEN_CARPET, Items.GREEN_DYE, "green");
        buildVanillaBedRecipe(output, Items.GREEN_BED, Items.GREEN_DYE, "green");
        buildVanillaWoolRecipe(output, Items.RED_WOOL, Items.RED_DYE, "red");
        buildVanillaCarpetRecipe(output, Items.RED_CARPET, Items.RED_DYE, "red");
        buildVanillaBedRecipe(output, Items.RED_BED, Items.RED_DYE, "red");
        buildVanillaWoolRecipe(output, Items.BLACK_WOOL, Items.BLACK_DYE, "black");
        buildVanillaCarpetRecipe(output, Items.BLACK_CARPET, Items.BLACK_DYE, "black");
        buildVanillaBedRecipe(output , Items.BLACK_BED, Items.BLACK_DYE, "black");
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

    protected void buildVanillaBedRecipe(RecipeOutput output, ItemLike bed, ItemLike dye, String name) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, bed)
                .requires(FLAG_BED)
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("beds")
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
                .save(output, "rainbowsheep:" + name + "_carpet_2");
    }

    protected void buildBedRecipe(RecipeOutput output, ItemLike bed, ItemLike wool, ItemLike dye, String name) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, bed, 1)
                .pattern("XXX")
                .pattern("###")
                .define('X', wool)
                .define('#', ItemTags.PLANKS)
                .unlockedBy("has_" + name + "_wool", has(wool))
                .group("beds")
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, bed)
                .requires(DifferenceIngredient.of(Ingredient.of(ItemTags.BEDS), Ingredient.of(bed)))
                .requires(dye)
                .unlockedBy("has_" + name + "_dye", has(dye))
                .group("beds")
                .save(output, "rainbowsheep:" + name + "_bed_2");
    }
}
