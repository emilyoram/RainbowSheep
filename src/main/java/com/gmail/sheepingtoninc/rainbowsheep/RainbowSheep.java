package com.gmail.sheepingtoninc.rainbowsheep;

import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.block.FlagCarpetBlock;
import com.gmail.sheepingtoninc.rainbowsheep.block.FlagWoolBlock;
import com.gmail.sheepingtoninc.rainbowsheep.item.RainbowDyeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(RainbowSheep.MODID)
public class RainbowSheep {
    public static final String MODID = "rainbowsheep";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

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

    public static final Supplier<BlockItem> RAINBOW_WOOL_ITEM = ITEMS.registerSimpleBlockItem("rainbow_wool", RAINBOW_WOOL_BLOCK);
    public static final Supplier<BlockItem> RAINBOW_CARPET_ITEM = ITEMS.registerSimpleBlockItem("rainbow_carpet", RAINBOW_CARPET_BLOCK);
    public static final Supplier<BlockItem> TRANSGENDER_WOOL_ITEM = ITEMS.registerSimpleBlockItem("transgender_wool", TRANSGENDER_WOOL_BLOCK);
    public static final Supplier<BlockItem> TRANSGENDER_CARPET_ITEM = ITEMS.registerSimpleBlockItem("transgender_carpet", TRANSGENDER_CARPET_BLOCK);
    public static final DeferredItem<RainbowDyeItem> RAINBOW_DYE_ITEM = ITEMS.register("rainbow_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.RAINBOW));
    public static final DeferredItem<RainbowDyeItem> TRANSGENDER_DYE_ITEM = ITEMS.register("transgender_dye", () -> new RainbowDyeItem(new Item.Properties(), FlagWool.TRANSGENDER));

    public RainbowSheep(IEventBus modBus, ModContainer container) {
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
    }

    @SubscribeEvent
    public void onCommonSetup(FMLCommonSetupEvent event) {
    }
}
