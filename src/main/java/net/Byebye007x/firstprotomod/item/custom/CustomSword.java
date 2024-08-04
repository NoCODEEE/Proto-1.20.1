package net.Byebye007x.firstprotomod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingSwapItemsEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadLocalRandom;

public class CustomSword extends SwordItem {
    public CustomSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, @NotNull InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        if (!pLevel.isClientSide) {
            int numArrows = ThreadLocalRandom.current().nextInt(1, 5);

            for (int i = 0; i <= numArrows; i++){
                Arrow arrow = new Arrow(pLevel, pPlayer);
                arrow.shootFromRotation(pPlayer, pPlayer.getXRot(), pPlayer.getYRot(), 0.0F, 5.0f, 1.0F);
                arrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;

                pLevel.addFreshEntity(arrow);
                pLevel.playSound(null, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(),
                        SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);


                itemstack.hurtAndBreak(1, pPlayer, (p) -> {
                    p.broadcastBreakEvent(pUsedHand);
                });
            }
        }

        pPlayer.swing(pUsedHand);
        pPlayer.getCooldowns().addCooldown(this, 20); // 1 second cooldown

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
    }
}