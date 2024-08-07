package net.laserdiamond.attribute;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.laserdiamond.SongsOfWar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class SOWAttributes {

    /**
     * {@link EntityAttribute} the {@link PlayerEntity} uses to determine the strength of their song abilities
     */
    public static final RegistryEntry<EntityAttribute> SONG_POWER = registerAttribute("player.song_power", new ClampedEntityAttribute("attribute.name.player.song_power", 1, 0, 1024));

    /**
     * {@link EntityAttribute} the {@link PlayerEntity} uses to determine their mana for their songs
     */
    public static final RegistryEntry<EntityAttribute> SONG_MANA = registerAttribute("player.song_mana", new ClampedEntityAttribute("attribute.name.player.song_mana", 100, 0.0, 1024).setTracked(true));

    /**
     * {@link EntityAttribute} the {@link PlayerEntity} uses to determine their song mana regeneration rate
     */
    public static final RegistryEntry<EntityAttribute> SONG_MANA_REGEN_RATE = registerAttribute("player.song_mana_regen_rate", new ClampedEntityAttribute("attribute.name.player.song_mana_regen_rate", 0.025, 0.0, 1));

    /**
     * Registers the {@link EntityAttribute} to the Attribute {@link Registries}
     * @param name The name of the {@link EntityAttribute}
     * @param attribute The {@link EntityAttribute}
     * @return A {@link RegistryEntry} of type {@link EntityAttribute}
     */
    private static RegistryEntry<EntityAttribute> registerAttribute(String name, EntityAttribute attribute)
    {
        return Registry.registerReference(Registries.ATTRIBUTE, Identifier.of(SongsOfWar.MOD_ID, name), attribute);
    }

    public static void registerAttributes()
    {
        SongsOfWar.LOGGER.info("Registering Attributes for " + SongsOfWar.MOD_ID);

        FabricDefaultAttributeRegistry.register(EntityType.PLAYER,
                PlayerEntity.createPlayerAttributes()
                        .add(SONG_POWER,1)
                        .add(SONG_MANA,100)
                        .add(SONG_MANA_REGEN_RATE, 0.025)
        );
    }
}
