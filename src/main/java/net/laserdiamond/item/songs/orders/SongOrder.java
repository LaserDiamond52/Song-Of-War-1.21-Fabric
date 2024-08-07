package net.laserdiamond.item.songs.orders;

import net.laserdiamond.item.songs.SongOrderSpells;

import java.util.List;

public enum SongOrder {

    AGGRESSIUM (List.of(Aggressium.AGGROBEAM, Aggressium.AGGROSTORM, Aggressium.AGGROQUAKE, Aggressium.AGGROSHARD)),
    MOBILIUM (List.of(Mobilium.MOBILIFLASH, Mobilium.MOBILILEAP, Mobilium.MOBILIWINGS, Mobilium.MOBILIGLIDE)),
    PROTISIUM (List.of(Protisium.PROTESPHERE, Protisium.PROTEARMOR, Protisium.PROTEHEAL)),
    SUPPORIUM (List.of(Supporium.SUPPOREKESIS, Supporium.SUPPOROSPIKE));

    private final List<SongOrderSpells> songOrderSpells;

    SongOrder(List<SongOrderSpells> songOrderSpells) {
        this.songOrderSpells = songOrderSpells;
    }

    public List<SongOrderSpells> getSongOrderSpells() {
        return songOrderSpells;
    }

    public SongOrderSpells getSongOrderSpell(int index)
    {
        return songOrderSpells.get(Math.min(Math.max(0, index), songOrderSpells.size() - 1));
    }
}
