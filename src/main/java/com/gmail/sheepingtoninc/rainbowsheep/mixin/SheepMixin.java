package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Sheep.class)
public abstract class SheepMixin implements IFlagSheep {
    @Shadow public abstract boolean isSheared();

    private static final Logger log = LoggerFactory.getLogger(SheepMixin.class);
    private static final EntityDataAccessor<Integer> FLAG = SynchedEntityData.defineId(Sheep.class, EntityDataSerializers.INT);

    private static final ResourceLocation RAINBOW_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/rainbow");
    private static final ResourceKey<LootTable> RAINBOW_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, RAINBOW_LOOT_LOCATION);

    private static final ResourceLocation TRANSGENDER_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/transgender");
    private static final ResourceKey<LootTable> TRANSGENDER_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, TRANSGENDER_LOOT_LOCATION);

    private SynchedEntityData getData() {
        return ((Sheep)(Object)this).getEntityData();
    }

    @Override
    public void setFlagWool(int flag) {
        getData().set(FLAG, flag);
    }

    @Override
    public int getFlagWool() {
        return getData().get(FLAG);
    }

    @Inject(method = "Lnet/minecraft/world/entity/animal/Sheep;defineSynchedData(Lnet/minecraft/network/syncher/SynchedEntityData$Builder;)V", at = @At("TAIL"))
    private void defineSynchedData (SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(FLAG, 0);
    }

    @Inject(method = "Lnet/minecraft/world/entity/animal/Sheep;addAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void addAdditionalSaveData(CompoundTag compound, CallbackInfo ci) { compound.putInt("Flag", this.getFlagWool()); }

    @Inject(method = "Lnet/minecraft/world/entity/animal/Sheep;readAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void readAdditionalSaveData(CompoundTag compound, CallbackInfo ci) { this.setFlagWool(compound.getInt("Flag")); }

    @ModifyArg(method = "shear", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;I)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemLike shear(ItemLike original) {
        return switch (getFlagWool()) {
            case 1 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "rainbow_wool"));
            case 2 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "transgender_wool"));
            default -> original;
        };

    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "RETURN"), cancellable = true)
    protected void setFlagLootTable(CallbackInfoReturnable<ResourceKey<LootTable>> cir) {
        if (!isSheared() && this.getFlagWool() != 0) {
            switch (this.getFlagWool()) {
                case 1 -> cir.setReturnValue(RAINBOW_LOOT_KEY);
                case 2 -> cir.setReturnValue(TRANSGENDER_LOOT_KEY);
            }
        }
    }
}
