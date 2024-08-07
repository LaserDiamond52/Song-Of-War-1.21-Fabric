package net.laserdiamond.item.songs;

public interface SongOrderSpells {

    /**
     * Gets the name of the Song
     * @return The name of the Song
     */
    String getSongName();

    /**
     * Gets the slot of the Song in a Prime Song
     * @return The slot of the Song in a Prime Song
     */
    int getSongSlot();

    /**
     * Gets the mana cost of the Song
     * @return The mana cost of the Song
     */
    double getManaCost();
}
