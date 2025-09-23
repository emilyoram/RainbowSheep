package com.sheepingtoninc.rainbowsheep.block;

import com.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.sheepingtoninc.rainbowsheep.blockentity.FlagBedBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class FlagBedBlock extends BedBlock {
    private final FlagWool flag;

    public FlagBedBlock(FlagWool flag, Properties properties) {
        super(DyeColor.WHITE, properties);
        this.flag = flag;
    }

    public FlagWool getFlag() {
        return this.flag;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FlagBedBlockEntity(pos, state);
    }
}
