package net.laserdiamond.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.laserdiamond.item.SOWItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;

public class SOWModelProvider extends FabricModelProvider {

    public SOWModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // Reference video: https://www.youtube.com/watch?v=w8ZAJWNy8Fk&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=13
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Reference video: https://www.youtube.com/watch?v=w8ZAJWNy8Fk&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=13

        for (Item item : SOWItems.REGISTERED_ITEMS.values())
        {
            if (item instanceof ToolItem)
            {
                itemModelGenerator.register(item, Models.HANDHELD);
            } else if (item instanceof ArmorItem armorItem)
            {
                itemModelGenerator.registerArmor(armorItem);
            }
        }
    }
}
