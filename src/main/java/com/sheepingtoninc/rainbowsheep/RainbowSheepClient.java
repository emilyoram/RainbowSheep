package com.sheepingtoninc.rainbowsheep;

import com.sheepingtoninc.rainbowsheep.client.FlagBedRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = RainbowSheep.MODID, value = Dist.CLIENT)
public class RainbowSheepClient {

    @SubscribeEvent
    public static void entityRenderersEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RainbowSheep.FLAG_BED_ENTITY.get(), FlagBedRenderer::new);
        RainbowSheep.LOGGER.info("Rainbow Sheep Block Entity renderer registered");
    }
}
