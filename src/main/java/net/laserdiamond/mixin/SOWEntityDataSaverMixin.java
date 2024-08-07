package net.laserdiamond.mixin;

import net.laserdiamond.SongsOfWar;
import net.laserdiamond.util.IEntityDataSaver;
import net.laserdiamond.util.SongManaData;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class SOWEntityDataSaverMixin implements IEntityDataSaver {

    @Unique
    private NbtCompound persistentData;

    @Override
    public NbtCompound getPersistentData() {

        if (this.persistentData == null)
        {
            this.persistentData = new NbtCompound();
        }
        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable<?> info)
    {
        if (persistentData != null)
        {
            nbt.put(SongManaData.SONG_MANA_KEY, persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info)
    {
        if (nbt.contains(SongManaData.SONG_MANA_KEY))
        {
            persistentData = nbt.getCompound(SongManaData.SONG_MANA_KEY);
        }
    }
}
