package net.denanu.mc_vanille_feature_tweaks;

import net.denanu.mc_vanille_feature_tweaks.entity.Entities;
import net.denanu.mc_vanille_feature_tweaks.entity.ModEntityDataSerializers;
import net.denanu.mc_vanille_feature_tweaks.item.ModItems;
import net.denanu.mc_vanille_feature_tweaks.serializers.ModRecipeSerializers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mcvanillafeatruetweaks implements ModInitializer {
	public static final String MOD_ID = "mc-vanilla-featrue-tweaks";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModRecipeSerializers.load();
		ModEntityDataSerializers.load();
		Entities.load();
		ModItems.load();
	}
}