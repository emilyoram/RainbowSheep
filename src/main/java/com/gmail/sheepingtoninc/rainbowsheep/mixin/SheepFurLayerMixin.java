package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.gmail.sheepingtoninc.rainbowsheep.RainbowSheep.FLAG;

@Mixin(SheepFurLayer.class)
public class SheepFurLayerMixin {
    private static final Logger log = LoggerFactory.getLogger(SheepFurLayerMixin.class);
    @Shadow @Final private static ResourceLocation SHEEP_FUR_LOCATION;

    @Inject(method = "Lnet/minecraft/client/renderer/entity/layers/SheepFurLayer;render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/animal/Sheep;FFFFFF)V", at = @At("HEAD"))
    private void injected(CallbackInfo ci, @Local Sheep livingEntity) {
        log.info("Sheep fur location: {}", SHEEP_FUR_LOCATION);
        int flagId = ((IFlagSheep) livingEntity).getFlagWool();
        log.info(flagId + "");
        if (flagId == 1) {
            SHEEP_FUR_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "textures/entity/sheep/sheep_fur_test.png");
        }
    }
}
