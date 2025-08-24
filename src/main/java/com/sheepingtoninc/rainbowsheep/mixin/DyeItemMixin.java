package com.sheepingtoninc.rainbowsheep.mixin;

import com.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DyeItem.class)
public class DyeItemMixin {

    @ModifyExpressionValue(method = "interactLivingEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;getColor()Lnet/minecraft/world/item/DyeColor;"))
    private DyeColor rainbowSheep$convinceDyeFlagIsDifferentToWhite(DyeColor original, @Local LivingEntity target) {
        if (target instanceof Sheep sheep && original == DyeColor.WHITE && ((IFlagSheep) sheep).rainbowSheep$getFlagWool() != 0) {
            return DyeColor.GRAY;
        }
        return original;
    }
}
