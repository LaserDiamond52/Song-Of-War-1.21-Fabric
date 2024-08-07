package net.laserdiamond.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SOWLootTableProvider extends FabricBlockLootTableProvider {

    public SOWLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        // Reference video: https://www.youtube.com/watch?v=w8ZAJWNy8Fk&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=13
    }
}
