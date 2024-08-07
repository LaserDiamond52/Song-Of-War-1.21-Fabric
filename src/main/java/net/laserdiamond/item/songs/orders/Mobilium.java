package net.laserdiamond.item.songs.orders;

import net.laserdiamond.item.songs.SongOrderSpells;

public enum Mobilium implements SongOrderSpells {

    MOBILIFLASH("Mobiliflash", 30),
    MOBILILEAP("Mobilileap", 60),
    MOBILIWINGS("Mobiliwings", 75),
    MOBILIGLIDE("Mobiliglide", 40);

    private final String songName;
    private final double manaCost;

    Mobilium(String songName, double manaCost) {
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
