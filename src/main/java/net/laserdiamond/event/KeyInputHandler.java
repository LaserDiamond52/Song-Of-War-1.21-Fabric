package net.laserdiamond.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.laserdiamond.item.songs.PrimeSongItem;
import net.laserdiamond.item.songs.SongItem;
import net.laserdiamond.networking.packet.songcast.SongCastC2SPacket;
import net.laserdiamond.networking.packet.songcast.SongCastPayload;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

import java.util.Objects;

public class KeyInputHandler {

    public static final String SONGS_OF_WAR_KEY_CATEGORY = "key.category.songsofwar";
    public static final String CAST_SONG_KEY = "key.songsofwar.cast_song";
    public static final String SWITCH_SONG_SPELL_KEY_1 = "key.songsofwar.switch_song_spell_1";
    public static final String SWITCH_SONG_SPELL_KEY_2 = "key.songsofwar.switch_song_spell_2";
    public static final String SWITCH_SONG_SPELL_KEY_3 = "key.songsofwar.switch_song_spell_3";
    public static final String SWITCH_SONG_SPELL_KEY_4 = "key.songsofwar.switch_song_spell_4";
    public static final String SWITCH_SONG_SPELL_KEY_5 = "key.songsofwar.switch_song_spell_5";

    public static KeyBinding castSongKey, switchSongSpellKey1, switchSongSpellKey2, switchSongSpellKey3, switchSongSpellKey4, switchSongSpellKey5;

    public static void registerKeyInputs()
    {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // ON CLIENT

            ClientPlayerEntity clientPlayerEntity = Objects.requireNonNull(client.player);
            ItemStack mainHandStack = clientPlayerEntity.getMainHandStack();
            ItemStack offHandStack = clientPlayerEntity.getOffHandStack();

            if (castSongKey.wasPressed())
            {
                // Cast song ability

                if (mainHandStack.getItem() instanceof SongItem songItem) // Mainhand is checked first for a song item
                {
                    castSong(clientPlayerEntity, songItem); // Song item in mainhand. Offhand is ignored
                } else if (offHandStack.getItem() instanceof SongItem songItem) // Offhand is checked next if the mainhand is not a song item
                {
                    castSong(clientPlayerEntity, songItem); // Song item in offhand
                }

            } else if (switchSongSpellKey1.wasPressed())
            {
                // Switch song ability (Prime Song)
                client.player.sendMessage(Text.of("Switch to Song Spell 1"));

                songSelect(mainHandStack, offHandStack, 1);
            } else if (switchSongSpellKey2.wasPressed())
            {
                client.player.sendMessage(Text.of("Switch to Song Spell 2"));

                songSelect(mainHandStack, offHandStack, 2);
            } else if (switchSongSpellKey3.wasPressed())
            {
                client.player.sendMessage(Text.of("Switch to Song Spell 3"));

                songSelect(mainHandStack, offHandStack, 3);
            } else if (switchSongSpellKey4.wasPressed())
            {
                client.player.sendMessage(Text.of("Switch to Song Spell 4"));

                songSelect(mainHandStack, offHandStack, 4);
            } else if (switchSongSpellKey5.wasPressed())
            {
                client.player.sendMessage(Text.of("Switch to Song Spell 5"));

                songSelect(mainHandStack, offHandStack, 5);
            }
        });
    }

    private static void songSelect(ItemStack mainHand, ItemStack offHand, int select)
    {
        if (mainHand.getItem() instanceof PrimeSongItem primeSongItem)
        {
            primeSongItem.setSelectedSongSpell(select);
        } else if (offHand.getItem() instanceof PrimeSongItem primeSongItem)
        {
            primeSongItem.setSelectedSongSpell(select);
        }
    }

    private static void castSong(ClientPlayerEntity clientPlayerEntity, SongItem songItem)
    {
        clientPlayerEntity.sendMessage(Text.of("Cast Song"));
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeDouble(songItem.songManaCost()); // Write song mana cost to PacketByteBuf
        ClientPlayNetworking.send(new SongCastPayload(new SongCastC2SPacket.ByteBuf(buf))); // Send packet from client to server
    }

    public static void register()
    {
        castSongKey = registerKeyboardBinding(CAST_SONG_KEY, GLFW.GLFW_KEY_G);
        switchSongSpellKey1 = registerKeyboardBinding(SWITCH_SONG_SPELL_KEY_1, GLFW.GLFW_KEY_R);
        switchSongSpellKey2 = registerKeyboardBinding(SWITCH_SONG_SPELL_KEY_2, GLFW.GLFW_KEY_T);
        switchSongSpellKey3 = registerKeyboardBinding(SWITCH_SONG_SPELL_KEY_3, GLFW.GLFW_KEY_X);
        switchSongSpellKey4 = registerKeyboardBinding(SWITCH_SONG_SPELL_KEY_4, GLFW.GLFW_KEY_C);
        switchSongSpellKey5 = registerKeyboardBinding(SWITCH_SONG_SPELL_KEY_5, GLFW.GLFW_KEY_V);

        registerKeyInputs();
    }

    private static KeyBinding registerKeyboardBinding(String key, int code)
    {
        return KeyBindingHelper.registerKeyBinding(new KeyBinding(key, InputUtil.Type.KEYSYM, code, SONGS_OF_WAR_KEY_CATEGORY));
    }
}
