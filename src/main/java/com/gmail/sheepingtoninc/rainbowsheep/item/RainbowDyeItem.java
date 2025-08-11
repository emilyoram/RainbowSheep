package com.gmail.sheepingtoninc.rainbowsheep.item;

import com.gmail.sheepingtoninc.rainbowsheep.RainbowSheep;
import com.gmail.sheepingtoninc.rainbowsheep.api.FlagWool;
import com.gmail.sheepingtoninc.rainbowsheep.api.IFlagSheep;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class RainbowDyeItem extends Item {
    private final FlagWool flagWool;

    public RainbowDyeItem(Properties properties, FlagWool flagWool) {
        super(properties);
        this.flagWool = flagWool;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof Sheep sheep && sheep.isAlive() && !sheep.isSheared() && this.flagWool.ordinal() != ((IFlagSheep) sheep).rainbowSheep$getFlagWool()) {
            sheep.level().playSound(player, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
            ((IFlagSheep) sheep).rainbowSheep$setFlagWool(flagWool.ordinal());
            if (!player.level().isClientSide) {
                RainbowSheep.LOGGER.info("Current flag int is " + sheep.getData(RainbowSheep.FLAG));
                stack.shrink(1);
            }

            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }
        return InteractionResult.PASS;
    }
}
