package net.laserdiamond.item.songs;

import net.laserdiamond.item.components.SOWComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

public abstract class PrimeSongItem extends SongItem {

    public PrimeSongItem(Settings settings, SongOrder songOrder) {
        super(settings, songOrder);
    }

    public void setSelectedSongSpell(int songSpell, PlayerEntity playerEntity, ItemStack itemStack)
    {
        // TODO: Fires when user pressed song select key, and sets the Song on the item (set nbt on item)

        itemStack.set(SOWComponents.SONG_SPELL, songSpell);
        playerEntity.sendMessage(Text.of("Set Song Spell to Song " + songSpell));
    }

}
