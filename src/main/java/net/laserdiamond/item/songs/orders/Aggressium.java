package net.laserdiamond.item.songs.orders;

import net.laserdiamond.item.songs.SongOrderSpells;

public enum Aggressium implements SongOrderSpells {

    AGGROBEAM ("Aggrobeam", 25),
    AGGROSTORM ("Aggrostorm", 30),
    AGGROQUAKE ("Aggroquake", 80),
    AGGROBLAST ("Aggroblast", 40),
    AGGROSHARD ("Aggroshard", 30);

    private final String songName;
    private final double manaCost;

    Aggressium(String songName, double manaCost) {
        this.songName = songName;
        this.manaCost = manaCost;
    }

    @Override
    public String getSongName() {
        return songName;
    }

    @Override
    public int getSongSlot() {
        return this.ordinal() + 1;
    }

    @Override
    public double getManaCost() {
        return manaCost;
    }
}
