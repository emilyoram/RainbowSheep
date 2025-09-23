package com.sheepingtoninc.rainbowsheep;

import com.sheepingtoninc.rainbowsheep.client.FlagBedRenderer;
import com.sheepingtoninc.rainbowsheep.item.FlagBedItemExtension;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = RainbowSheep.MODID, value = Dist.CLIENT)
public class RainbowSheepClient {

    @SubscribeEvent
    public static void entityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RainbowSheep.FLAG_BED_ENTITY.get(), FlagBedRenderer::new);
        RainbowSheep.LOGGER.info("Rainbow Sheep Block Entity renderer registered");
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new FlagBedItemExtension(), RainbowSheep.RAINBOW_BED_ITEM);
    }
}