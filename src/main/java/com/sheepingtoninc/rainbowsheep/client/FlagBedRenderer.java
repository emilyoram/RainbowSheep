package com.sheepingtoninc.rainbowsheep.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.sheepingtoninc.rainbowsheep.RainbowSheep;
import com.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.sheepingtoninc.rainbowsheep.blockentity.FlagBedBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FlagBedRenderer implements BlockEntityRenderer<FlagBedBlockEntity> {
    protected final ModelPart headRoot;
    protected final ModelPart footRoot;

    public FlagBedRenderer(BlockEntityRendererProvider.Context context) {
        this.headRoot = context.bakeLayer(ModelLayers.BED_HEAD);
        this.footRoot = context.bakeLayer(ModelLayers.BED_FOOT);
    }

    private Material getFlagMaterial(FlagBedBlockEntity blockEntity) {
        ResourceLocation sheet = ResourceLocation.withDefaultNamespace("textures/atlas/beds.png");
        return new Material(sheet, ResourceLocation.fromNamespaceAndPath(RainbowSheep.MODID, "rainbowsheep_rainbow"));
    }

    @Override
    public void render(FlagBedBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Material material = getFlagMaterial(blockEntity);
        Level level = blockEntity.getLevel();
        if (level != null) {
            BlockState blockstate = blockEntity.getBlockState();
            DoubleBlockCombiner.NeighborCombineResult<? extends BedBlockEntity> neighborcombineresult = DoubleBlockCombiner.combineWithNeigbour(
                    BlockEntityType.BED,
                    BedBlock::getBlockType,
                    BedBlock::getConnectedDirection,
                    ChestBlock.FACING,
                    blockstate,
                    level,
                    blockEntity.getBlockPos(),
                    (p_112202_, p_112203_) -> false
            );
            int i = neighborcombineresult.apply(new BrightnessCombiner<>()).get(packedLight);
            this.renderPiece(
                    poseStack,
                    bufferSource,
                    blockstate.getValue(BedBlock.PART) == BedPart.HEAD ? this.headRoot : this.footRoot,
                    blockstate.getValue(BedBlock.FACING),
                    material,
                    i,
                    packedOverlay,
                    false
            );
        } else {
            this.renderPiece(poseStack, bufferSource, this.headRoot, Direction.SOUTH, material, packedLight, packedOverlay, false);
            this.renderPiece(poseStack, bufferSource, this.footRoot, Direction.SOUTH, material, packedLight, packedOverlay, true);
        }
    }
    protected void renderPiece(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            ModelPart modelPart,
            Direction direction,
            Material material,
            int packedLight,
            int packedOverlay,
            boolean foot
    ) {
        poseStack.pushPose();
        poseStack.translate(0.0F, 0.5625F, foot ? -1.0F : 0.0F);
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F + direction.toYRot()));
        poseStack.translate(-0.5F, -0.5F, -0.5F);
        VertexConsumer vertexconsumer = material.buffer(bufferSource, RenderType::entitySolid);
        modelPart.render(poseStack, vertexconsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }
}
