package net.denanu.mc_vanille_feature_tweaks.item;

import java.util.List;
import java.util.Optional;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.item.crafting.TransmuteResult;

public class BoatUpgradeTemplateBuilder {
	private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
	private static final Component BOAT_UPGRADE_APPLIES_TO = Component.translatable(
			Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "smithing_template.boat_upgrade.applies_to"))
		)
		.withStyle(DESCRIPTION_FORMAT);
	private static final Component BOAT_UPGRADE_INGREDIENTS = Component.translatable(
			Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "smithing_template.boat_upgrade.ingredients"))
		)
		.withStyle(DESCRIPTION_FORMAT);
	private static final Component BOAT_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable(
			Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "smithing_template.boat_upgrade.base_slot_description"))
		);
	private static final Component BOAT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable(
			Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "smithing_template.boat_upgrade.additions_slot_description"))
		);
	
	private static final Identifier EMPTY_SLOT_SAIL_BOAT = Identifier.withDefaultNamespace("container/slot/helmet");
	private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("container/slot/ingot");
	
	private static List<Identifier> createBoatUpgradeIconList() {
		return List.of(
			EMPTY_SLOT_SAIL_BOAT
		);
	}
	private static List<Identifier> createBoatUpgradeMaterialList() {
		return List.of(
			EMPTY_SLOT_INGOT
		);
	}
	
	public static SmithingTemplateItem createBoatUpgradeTemplate(Item.Properties properties) {
		return new SmithingTemplateItem(
			BOAT_UPGRADE_APPLIES_TO,
			BOAT_UPGRADE_INGREDIENTS,
			BOAT_UPGRADE_BASE_SLOT_DESCRIPTION,
			BOAT_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
			createBoatUpgradeIconList(),
			createBoatUpgradeMaterialList(),
			properties
		);
	}	
}
