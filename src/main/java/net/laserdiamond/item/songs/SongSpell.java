package net.laserdiamond.item.songs;

public enum SongSpell implements SongOrderSpell {

    AGGROBEAM ("Aggrobeam", 25),
    AGGROSTORM ("Aggrostorm", 30),
    AGGROQUAKE ("Aggroquake", 80),
    AGGROBLAST ("Aggroblast", 40),
    AGGROSHARD ("Aggroshard", 30),
    MOBILIFLASH ("Aggroshard", 30),
    MOBILILEAP ("Mobilileap", 60),
    MOBILIWINGS ("Mobiliwings", 30),
    MOBILIGLIDE ("Mobiliglide", 60),
    PROTESPHERE ("Protesphere", 75),
    PROTEARMOR ("Protearmor", 90),
    PROTEHEAL ("Proteheal", 50),
    SUPPOREKESIS ("Supporekesis", 35),
    SUPPOROSPIKE ("Supporospike", 70)
    ;

    private final String songName;
    private final double manaCost;

    SongSpell(String songName, double manaCost) {
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
