package net.laserdiamond.item.songs.prime;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.item.songs.PrimeSongItem;
import net.laserdiamond.item.songs.SongOrder;
import net.laserdiamond.item.songs.SongOrderSpell;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class AggressiumPrimeSongItem extends PrimeSongItem {

    public AggressiumPrimeSongItem(Settings settings) {
        super(settings, SongOrder.AGGRESSIUM);
    }

    @Override
    public void onSongCast(ServerPlayNetworking.Context context)
    {
        final PlayerEntity playerEntity = context.player();
        Integer songInt = this.getStoredSongSpell(playerEntity);
        SongOrderSpell songOrderSpell = this.getSongOrder().getSongOrderSpell(songInt);

        playerEntity.sendMessage(Text.of(songOrderSpell.getSongName()));

        String s;
        switch (songInt)
        {
            case 0:
                s = "No Spell Set";
                break;
            case 1:
                // TODO: Aggrobeam
                s = "Spell 1";
                break;
            case 2:
                // TODO: Aggrostorm
                s = "Spell 2";
                break;
            case 3:
                // TODO: Aggroquake
                s = "Spell 3";
                break;
            case 4:
                // TODO: Aggroblast
                s = "Spell 4";
                break;
            case 5:
                // TODO: Aggroshard
                s = "Spell 5";
                break;
            default:
                throw new IllegalArgumentException("No spell for integer: " + songInt);

        }

        playerEntity.sendMessage(Text.of(s));
    }
}
