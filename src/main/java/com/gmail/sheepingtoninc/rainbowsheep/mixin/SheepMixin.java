package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
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
import org.spongepowered.asm.mixin.Final;
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

    @Shadow @Final private static EntityDataAccessor<Byte> DATA_WOOL_ID;
    private static final EntityDataAccessor<Integer> FLAG = SynchedEntityData.defineId(Sheep.class, EntityDataSerializers.INT);

    private static final ResourceLocation RAINBOW_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/rainbow");
    private static final ResourceKey<LootTable> RAINBOW_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, RAINBOW_LOOT_LOCATION);

    private static final ResourceLocation TRANSGENDER_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/transgender");
    private static final ResourceKey<LootTable> TRANSGENDER_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, TRANSGENDER_LOOT_LOCATION);

    private static final ResourceLocation BISEXUAL_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/bisexual");
    private static final ResourceKey<LootTable> BISEXUAL_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, BISEXUAL_LOOT_LOCATION);

    private static final ResourceLocation LESBIAN_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/lesbian");
    private static final ResourceKey<LootTable> LESBIAN_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, LESBIAN_LOOT_LOCATION);

    private static final ResourceLocation ASEXUAL_LOOT_LOCATION = ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/asexual");
    private static final ResourceKey<LootTable> ASEXUAL_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ASEXUAL_LOOT_LOCATION);


    private SynchedEntityData getData() {
        return ((Sheep)(Object)this).getEntityData();
    }

    @Override
    public void rainbowSheep$setFlagWool(int flag) {
        SynchedEntityData data = this.getData();
        byte woolByte = data.get(DATA_WOOL_ID);
        data.set(DATA_WOOL_ID, (byte)(woolByte & 240));
        data.set(FLAG, flag);
    }

    @Override
    public int rainbowSheep$getFlagWool() {
        return getData().get(FLAG);
    }

    @Inject(method = "defineSynchedData(Lnet/minecraft/network/syncher/SynchedEntityData$Builder;)V", at = @At("TAIL"))
    private void defineFlagSynchedData (SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(FLAG, 0);
    }

    @Inject(method = "addAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void addFlagSaveData(CompoundTag compound, CallbackInfo ci) { compound.putInt("Flag", this.rainbowSheep$getFlagWool()); }

    @Inject(method = "readAdditionalSaveData(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void readFlagSaveData(CompoundTag compound, CallbackInfo ci) { this.rainbowSheep$setFlagWool(compound.getInt("Flag")); }

    @ModifyArg(method = "shear", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;I)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemLike shearFlagWool(ItemLike original) {
        return switch (rainbowSheep$getFlagWool()) {
            case 1 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "rainbow_wool"));
            case 2 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "transgender_wool"));
            case 3 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "bisexual_wool"));
            case 4 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "lesbian_wool"));
            case 5 ->
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("rainbowsheep", "asexual_wool"));
            default -> original;
        };
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    protected void setFlagLootTable(CallbackInfoReturnable<ResourceKey<LootTable>> cir) {
        if (!isSheared() && this.rainbowSheep$getFlagWool() != 0) {
            switch (this.rainbowSheep$getFlagWool()) {
                case 1 -> cir.setReturnValue(RAINBOW_LOOT_KEY);
                case 2 -> cir.setReturnValue(TRANSGENDER_LOOT_KEY);
                case 3 -> cir.setReturnValue(BISEXUAL_LOOT_KEY) ;
                case 4 -> cir.setReturnValue(LESBIAN_LOOT_KEY);
                case 5 -> cir.setReturnValue(ASEXUAL_LOOT_KEY);
            }
        }
    }

    @Inject(method = "setColor", at = @At(value="HEAD"))
    private void removeFlagOnColor(CallbackInfo ci) {
        this.rainbowSheep$setFlagWool(0);
    }
}
