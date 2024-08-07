package net.laserdiamond.item.songs;

import net.laserdiamond.item.songs.orders.SongOrder;

import java.util.List;

public abstract class PrimeSongItem extends SongItem {

    public PrimeSongItem(Settings settings, SongOrder songOrder) {
        super(settings, songOrder);
    }

    public void setSelectedSongSpell(int songSpell)
    {
        // TODO: Fires when user pressed song select key, and sets the Song on the item (set nbt on item)
    }

    @Override
    public void onSongCast() {

    }

    public int getSongCount()
    {
        List<SongOrderSpells> songs = songOrder.getSongOrderSpells();
        return songs.size() + 1;
    }

}
