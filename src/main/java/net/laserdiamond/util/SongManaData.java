package net.laserdiamond.util;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.SongsOfWar;
import net.laserdiamond.attribute.SOWAttributes;
import net.laserdiamond.networking.packet.songmanasync.SongManaSyncDataPayload;
import net.laserdiamond.networking.packet.songmanasync.SongManaSyncDataS2CPacket;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class SongManaData {

    public static final String SONG_MANA_KEY = SongsOfWar.MOD_ID + ".song_mana";

    /**
     * Adds to the {@link ServerPlayerEntity}'s Song Mana
     * @param player The {@link ServerPlayerEntity}
     * @param playerDataSaver The player's {@link IEntityDataSaver}
     * @param amount The amount to add. If the amount to add is greater than the {@link ServerPlayerEntity}'s Song Mana attribute value, their Song Mana will be set to their max
     * @return The Song Mana after the addition
     */
    public static double addSongMana(ServerPlayerEntity player, IEntityDataSaver playerDataSaver, double amount)
    {
        NbtCompound nbt = playerDataSaver.getPersistentData();
        double songMana = nbt.getDouble("song_mana");

        double maxSongMana = player.getAttributeValue(SOWAttributes.SONG_MANA);

        songMana = Math.min(Math.max(0, songMana + amount), maxSongMana);

        nbt.putDouble("song_mana", songMana);
        syncSongMana(songMana, player);
        return songMana;
    }

    /**
     * Removes from the {@link ServerPlayerEntity}'s Song Mana
     * @param player The {@link ServerPlayerEntity}
     * @param playerDataSaver The player's {@link IEntityDataSaver}
     * @param amount The amount to subtract. If the amount to subtract results in a Song Mana value less than 0, the player's current Song Mana will be set to 0. If the amount to remove is greater than the player's max Song Mana, their current Song Mana will be set to 0
     * @return The Song Mana after the subtraction
     */
    public static double removeSongMana(ServerPlayerEntity player, IEntityDataSaver playerDataSaver, double amount)
    {
        NbtCompound nbt = playerDataSaver.getPersistentData();
        double songMana = nbt.getDouble("song_mana");

        double maxSongMana = player.getAttributeValue(SOWAttributes.SONG_MANA);

        songMana = Math.max(0, songMana - Math.min(maxSongMana, amount));

        nbt.putDouble("song_mana", songMana);
        syncSongMana(songMana, player);
        return songMana;
    }

    /**
     * Gets the player's current Song Mana
     * @param playerDataSaver The {@link IEntityDataSaver} player
     * @return The player's current Song Mana
     */
    public static double getSongMana(IEntityDataSaver playerDataSaver)
    {
        return playerDataSaver.getPersistentData().getDouble("song_mana");
    }

    /**
     * Syncs the player's song mana from the server to the client by sending a packet from the server
     * @param songMana The player's current song mana
     * @param player The {@link ServerPlayerEntity}
     */
    public static void syncSongMana(double songMana, ServerPlayerEntity player)
    {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeDouble(songMana);
        ServerPlayNetworking.send(player, new SongManaSyncDataPayload(new SongManaSyncDataS2CPacket.ByteBuf(buf)));
    }

}
