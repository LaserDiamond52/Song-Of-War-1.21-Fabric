package net.laserdiamond.item;

import net.laserdiamond.SongsOfWar;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class SOWArmorMaterials {

    // Mobilium Song Clan
    public static final RegistryEntry<ArmorMaterial> SENDARIS = register("sendaris",
            Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 8, ArmorItem.Type.LEGGINGS, 6, ArmorItem.Type.BOOTS, 3),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(),
            3F,
            0.1F,
            false
    );

    // Supporium Song Clan
    public static final RegistryEntry<ArmorMaterial> KALTARIS = register("kaltaris",
            Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 8, ArmorItem.Type.LEGGINGS, 6, ArmorItem.Type.BOOTS, 3),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(),
            3F,
            0.1F,
            false
    );

    //
    public static final RegistryEntry<ArmorMaterial> VOLTARIS = register("voltaris",
            Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 8, ArmorItem.Type.LEGGINGS, 6, ArmorItem.Type.BOOTS, 3),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(),
            3F,
            0.1F,
            false
    );

    // Aggressium Song Clan
    public static final RegistryEntry<ArmorMaterial> NESTORIS = register("nestoris",
            Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 8, ArmorItem.Type.LEGGINGS, 6, ArmorItem.Type.BOOTS, 3),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(),
            3F,
            0.1F,
            false
    );

    // Protisium Song Clan
    public static final RegistryEntry<ArmorMaterial> MENDORIS = register("mendoris",
            Map.of(ArmorItem.Type.HELMET, 3, ArmorItem.Type.CHESTPLATE, 8, ArmorItem.Type.LEGGINGS, 6, ArmorItem.Type.BOOTS, 3),
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(),
            3F,
            0.1F,
            false
    );

    public static RegistryEntry<ArmorMaterial> register(String name, Map<ArmorItem.Type, Integer> armorPoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredients, float toughness, float knockbackResistance, boolean dyable)
    {
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(Identifier.of(SongsOfWar.MOD_ID, name), "", dyable));

        var material = new ArmorMaterial(armorPoints, enchantability, equipSound, repairIngredients, layers, toughness, knockbackResistance);

        material = Registry.register(Registries.ARMOR_MATERIAL, SongsOfWar.MOD_ID, material);

        return RegistryEntry.of(material);
    }
}
