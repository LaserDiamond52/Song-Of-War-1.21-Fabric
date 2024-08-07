package net.laserdiamond.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class SOWBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public SOWBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Reference video: https://www.youtube.com/watch?v=w8ZAJWNy8Fk&list=PLKGarocXCE1EO43Dlf5JGh7Yk-kRAXUEJ&index=13
    }
}
