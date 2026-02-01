package net.denanu.mc_vanille_feature_tweaks.datagen.lang;

import java.util.concurrent.CompletableFuture;

import io.github.cdimascio.dotenv.Dotenv;
import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import com.crowdin.client.Client;
import com.crowdin.client.core.model.Credentials;

public class ModEnglishLangProvider extends FabricLanguageProvider {
	public ModEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, "en_uk", registryLookup);
	}

	@Override
	public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder translationBuilder) {
		try {
			Dotenv env = Dotenv.configure().directory("../../").load();
			Mcvanillafeatruetweaks.LOGGER.info("Loaded crowdin api key successfully");
			
			Credentials creds = new Credentials(env.get("CROWDIN_API_KEY"), "org");
		} catch (Exception e) {
			Mcvanillafeatruetweaks.LOGGER.error("Failed to load crowdin api key");
		}
	}
}