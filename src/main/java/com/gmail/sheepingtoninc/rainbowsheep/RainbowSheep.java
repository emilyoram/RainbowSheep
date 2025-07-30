package com.gmail.sheepingtoninc.rainbowsheep;

import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.block.FlammableBlock;
import com.gmail.sheepingtoninc.rainbowsheep.item.RainbowDye;
import com.mojang.serialization.Codec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@Mod(RainbowSheep.MODID)
public class RainbowSheep {
    public static final String MODID = "rainbowsheep";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);

    public static final DeferredBlock<Block> RAINBOW_WOOL_BLOCK = BLOCKS.register("rainbow_wool", registryName -> new FlammableBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));

    public static final Supplier<BlockItem> RAINBOW_WOOL_ITEM = ITEMS.registerSimpleBlockItem("rainbow_wool", RAINBOW_WOOL_BLOCK);
    public static final DeferredItem<RainbowDye> RAINBOW_DYE_ITEM = ITEMS.register("rainbow_dye", () -> new RainbowDye(new Item.Properties(), FlagWool.RAINBOW));
    public static final DeferredItem<RainbowDye> BORING_DYE_ITEM = ITEMS.register("boring_dye", () -> new RainbowDye(new Item.Properties(), FlagWool.NONE));

    public static final Supplier<AttachmentType<Integer>> FLAG = ATTACHMENT_TYPES.register(
            "flag", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());

    public RainbowSheep(IEventBus modBus, ModContainer container) {
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        ATTACHMENT_TYPES.register(modBus);
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
    }
}
