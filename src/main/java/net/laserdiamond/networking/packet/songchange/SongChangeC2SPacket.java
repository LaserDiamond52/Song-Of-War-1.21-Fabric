package net.laserdiamond.networking.packet.songchange;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.item.songs.PrimeSongItem;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.network.ServerPlayerEntity;

public class SongChangeC2SPacket {

    public static void receive(SongChangePayload payload, ServerPlayNetworking.Context context)
    {
        // HAPPENS ON THE SERVER
        final ServerPlayerEntity player = context.player();
        int newSongInt = payload.buf().getNewSongInt();

        if (player.getMainHandStack().getItem() instanceof PrimeSongItem primeSongItem)
        {
            primeSongItem.setSelectedSongSpell(newSongInt, player, player.getMainHandStack());
        } else if (player.getOffHandStack().getItem() instanceof PrimeSongItem primeSongItem)
        {
            primeSongItem.setSelectedSongSpell(newSongInt, player, player.getOffHandStack());
        }
    }

    public static class ByteBuf
    {
        private final int newSongInt;

        public ByteBuf(PacketByteBuf buf) {
            this.newSongInt = buf.readInt();
        }

        private void write(PacketByteBuf buf)
        {
            buf.writeInt(this.newSongInt);
        }

        public static final PacketCodec<PacketByteBuf, ByteBuf> CODEC = PacketCodec.of(ByteBuf::write, ByteBuf::new);

        public int getNewSongInt() {
            return newSongInt;
        }
    }
}
