package net.denanu.mc_vanille_feature_tweaks.datagen;

import net.denanu.mc_vanille_feature_tweaks.data.recipe.ModRecipeProvider;
import net.denanu.mc_vanille_feature_tweaks.data.tag.ModItemTagProvider;
import net.denanu.mc_vanille_feature_tweaks.datagen.itemModels.ModModelProvider;
import net.denanu.mc_vanille_feature_tweaks.datagen.lang.ModEnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModEnglishLangProvider::new);
	}

}