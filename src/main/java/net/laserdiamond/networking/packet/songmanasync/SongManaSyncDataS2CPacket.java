package net.laserdiamond.networking.packet.songmanasync;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.laserdiamond.util.IEntityDataSaver;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;

public class SongManaSyncDataS2CPacket {

    public static void receive(SongManaSyncDataPayload payload, ClientPlayNetworking.Context context)
    {
        ((IEntityDataSaver) context.client().player).getPersistentData().putDouble("song_mana", payload.buf().getSongManaAmount());
    }

    public static class ByteBuf
    {
        private final double songManaAmount;

        public ByteBuf(PacketByteBuf buf) {
            this.songManaAmount = buf.readDouble();
        }

        private void write(PacketByteBuf buf)
        {
            buf.writeDouble(this.songManaAmount);
        }

        public static final PacketCodec<PacketByteBuf, ByteBuf> CODEC = PacketCodec.of(ByteBuf::write, ByteBuf::new);

        public double getSongManaAmount() {
            return songManaAmount;
        }
    }

}
