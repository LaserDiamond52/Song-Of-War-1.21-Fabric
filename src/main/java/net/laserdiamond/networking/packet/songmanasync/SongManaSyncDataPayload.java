package net.laserdiamond.networking.packet.songmanasync;

import net.laserdiamond.networking.SOWMessages;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record SongManaSyncDataPayload(SongManaSyncDataS2CPacket.ByteBuf buf) implements CustomPayload {

    public static final CustomPayload.Id<SongManaSyncDataPayload> ID = new CustomPayload.Id<>(SOWMessages.SONG_MANA_SYNC_ID);
    public static final PacketCodec<RegistryByteBuf, SongManaSyncDataPayload> CODEC = PacketCodec.tuple(SongManaSyncDataS2CPacket.ByteBuf.CODEC, SongManaSyncDataPayload::buf, SongManaSyncDataPayload::new);

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
