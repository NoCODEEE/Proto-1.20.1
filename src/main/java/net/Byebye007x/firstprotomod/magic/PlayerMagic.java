package net.Byebye007x.firstprotomod.magic;

import net.minecraft.world.entity.player.Player;
import net.minecraft.nbt.CompoundTag;

public class PlayerMagic {
    private int mp;
    private int MAX_MP = 10;
    private final int MIN_MP = 0;
    private int mp_regen = 1;

    public void setMp(int newMp) {
        this.mp = newMp;
    }

    public void setMAX_MP(int newMaxMp) {
        this.MAX_MP = newMaxMp;
    }

    public void setMpRegen(int newMpRegen) {
        this.mp_regen = newMpRegen;
    }

    public int getMp() {
        return mp;
    }

    public int getMAX_MP() {
        return MAX_MP;
    }

    public int getMpRegen() {
        return mp_regen;
    }

    public void addMp(int add) {
        this.mp = Math.min(mp + add, MAX_MP);
    }

    public void subMp(int sub) {
        this.mp = Math.max(mp - sub, MIN_MP);
    }

    public void copyFrom(PlayerMagic source) {
        this.mp = source.mp;
        this.MAX_MP = source.MAX_MP;
        this.mp_regen = source.mp_regen;
    }

    public void saveNBTData(CompoundTag nbt) {
        nbt.putInt("playerMp", mp);
        nbt.putInt("playerMaxMp", MAX_MP);
        nbt.putInt("playerMpRegen", mp_regen);
    }

    public void loadNBTData(CompoundTag nbt) {
        this.mp = nbt.getInt("playerMp");
        this.MAX_MP = nbt.getInt("playerMaxMp");
        this.mp_regen = nbt.getInt("playerMpRegen");
    }
}
