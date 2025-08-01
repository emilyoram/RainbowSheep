package com.gmail.sheepingtoninc.rainbowsheep.item;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RainbowDyeItem extends Item {
    private static final Logger log = LoggerFactory.getLogger(RainbowDyeItem.class);
    private final FlagWool flagWool;

    public RainbowDyeItem(Properties properties, FlagWool flagWool) {
        super(properties);
        this.flagWool = flagWool;
    }

    @Override
    public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity target, InteractionHand hand) {
        if (target instanceof Sheep sheep && sheep.isAlive() && !sheep.isSheared() && this.flagWool.ordinal() != ((IFlagSheep) sheep).rainbowSheep$getFlagWool()) {
            sheep.level().playSound(player, sheep, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
            if (!player.level().isClientSide) {
                ((IFlagSheep) sheep).rainbowSheep$setFlagWool(flagWool.ordinal());
                log.info(((IFlagSheep)sheep).rainbowSheep$getFlagWool() + "");
                stack.shrink(1);
            }

            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }
        return InteractionResult.PASS;
    }
}
