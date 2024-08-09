package net.laserdiamond.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.SongsOfWar;
import net.laserdiamond.networking.packet.songcast.SongCastC2SPacket;
import net.laserdiamond.networking.packet.songcast.SongCastPayload;
import net.laserdiamond.networking.packet.songchange.SongChangeC2SPacket;
import net.laserdiamond.networking.packet.songchange.SongChangePayload;
import net.laserdiamond.networking.packet.songmanasync.SongManaSyncDataPayload;
import net.laserdiamond.networking.packet.songmanasync.SongManaSyncDataS2CPacket;
import net.minecraft.util.Identifier;

public class SOWMessages {

    public static final Identifier SONG_MANA_SYNC_ID = Identifier.of(SongsOfWar.MOD_ID, "song_mana_sync");
    public static final Identifier SONG_CAST_ID = Identifier.of(SongsOfWar.MOD_ID, "song_cast");
    public static final Identifier SWITCH_SONG_SPELL_ID = Identifier.of(SongsOfWar.MOD_ID, "switch_song_spell");

    public static void registerC2SPackets()
    {
        PayloadTypeRegistry.playC2S().register(SongCastPayload.ID, SongCastPayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(SongCastPayload.ID, SongCastC2SPacket::receive);

        // TODO: Keybinding for switching songs
        PayloadTypeRegistry.playC2S().register(SongChangePayload.ID, SongChangePayload.CODEC);
        ServerPlayNetworking.registerGlobalReceiver(SongChangePayload.ID, SongChangeC2SPacket::receive);
    }

    public static void registerS2CPackets()
    {
        PayloadTypeRegistry.playS2C().register(SongManaSyncDataPayload.ID, SongManaSyncDataPayload.CODEC);
        ClientPlayNetworking.registerGlobalReceiver(SongManaSyncDataPayload.ID, SongManaSyncDataS2CPacket::receive);
    }
}
