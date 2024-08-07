package net.laserdiamond;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.laserdiamond.datagen.*;

public class SongsOfWarDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator)
	{
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(SOWBlockTagProvider::new);
		pack.addProvider(SOWItemTagProvider::new);
		pack.addProvider(SOWLootTableProvider::new);
		pack.addProvider(SOWModelProvider::new);
		pack.addProvider(SOWRecipeProvider::new);
	}
}
