package net.Byebye007x.firstprotomod.magic;

import net.minecraft.world.entity.player.Player;

public class PlayerMagicUtils {

    // Method to return the player's current MP, with special handling for creative mode
    public static int getEffectiveMp(Player player, PlayerMagic playerMagic) {
        if (player.isCreative()) {
            // Return MAX_MP if the player is in creative mode (infinite mana)
            return playerMagic.getMAX_MP();
        } else {
            // Return the actual MP for non-creative players
            return playerMagic.getMp();
        }
    }

    // Optional: If you want to also handle MP regeneration logic here
    public static void regenerateMp(PlayerMagic playerMagic) {
        int currentMp = playerMagic.getMp();
        playerMagic.addMp(playerMagic.getMpRegen());
    }
}
