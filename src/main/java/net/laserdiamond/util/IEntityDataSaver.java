package net.laserdiamond.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {

    NbtCompound getPersistentData();
}
