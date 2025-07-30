package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(SheepFurLayer.class)
public class SheepFurLayerMixin {
    private static final ResourceLocation RAINBOW = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_rainbow.png");

    @ModifyArg(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "coloredCutoutModelCopyLayerRender"
            ),
            index = 2
    )
    private ResourceLocation modifyFurTexture(ResourceLocation original, @Local Sheep livingEntity) {
        if (((IFlagSheep) livingEntity).getFlagWool() == 1) {
            return RAINBOW;
        }
        return original;
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
        if (((IFlagSheep) livingEntity).getFlagWool() != 0) {
            return -1644826;
        }
        return original;
    }
}

