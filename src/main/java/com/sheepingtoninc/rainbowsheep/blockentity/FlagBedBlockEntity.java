package com.sheepingtoninc.rainbowsheep.blockentity;

import com.sheepingtoninc.rainbowsheep.RainbowSheep;
import com.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.sheepingtoninc.rainbowsheep.block.FlagBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class FlagBedBlockEntity extends BlockEntity {
    private FlagWool flag;

    public FlagBedBlockEntity(BlockPos pos, BlockState blockState) {
        super(RainbowSheep.FLAG_BED_ENTITY.get(), pos, blockState);
        this.flag = ((FlagBedBlock)blockState.getBlock()).getFlag();
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public FlagWool getFlag() {
        return this.flag;
    }

    public void setFlag(FlagWool flag) {
        this.flag = flag;
    }
}
