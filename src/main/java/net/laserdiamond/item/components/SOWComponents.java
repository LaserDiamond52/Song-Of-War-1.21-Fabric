package net.laserdiamond.item.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.PrimitiveCodec;
import net.laserdiamond.SongsOfWar;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SOWComponents {

    public static final ComponentType<Integer> SONG_SPELL = register("song_spell", Codec.INT);

    public static <T> ComponentType<T> register(String name, PrimitiveCodec<T> codec)
    {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(SongsOfWar.MOD_ID, name), ComponentType.<T>builder().codec(codec).build());
    }

    public static void initialize()
    {
        SongsOfWar.LOGGER.info("Registering item components");
    }
}
