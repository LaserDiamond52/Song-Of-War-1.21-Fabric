package net.laserdiamond.item.songs;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

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
    public void onSongCast(ServerPlayNetworking.Context context) {

    }

    public int getSongCount()
    {
        List<SongOrderSpell> songs = songOrder.getSongOrderSpells();
        return songs.size() + 1;
    }

}
