package net.denanu.mc_vanille_feature_tweaks;

import net.denanu.mc_vanille_feature_tweaks.entity.MocEntityRenderers;
import net.denanu.mc_vanille_feature_tweaks.entity.ModModelLayers;
import net.denanu.mc_vanille_feature_tweaks.item.Tooltips;
import net.fabricmc.api.ClientModInitializer;

public class McvanillafeatruetweaksClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Tooltips.load();
		ModModelLayers.load();
		MocEntityRenderers.load();
	}
}