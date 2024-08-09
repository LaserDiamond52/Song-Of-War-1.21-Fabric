package net.laserdiamond.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.laserdiamond.SongsOfWar;
import net.laserdiamond.item.songs.SongItem;
import net.laserdiamond.item.songs.prime.AggressiumPrimeSongItem;
import net.laserdiamond.item.songs.singular.AggressiumSongItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class SOWItems {

    public static final HashMap<String, Item> REGISTERED_ITEMS = new HashMap<>();


    public static final SwordItem NETHER_BLADE = registerItem("nether_blade", new SwordItem(SOWToolMaterial.NETHER,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(SOWToolMaterial.NETHER, 5, -2.4F)).fireproof()));

    public static final SwordItem ENDER_BLADE = registerItem("ender_blade", new SwordItem(SOWToolMaterial.ENDER,
            new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(SOWToolMaterial.ENDER, 5, -2.4f)).fireproof()));

    public static final ArdoniArmorItem SENDARIS_HELMET = registerItem("sendaris_helmet", new ArdoniArmorItem(SOWArmorMaterials.SENDARIS, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem SENDARIS_CHESTPLATE = registerItem("sendaris_chestplate", new ArdoniArmorItem(SOWArmorMaterials.SENDARIS, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem SENDARIS_LEGGINGS = registerItem("sendaris_leggings", new ArdoniArmorItem(SOWArmorMaterials.SENDARIS, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem SENDARIS_BOOTS = registerItem("sendaris_boots", new ArdoniArmorItem(SOWArmorMaterials.SENDARIS, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem KALTARIS_HELMET = registerItem("kaltaris_helmet", new ArdoniArmorItem(SOWArmorMaterials.KALTARIS, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem KALTARIS_CHESTPLATE = registerItem("kaltaris_chestplate", new ArdoniArmorItem(SOWArmorMaterials.KALTARIS, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem KALTARIS_LEGGINGS = registerItem("kaltaris_leggings", new ArdoniArmorItem(SOWArmorMaterials.KALTARIS, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem KALTARIS_BOOTS = registerItem("kaltaris_boots", new ArdoniArmorItem(SOWArmorMaterials.KALTARIS, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem VOLTARIS_HELMET = registerItem("voltaris_helmet", new ArdoniArmorItem(SOWArmorMaterials.VOLTARIS, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem VOLTARIS_CHESTPLATE = registerItem("voltaris_chestplate", new ArdoniArmorItem(SOWArmorMaterials.VOLTARIS, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem VOLTARIS_LEGGINGS = registerItem("voltaris_leggings", new ArdoniArmorItem(SOWArmorMaterials.VOLTARIS, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem VOLTARIS_BOOTS = registerItem("voltaris_boots", new ArdoniArmorItem(SOWArmorMaterials.VOLTARIS, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem NESTORIS_HELMET = registerItem("nestoris_helmet", new ArdoniArmorItem(SOWArmorMaterials.NESTORIS, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem NESTORIS_CHESTPLATE = registerItem("nestoris_chestplate", new ArdoniArmorItem(SOWArmorMaterials.NESTORIS, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem NESTORIS_LEGGINGS = registerItem("nestoris_leggings", new ArdoniArmorItem(SOWArmorMaterials.NESTORIS, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem NESTORIS_BOOTS = registerItem("nestoris_boots", new ArdoniArmorItem(SOWArmorMaterials.NESTORIS, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem MENDORIS_HELMET = registerItem("mendoris_helmet", new ArdoniArmorItem(SOWArmorMaterials.MENDORIS, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem MENDORIS_CHESTPLATE = registerItem("mendoris_chestplate", new ArdoniArmorItem(SOWArmorMaterials.MENDORIS, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem MENDORIS_LEGGINGS = registerItem("mendoris_leggings", new ArdoniArmorItem(SOWArmorMaterials.MENDORIS, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(40)), 40, 0, 5));

    public static final ArdoniArmorItem MENDORIS_BOOTS = registerItem("mendoris_boots", new ArdoniArmorItem(SOWArmorMaterials.MENDORIS, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(40)), 40, 0, 5));


    // TODO: Songs to make (Prime variant includes all the spells):

    // Additionally, there should be an item that represents a random song (for each category),
    // which when clicked on, turns into one of the following songs from said category. This is
    // the craftable variant

    public static final AggressiumSongItem AGGRESSIUM_SONG = registerItem("aggressium_song", new AggressiumSongItem(new Item.Settings()));

    public static final AggressiumPrimeSongItem AGGRESSIUM_PRIME_SONG = registerItem("aggressium_prime_song", new AggressiumPrimeSongItem(new Item.Settings()));

    // Aggressium:
    /*
        Aggrobeam
        Aggrostorm
        Aggroquake
        Aggroblast
        Aggroshard
     */

    // Mobilium:
    /*
        Mobiliflash
        Mobilileap
        Mobiliwings
        Mobiliglide
     */

    // Protisium:
    /*
        Protesphere
        Protearmor
        Proteheal
     */

    // Supporium:
    /*
        Supporekesis
        Supporospike
     */

    private static <T extends Item> T registerItem(String name, T item)
    {
        REGISTERED_ITEMS.put(name, item);
        return Registry.register(Registries.ITEM, Identifier.of(SongsOfWar.MOD_ID, name), item);
    }

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries)
    {
        //entries.add(TEST_ITEM);
    }

    private static void addItemsToCombatTabItemGroup(FabricItemGroupEntries entries)
    {
        for (Item item : REGISTERED_ITEMS.values())
        {
            if (item instanceof SwordItem)
            {
                entries.add(item);
            } else if (item instanceof ArmorItem)
            {
                entries.add(item);
            } else if (item instanceof SongItem)
            {
                entries.add(item);
            }
        }
    }

    public static void registerItems()
    {
        SongsOfWar.LOGGER.info("Registering Items for " + SongsOfWar.MOD_ID);
        for (Item item : REGISTERED_ITEMS.values())
        {
            SongsOfWar.LOGGER.info("Registered Item: " + item);
        }

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(SOWItems::addItemsToIngredientTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(SOWItems::addItemsToCombatTabItemGroup);

    }
}
