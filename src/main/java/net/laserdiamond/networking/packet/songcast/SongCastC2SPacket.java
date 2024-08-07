package net.laserdiamond.networking.packet.songcast;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.laserdiamond.item.songs.SongItem;
import net.laserdiamond.util.IEntityDataSaver;
import net.laserdiamond.util.SongManaData;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.server.network.ServerPlayerEntity;

public class SongCastC2SPacket {

    public static void receive(SongCastPayload payload, ServerPlayNetworking.Context context)
    {
        // HAPPENS ON THE SERVER
        ServerPlayerEntity player = context.player();

        if (player.getInventory().getMainHandStack().getItem() instanceof SongItem songItem)
        {
            if (SongManaData.getSongMana((IEntityDataSaver) player) >= payload.buf().getSongManaAmount())
            {
                SongManaData.removeSongMana(player, ((IEntityDataSaver) player), payload.buf().getSongManaAmount());
                songItem.onSongCast();
            }
        }
    }

    public static class ByteBuf
    {
        private final double songManaAmount;

        public ByteBuf(PacketByteBuf buf)
        {
            this.songManaAmount = buf.readDouble();
        }

        private void write(PacketByteBuf buf)
        {
            buf.writeDouble(this.songManaAmount);
        }

        public static final PacketCodec<PacketByteBuf, ByteBuf> CODEC = PacketCodec.of(ByteBuf::write, ByteBuf::new);

        public double getSongManaAmount()
        {
            return this.songManaAmount;
        }
    }
}
