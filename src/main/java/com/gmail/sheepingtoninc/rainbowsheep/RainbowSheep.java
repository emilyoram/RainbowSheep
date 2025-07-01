package com.gmail.sheepingtoninc.rainbowsheep;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

@Mod(RainbowSheep.MODID)
public class RainbowSheep {
    public static final String MODID = "rainbowsheep";

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredBlock<Block> RAINBOW_WOOL_BLOCK = BLOCKS.register("rainbow_wool", registryName -> new Block(BlockBehaviour.Properties.of()
            .mapColor(MapColor.COLOR_YELLOW)
            .instrument(NoteBlockInstrument.GUITAR)
            .strength(0.8F)
            .sound(SoundType.WOOL)
            .ignitedByLava()
    ));

    public static final Supplier<BlockItem> RAINBOW_WOOL_ITEM = ITEMS.registerSimpleBlockItem("rainbow_wool", RAINBOW_WOOL_BLOCK);


    public RainbowSheep(IEventBus modBus, ModContainer container) {
        BLOCKS.register(modBus);
        ITEMS.register(modBus);
    }
}
