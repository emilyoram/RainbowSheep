package com.gmail.sheepingtoninc.rainbowsheep;

import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.block.FlagCarpetBlock;
import com.gmail.sheepingtoninc.rainbowsheep.block.FlagWoolBlock;
import com.gmail.sheepingtoninc.rainbowsheep.item.RainbowDyeItem;
import com.mojang.serialization.Codec;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;

@Mod(RainbowSheep.MODID)
public class RainbowSheep {
    public static final String MODID = "rainbowsheep";

    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);

    public static final DeferredBlock<Block> RAINBOW_WOOL_BLOCK = BLOCKS.register("rainbow_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_RED)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> RAINBOW_CARPET_BLOCK = BLOCKS.register("rainbow_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> TRANSGENDER_WOOL_BLOCK = BLOCKS.register("transgender_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> TRANSGENDER_CARPET_BLOCK = BLOCKS.register("transgender_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_LIGHT_BLUE)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> BISEXUAL_WOOL_BLOCK = BLOCKS.register("bisexual_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_MAGENTA)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> BISEXUAL_CARPET_BLOCK = BLOCKS.register("bisexual_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_MAGENTA)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> LESBIAN_WOOL_BLOCK = BLOCKS.register("lesbian_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> LESBIAN_CARPET_BLOCK = BLOCKS.register("lesbian_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> ASEXUAL_WOOL_BLOCK = BLOCKS.register("asexual_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> ASEXUAL_CARPET_BLOCK = BLOCKS.register("asexual_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_ORANGE)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> NONBINARY_WOOL_BLOCK = BLOCKS.register("nonbinary_wool", registryName -> new FlagWoolBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));
    public static final DeferredBlock<Block> NONBINARY_CARPET_BLOCK = BLOCKS.register("nonbinary_carpet", registryName -> new FlagCarpetBlock(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .strength(0.1F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));


    public static final Supplier<BlockItem> RAINBOW_WOOL_ITEM = ITEMS.registerSimpleBlockItem("rainbow_wool", RAINBOW_WOOL_BLOCK);
    public static final Supplier<BlockItem> RAINBOW_CARPET_ITEM = ITEMS.registerSimpleBlockItem("rainbow_carpet", RAINBOW_CARPET_BLOCK);
    public static final Supplier<BlockItem> TRANSGENDER_WOOL_ITEM = ITEMS.registerSimpleBlockItem("transgender_wool", TRANSGENDER_WOOL_BLOCK);
    public static final Supplier<BlockItem> TRANSGENDER_CARPET_ITEM = ITEMS.registerSimpleBlockItem("transgender_carpet", TRANSGENDER_CARPET_BLOCK);
    public static final Supplier<BlockItem> BISEXUAL_WOOL_ITEM = ITEMS.registerSimpleBlockItem("bisexual_wool", BISEXUAL_WOOL_BLOCK);
    public static final Supplier<BlockItem> BISEXUAL_CARPET_ITEM = ITEMS.registerSimpleBlockItem("bisexual_carpet", BISEXUAL_CARPET_BLOCK);
    public static final Supplier<BlockItem> LESBIAN_WOOL_ITEM = ITEMS.registerSimpleBlockItem("lesbian_wool", LESBIAN_WOOL_BLOCK);
    public static final Supplier<BlockItem> LESBIAN_CARPET_ITEM = ITEMS.registerSimpleBlockItem("lesbian_carpet", LESBIAN_CARPET_BLOCK);
    public static final Supplier<BlockItem> ASEXUAL_WOOL_ITEM = ITEMS.registerSimpleBlockItem("asexual_wool", ASEXUAL_WOOL_BLOCK);
    public static final Supplier<BlockItem> ASEXUAL_CARPET_ITEM = ITEMS.registerSimpleBlockItem("asexual_carpet", ASEXUAL_CARPET_BLOCK);
    public static final Supplier<BlockItem> NONBINARY_WOOL_ITEM = ITEMS.registerSimpleBlockItem("nonbinary_wool", NONBINARY_WOOL_BLOCK);
    public static final Supplier<BlockItem> NONBINARY_CARPET_ITEM = ITEMS.registerSimpleBlockItem("nonbinary_carpet", NONBINARY_CARPET_BLOCK);
    public static final DeferredItem<RainbowDyeItem> RAINBOW_DYE_ITEM = ITEMS.register("rainbow_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.RAINBOW));
    public static final DeferredItem<RainbowDyeItem> TRANSGENDER_DYE_ITEM = ITEMS.register("transgender_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.TRANSGENDER));
    public static final DeferredItem<RainbowDyeItem> BISEXUAL_DYE_ITEM = ITEMS.register("bisexual_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.BISEXUAL));
    public static final DeferredItem<RainbowDyeItem> LESBIAN_DYE_ITEM = ITEMS.register("lesbian_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.LESBIAN));
    public static final DeferredItem<RainbowDyeItem> ASEXUAL_DYE_ITEM = ITEMS.register("asexual_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.ASEXUAL));
    public static final DeferredItem<RainbowDyeItem> NONBINARY_DYE_ITEM = ITEMS.register("nonbinary_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.NONBINARY));

    public static final Supplier<AttachmentType<Integer>> WOOL_FLAG = ATTACHMENT_TYPES.register(
            "flag", () ->  AttachmentType.builder(() -> 0).serialize(Codec.INT).sync(ByteBufCodecs.INT).build()
    );


    public RainbowSheep(IEventBus modBus, ModContainer container) {
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
        ATTACHMENT_TYPES.register(modBus);
    }
}
