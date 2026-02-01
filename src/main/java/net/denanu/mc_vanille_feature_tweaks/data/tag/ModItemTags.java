package net.denanu.mc_vanille_feature_tweaks.data.tag;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
	public static final TagKey<Item> MEDIUM_SAILED_BOATS = register("medium_sailed_boats");

	private static TagKey<Item> register(String path) {
		return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, path));
	}
}
