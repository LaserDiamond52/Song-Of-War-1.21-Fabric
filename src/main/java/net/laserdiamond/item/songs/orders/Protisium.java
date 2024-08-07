package net.laserdiamond.item.songs.orders;

import net.laserdiamond.item.songs.SongOrderSpells;

public enum Protisium implements SongOrderSpells {

    PROTESPHERE("Protesphere", 70),
    PROTEARMOR("Protearmor", 90),
    PROTEHEAL("Proteheal", 50);

    private final String songName;
    private final double manaCost;

    Protisium(String songName, double manaCost) {
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
