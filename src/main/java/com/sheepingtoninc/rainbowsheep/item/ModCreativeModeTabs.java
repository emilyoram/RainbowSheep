package com.sheepingtoninc.rainbowsheep.item;

import com.sheepingtoninc.rainbowsheep.RainbowSheep;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber (modid = RainbowSheep.MODID)
public class ModCreativeModeTabs {
    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(RainbowSheep.RAINBOW_WOOL_ITEM.get());
            event.accept(RainbowSheep.TRANSGENDER_WOOL_ITEM.get());
            event.accept(RainbowSheep.BISEXUAL_WOOL_ITEM.get());
            event.accept(RainbowSheep.LESBIAN_WOOL_ITEM.get());
            event.accept(RainbowSheep.ASEXUAL_WOOL_ITEM.get());
            event.accept(RainbowSheep.NONBINARY_WOOL_ITEM.get());

            event.accept(RainbowSheep.RAINBOW_CARPET_ITEM.get());
            event.accept(RainbowSheep.TRANSGENDER_CARPET_ITEM.get());
            event.accept(RainbowSheep.BISEXUAL_CARPET_ITEM.get());
            event.accept(RainbowSheep.LESBIAN_CARPET_ITEM.get());
            event.accept(RainbowSheep.ASEXUAL_CARPET_ITEM.get());
            event.accept(RainbowSheep.NONBINARY_CARPET_ITEM.get());
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS || event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
            event.accept(RainbowSheep.RAINBOW_BED_ITEM.get());
            event.accept(RainbowSheep.TRANSGENDER_BED_ITEM.get());
            event.accept(RainbowSheep.BISEXUAL_BED_ITEM.get());
            event.accept(RainbowSheep.LESBIAN_BED_ITEM.get());
            event.accept(RainbowSheep.ASEXUAL_BED_ITEM.get());
            event.accept(RainbowSheep.NONBINARY_BED_ITEM.get());
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
           event.accept(RainbowSheep.RAINBOW_DYE_ITEM.get());
           event.accept(RainbowSheep.TRANSGENDER_DYE_ITEM.get());
           event.accept(RainbowSheep.BISEXUAL_DYE_ITEM.get());
           event.accept(RainbowSheep.LESBIAN_DYE_ITEM.get());
           event.accept(RainbowSheep.ASEXUAL_DYE_ITEM.get());
           event.accept(RainbowSheep.NONBINARY_DYE_ITEM.get());
        }
    }
}
