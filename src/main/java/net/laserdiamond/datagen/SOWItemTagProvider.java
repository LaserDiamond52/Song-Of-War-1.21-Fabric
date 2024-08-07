package net.laserdiamond.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.laserdiamond.item.SOWItems;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SOWItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public SOWItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        for (Item item : SOWItems.REGISTERED_ITEMS.values())
        {
            addSwordTags(item);
            addPickaxeTags(item);
            addAxeTags(item);
            addShovelTags(item);
            addHoeTags(item);
            addArmorTags(item);
        }
    }

    private void addSwordTags(Item item)
    {
        if (item instanceof SwordItem)
        {
            tagItem(ItemTags.SWORDS, item);
            tagItem(ItemTags.SWORD_ENCHANTABLE, item);
        }
    }

    private void addPickaxeTags(Item item)
    {
        if (item instanceof PickaxeItem)
        {
            tagItem(ItemTags.PICKAXES, item);
            tagItem(ItemTags.MINING_ENCHANTABLE, item);
        }
    }

    private void addAxeTags(Item item)
    {
        if (item instanceof AxeItem)
        {
            tagItem(ItemTags.AXES, item);
            tagItem(ItemTags.MINING_ENCHANTABLE, item);
            tagItem(ItemTags.SHARP_WEAPON_ENCHANTABLE, item);
        }
    }

    private void addShovelTags(Item item)
    {
        if (item instanceof ShovelItem)
        {
            tagItem(ItemTags.SHOVELS, item);
            tagItem(ItemTags.MINING_ENCHANTABLE, item);
        }
    }

    private void addHoeTags(Item item)
    {
        if (item instanceof HoeItem hoeItem)
        {
            tagItem(ItemTags.HOES, hoeItem);
            tagItem(ItemTags.MINING_ENCHANTABLE, hoeItem);
        }
    }

    private void addArmorTags(Item item)
    {
        if (item instanceof ArmorItem armorItem)
        {
            tagItem(ItemTags.TRIMMABLE_ARMOR, armorItem);
            switch (armorItem.getType())
            {
                case HELMET -> {
                    tagItem(ItemTags.HEAD_ARMOR, armorItem);
                    tagItem(ItemTags.HEAD_ARMOR_ENCHANTABLE, armorItem);
                }
                case CHESTPLATE -> {
                    tagItem(ItemTags.CHEST_ARMOR, armorItem);
                    tagItem(ItemTags.CHEST_ARMOR_ENCHANTABLE, armorItem);
                }
                case LEGGINGS -> {
                    tagItem(ItemTags.LEG_ARMOR, armorItem);
                    tagItem(ItemTags.LEG_ARMOR_ENCHANTABLE, armorItem);
                }
                case BOOTS -> {
                    tagItem(ItemTags.FOOT_ARMOR, armorItem);
                    tagItem(ItemTags.FOOT_ARMOR_ENCHANTABLE, armorItem);
                }
            }
        }
    }


    @SafeVarargs
    private <T extends Item> void tagItem(TagKey<Item> itemTagKey, T... items)
    {
        this.getOrCreateTagBuilder(itemTagKey).add(items);
    }
}
