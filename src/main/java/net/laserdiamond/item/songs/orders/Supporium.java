package net.laserdiamond.item.songs.orders;

import net.laserdiamond.item.songs.SongOrderSpells;

public enum Supporium implements SongOrderSpells {

    SUPPOREKESIS("Supporekesis", 35),
    SUPPOROSPIKE("Supporospike", 70);

    private final String songName;
    private final double manaCost;

    Supporium(String songName, double manaCost) {
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