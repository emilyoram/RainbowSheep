package com.sheepingtoninc.rainbowsheep.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.sheepingtoninc.rainbowsheep.RainbowSheep;
import com.sheepingtoninc.rainbowsheep.blockentity.FlagBedBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BedItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class FlagBedItemRenderer extends BlockEntityWithoutLevelRenderer {
    public FlagBedItemRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher, EntityModelSet entityModelSet) {
        super(blockEntityRenderDispatcher, entityModelSet);
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource buffer, int packedLight, int packedOverlay) {
        Block block = RainbowSheep.RAINBOW_BED_BLOCK.get(); // Defaults to rainbow bed block just in case for whatever reason this renderer is used on a non-beditem
        if (stack.getItem() instanceof BedItem bedItem) {
            block = bedItem.getBlock(); // If it is a bed item gets the block
        }
        FlagBedBlockEntity bed = new FlagBedBlockEntity(BlockPos.ZERO, block.defaultBlockState());
        Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(bed, poseStack, buffer, packedLight, packedOverlay);
    }
}
