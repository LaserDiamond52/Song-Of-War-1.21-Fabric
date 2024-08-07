package net.laserdiamond.event;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.laserdiamond.attribute.SOWAttributes;
import net.laserdiamond.util.IEntityDataSaver;
import net.laserdiamond.util.SongManaData;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.HashMap;
import java.util.UUID;

public class PlayerTickHandler implements ServerTickEvents.StartTick {

    private final HashMap<UUID, Integer> playerTimerMap = new HashMap<>();

    @Override
    public void onStartTick(MinecraftServer server)
    {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList())
        {
            UUID playerUUID = player.getUuid();
            if (playerTimerMap.get(playerUUID) == null || !playerTimerMap.containsKey(playerUUID))
            {
                playerTimerMap.put(playerUUID, 0); // If player doesn't have time value, set to 0
            }
            int currentPlayerTimer = playerTimerMap.get(playerUUID);

            playerTimerMap.put(playerUUID, currentPlayerTimer + 1); // Increment by 1 every server tick


            if (playerTimerMap.get(playerUUID) >= 20) // Every 20 ticks
            {
                IEntityDataSaver dataPlayer = ((IEntityDataSaver) player);
                double maxSongMana = player.getAttributeValue(SOWAttributes.SONG_MANA);
                double songManaRegenRate = player.getAttributeValue(SOWAttributes.SONG_MANA_REGEN_RATE);

                double songManaToAdd = maxSongMana * songManaRegenRate;
                SongManaData.addSongMana(player, dataPlayer, songManaToAdd);

                player.sendMessage(Text.literal("Song Mana: " + SongManaData.getSongMana(dataPlayer) + " / " + player.getAttributeValue(SOWAttributes.SONG_MANA)).fillStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE)), true);

                playerTimerMap.put(playerUUID, 0); // Reset back to 0
            }
        }
    }
}
