package net.laserdiamond.item;

import com.google.common.base.Suppliers;
import net.laserdiamond.SongsOfWar;
import net.laserdiamond.attribute.SOWAttributes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.function.Supplier;

public class ArdoniArmorItem extends ArmorItem {

    private final Supplier<AttributeModifiersComponent> attributeModifiers;

    public ArdoniArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings, double songMana, double songManaRegen, double songPower) {
        super(material, type, settings);
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    int protection = material.value().getProtection(type);
                    float toughness = material.value().toughness();
                    AttributeModifiersComponent.Builder builder = AttributeModifiersComponent.builder();
                    AttributeModifierSlot attributeModifierSlot = AttributeModifierSlot.forEquipmentSlot(type.getEquipmentSlot());
                    Identifier identifier = Identifier.of(SongsOfWar.MOD_ID + "armor." + type.getName());
                    builder.add(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(identifier, protection, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot)
                            .add(EntityAttributes.GENERIC_ARMOR_TOUGHNESS, new EntityAttributeModifier(identifier, toughness, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot)
                            .add(SOWAttributes.SONG_MANA, new EntityAttributeModifier(identifier, songMana, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot)
                            .add(SOWAttributes.SONG_MANA_REGEN_RATE, new EntityAttributeModifier(identifier, songManaRegen, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot)
                            .add(SOWAttributes.SONG_POWER, new EntityAttributeModifier(identifier, songPower * 0.01, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE), attributeModifierSlot)
                    ;
                    float kbRes = material.value().knockbackResistance();
                    if (kbRes > 0.0F)
                    {
                        builder.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, new EntityAttributeModifier(identifier, kbRes, EntityAttributeModifier.Operation.ADD_VALUE), attributeModifierSlot);
                    }

                    return builder.build();
                }
        );
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {
        return this.attributeModifiers.get();
    }
}
