package net.laserdiamond.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SOWRecipeProvider extends FabricRecipeProvider {

    public SOWRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // Reference video: https://www.youtube.com/watch?v=w8ZAJWNy8Fk&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=13
    }
}
