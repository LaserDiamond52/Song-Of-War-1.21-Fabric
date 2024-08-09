package net.laserdiamond.networking.packet.songchange;

import net.laserdiamond.networking.SOWMessages;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;

public record SongChangePayload (SongChangeC2SPacket.ByteBuf buf) implements CustomPayload{

    public static final CustomPayload.Id<SongChangePayload> ID = new CustomPayload.Id<>(SOWMessages.SWITCH_SONG_SPELL_ID);
    public static final PacketCodec<RegistryByteBuf, SongChangePayload> CODEC = PacketCodec.tuple(SongChangeC2SPacket.ByteBuf.CODEC, SongChangePayload::buf, SongChangePayload::new);
    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
