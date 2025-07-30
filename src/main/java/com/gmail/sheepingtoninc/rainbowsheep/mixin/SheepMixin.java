package com.gmail.sheepingtoninc.rainbowsheep.mixin;

import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Sheep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Sheep.class)
public class SheepMixin implements IFlagSheep {
    private static final Logger log = LoggerFactory.getLogger(SheepMixin.class);
    private static final EntityDataAccessor<Integer> FLAG = SynchedEntityData.defineId(Sheep.class, EntityDataSerializers.INT);

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

    @Override
    public void helloSheep() {
        log.info("Hello sheep");
    }

    @Inject(method = "Lnet/minecraft/world/entity/animal/Sheep;defineSynchedData(Lnet/minecraft/network/syncher/SynchedEntityData$Builder;)V", at = @At("TAIL"))
    private void defineSynchedData (SynchedEntityData.Builder builder, CallbackInfo ci) {
        builder.define(FLAG, 0);
    }
}
