package net.laserdiamond.item.songs.singular;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.item.songs.SongItem;
import net.laserdiamond.item.songs.SongOrder;

public class AggressiumSongItem extends SongItem {

    public AggressiumSongItem(Settings settings, SongOrder songOrder) {
        super(settings, songOrder);
    }

    @Override
    public void onSongCast(ServerPlayNetworking.Context context)
    {

    }
}
