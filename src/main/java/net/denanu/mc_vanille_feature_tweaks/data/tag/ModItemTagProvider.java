package net.denanu.mc_vanille_feature_tweaks.data.tag;
import java.util.concurrent.CompletableFuture;

import net.denanu.mc_vanille_feature_tweaks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup.Provider;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(Provider wrapperLookup) {
		this.valueLookupBuilder(ModItemTags.MEDIUM_SAILED_BOATS)
			.add(ModItems.MEDIUM_OAK_BOAT)
			.add(ModItems.MEDIUM_SPRUCE_BOAT)
			.add(ModItems.MEDIUM_BIRCH_BOAT)
			.add(ModItems.MEDIUM_JUNGLE_BOAT)
			.add(ModItems.MEDIUM_ACACIA_BOAT)
			.add(ModItems.MEDIUM_CHERRY_BOAT)
			.add(ModItems.MEDIUM_DARK_OAK_BOAT)
			.add(ModItems.MEDIUM_PALE_OAK_BOAT)
			.add(ModItems.MEDIUM_MANGROVE_BOAT);
	}
}