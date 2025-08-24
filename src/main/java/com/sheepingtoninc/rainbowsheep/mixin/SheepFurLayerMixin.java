package com.sheepingtoninc.rainbowsheep.mixin;

import com.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SheepFurLayer.class)
public class SheepFurLayerMixin {
    @Unique
    private static final ResourceLocation rainbowSheep$RAINBOW = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_rainbow.png");
    @Unique
    private static final ResourceLocation rainbowSheep$TRANSGENDER = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_transgender.png");
    @Unique
    private static final ResourceLocation rainbowSheep$BISEXUAL = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_bisexual.png");
    @Unique
    private static final ResourceLocation rainbowSheep$LESBIAN = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_lesbian.png");
    @Unique
    private static final ResourceLocation rainbowSheep$ASEXUAL = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_asexual.png");
    @Unique
    private static final ResourceLocation rainbowSheep$NONBINARY = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_nonbinary.png");

    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "coloredCutoutModelCopyLayerRender"
            ),
            index = 2
    )
    private ResourceLocation modifyFurTexture(ResourceLocation original, @Local Sheep livingEntity) {
        return switch (((IFlagSheep) livingEntity).rainbowSheep$getFlagWool()) {
            case 1 -> rainbowSheep$RAINBOW;
            case 2 -> rainbowSheep$TRANSGENDER;
            case 3 -> rainbowSheep$BISEXUAL;
            case 4 -> rainbowSheep$LESBIAN;
            case 5 -> rainbowSheep$ASEXUAL;
            case 6 -> rainbowSheep$NONBINARY;
            default -> original;
        };
    }

    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "coloredCutoutModelCopyLayerRender"
            ),
            index = 13
    )
    private int removeFurTint(int original, @Local Sheep livingEntity) {
        if (((IFlagSheep) livingEntity).rainbowSheep$getFlagWool() != 0) {
            return -1644826;
        }
        return original;
    }
}

