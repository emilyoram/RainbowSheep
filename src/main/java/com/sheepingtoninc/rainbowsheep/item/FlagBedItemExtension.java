package com.sheepingtoninc.rainbowsheep.item;

import com.sheepingtoninc.rainbowsheep.client.FlagBedItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class FlagBedItemExtension implements IClientItemExtensions {

    @Override
    public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
        Minecraft mc = Minecraft.getInstance();
        return new FlagBedItemRenderer(mc.getBlockEntityRenderDispatcher(), mc.getEntityModels());
    }
}
