package net.laserdiamond.networking.packet.songcast;

import net.laserdiamond.networking.SOWMessages;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record SongCastPayload(SongCastC2SPacket.ByteBuf buf) implements CustomPayload {

    public static final CustomPayload.Id<SongCastPayload> ID = new CustomPayload.Id<>(SOWMessages.SONG_CAST_ID);
    public static final PacketCodec<RegistryByteBuf, SongCastPayload> CODEC = PacketCodec.tuple(SongCastC2SPacket.ByteBuf.CODEC, SongCastPayload::buf, SongCastPayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
