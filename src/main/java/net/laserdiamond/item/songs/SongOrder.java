package net.laserdiamond.item.songs;

import java.util.List;

public enum SongOrder {

    AGGRESSIUM (List.of(SongSpell.AGGROBEAM, SongSpell.AGGROSTORM, SongSpell.AGGROQUAKE, SongSpell.AGGROBLAST,SongSpell.AGGROSHARD)),
    MOBILIUM (List.of(SongSpell.MOBILIFLASH, SongSpell.MOBILILEAP, SongSpell.MOBILIWINGS, SongSpell.MOBILIGLIDE)),
    PROTISIUM (List.of(SongSpell.PROTESPHERE, SongSpell.PROTEARMOR, SongSpell.PROTEHEAL)),
    SUPPORIUM (List.of(SongSpell.SUPPOREKESIS, SongSpell.SUPPOROSPIKE));

    private final List<SongOrderSpell> songOrderSpells;

    SongOrder(List<SongOrderSpell> songOrderSpells) {
        this.songOrderSpells = songOrderSpells;
    }

    public List<SongOrderSpell> getSongOrderSpells() {
        return songOrderSpells;
    }

    public SongOrderSpell getSongOrderSpell(int index)
    {
        return songOrderSpells.get(Math.min(Math.max(0, index), songOrderSpells.size() - 1));
    }

    public int getSongCount()
    {
        return this.songOrderSpells.size() + 1;
    }
}
