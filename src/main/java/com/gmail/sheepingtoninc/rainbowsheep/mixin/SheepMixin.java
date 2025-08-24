package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.RainbowSheep;
import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.gmail.sheepingtoninc.rainbowsheep.RainbowSheep.WOOL_FLAG;


@Mixin(Sheep.class)
public abstract class SheepMixin implements IFlagSheep {
    @Shadow public abstract boolean isSheared();

    @Shadow @Final private static EntityDataAccessor<Byte> DATA_WOOL_ID;

    @Unique
    private static final ResourceKey<LootTable> RAINBOW_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/rainbow"));

    @Unique
    private static final ResourceKey<LootTable> TRANSGENDER_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/transgender"));

    @Unique
    private static final ResourceKey<LootTable> BISEXUAL_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/bisexual"));

    @Unique
    private static final ResourceKey<LootTable> LESBIAN_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/lesbian"));

    @Unique
    private static final ResourceKey<LootTable> ASEXUAL_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/asexual"));

    @Unique
    private static final ResourceKey<LootTable> NONBINARY_LOOT_KEY = ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath("rainbowsheep", "entities/sheep/nonbinary"));


    @Override
    public void rainbowSheep$setFlagWool(int flag) {
        Sheep sheep = ((Sheep)(Object)this);
        SynchedEntityData data = sheep.getEntityData();
        byte woolByte = data.get(DATA_WOOL_ID);
        data.set(DATA_WOOL_ID, (byte)(woolByte & 240));
        sheep.setData(WOOL_FLAG, flag);
    }

    @Override
    public int rainbowSheep$getFlagWool() {
        return ((Sheep)(Object) this).getData(WOOL_FLAG);
    }

    @ModifyArg(method = "shear", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;I)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private ItemLike shearFlagWool(ItemLike original) {
        return switch (rainbowSheep$getFlagWool()) {
            case 1 -> RainbowSheep.RAINBOW_WOOL_ITEM.get();
            case 2 -> RainbowSheep.TRANSGENDER_WOOL_ITEM.get();
            case 3 -> RainbowSheep.BISEXUAL_WOOL_ITEM.get();
            case 4 -> RainbowSheep.LESBIAN_WOOL_ITEM.get();
            case 5 -> RainbowSheep.ASEXUAL_WOOL_ITEM.get();
            case 6 -> RainbowSheep.NONBINARY_WOOL_ITEM.get();
            default -> original;
        };
    }

    @Inject(method = "getDefaultLootTable", at = @At(value = "HEAD"), cancellable = true)
    protected void setFlagLootTable(CallbackInfoReturnable<ResourceKey<LootTable>> cir) {
        if (!isSheared() && rainbowSheep$getFlagWool() != 0) {
            switch (rainbowSheep$getFlagWool()) {
                case 1 -> cir.setReturnValue(RAINBOW_LOOT_KEY);
                case 2 -> cir.setReturnValue(TRANSGENDER_LOOT_KEY);
                case 3 -> cir.setReturnValue(BISEXUAL_LOOT_KEY) ;
                case 4 -> cir.setReturnValue(LESBIAN_LOOT_KEY);
                case 5 -> cir.setReturnValue(ASEXUAL_LOOT_KEY);
                case 6 -> cir.setReturnValue(NONBINARY_LOOT_KEY);
            }
        }
    }

    @Inject(method = "getBreedOffspring(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/AgeableMob;)Lnet/minecraft/world/entity/animal/Sheep;",
    at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/animal/Sheep;setColor(Lnet/minecraft/world/item/DyeColor;)V", shift = At.Shift.AFTER))
    private void getOffspringFlag(ServerLevel level, AgeableMob otherParent, CallbackInfoReturnable<Sheep> cir, @Local(name = "sheep") Sheep sheep) {
        int flag1 = rainbowSheep$getFlagWool();
        int flag2 = ((IFlagSheep) otherParent).rainbowSheep$getFlagWool();
        int offspringFlag = level.random.nextBoolean() ? flag1 : flag2;
        if (offspringFlag != 0) {
            ((IFlagSheep) sheep).rainbowSheep$setFlagWool(offspringFlag);
        }
        // TODO: Currently while this works for breeding two flag sheep together or two non-flag sheep, weird stuff happens when you breed a flag and non-flag sheep together
    }


    @Inject(method = "setColor", at = @At("HEAD"))
    private void removeFlagOnColor(DyeColor newColor, CallbackInfo ci) {
        if (!((Sheep)(Object)this).level().isClientSide && ((Sheep)(Object)this).tickCount > 0) { //setColor is called when loading sheep, this ensures that first call does not remove flag wool
            this.rainbowSheep$setFlagWool(0);
        }
    }
}
