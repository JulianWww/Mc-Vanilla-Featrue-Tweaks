package net.denanu.mc_vanille_feature_tweaks.item;

import java.util.function.Function;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.entity.Entities;
import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.AbstractSailedBoat;
import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.SailBoat;
import net.denanu.mc_vanille_feature_tweaks.item.boat.SailBoatItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

public class ModItems {
	public static final Item OAK_SAIL_BOAT = registerBoat("oak_sail_boat", Entities.OAK_SAIL_BOAT);
	public static final Item SPRUCE_SAIL_BOAT = registerBoat("spruce_sail_boat", Entities.SPRUCE_SAIL_BOAT);
	public static final Item BIRCH_SAIL_BOAT = registerBoat("birch_sail_boat", Entities.BIRCH_SAIL_BOAT);
	public static final Item JUNGLE_SAIL_BOAT = registerBoat("jungle_sail_boat", Entities.JUNGLE_SAIL_BOAT);
	public static final Item ACACIA_SAIL_BOAT = registerBoat("acacia_sail_boat", Entities.ACACIA_SAIL_BOAT);
	public static final Item CHERRY_SAIL_BOAT = registerBoat("cherry_sail_boat", Entities.CHERRY_SAIL_BOAT);
	public static final Item DARK_OAK_SAIL_BOAT = registerBoat("dark_oak_sail_boat", Entities.DARK_OAK_SAIL_BOAT);
	public static final Item PALE_OAK_SAIL_BOAT = registerBoat("pale_oak_sail_boat", Entities.PALE_OAK_SAIL_BOAT);
	public static final Item MANGROVE_SAIL_BOAT = registerBoat("mangrove_sail_boat", Entities.MANGROVE_SAIL_BOAT);
	
	public static final Item BOAT_UPGRADE = registerItem(
			"boat_upgrade_template", 
			BoatUpgradeTemplateBuilder::createBoatUpgradeTemplate, 
			new Item.Properties().rarity(Rarity.UNCOMMON)
	);
	
	public static final Item MEDIUM_OAK_BOAT = registerBoat("medium_oak_boat", Entities.MEDIUM_OAK_BOAT);
	public static final Item MEDIUM_SPRUCE_BOAT = registerBoat("medium_spruce_boat", Entities.MEDIUM_SPRUCE_BOAT);
	public static final Item MEDIUM_BIRCH_BOAT = registerBoat("medium_birch_boat", Entities.MEDIUM_BIRCH_BOAT);
	public static final Item MEDIUM_JUNGLE_BOAT = registerBoat("medium_jungle_boat", Entities.MEDIUM_JUNGLE_BOAT);
	public static final Item MEDIUM_ACACIA_BOAT = registerBoat("medium_acacia_boat", Entities.MEDIUM_ACACIA_BOAT);
	public static final Item MEDIUM_CHERRY_BOAT = registerBoat("medium_cherry_boat", Entities.MEDIUM_CHERRY_BOAT);
	public static final Item MEDIUM_DARK_OAK_BOAT = registerBoat("medium_dark_oak_boat", Entities.MEDIUM_DARK_OAK_BOAT);
	public static final Item MEDIUM_PALE_OAK_BOAT = registerBoat("medium_pale_oak_boat", Entities.MEDIUM_PALE_OAK_BOAT);
	public static final Item MEDIUM_MANGROVE_BOAT = registerBoat("medium_mangrove_boat", Entities.MEDIUM_MANGROVE_BOAT);
	
	
	
	
	private static ResourceKey<Item> ItemId(String string) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, string));
	}
	
	public static <T extends AbstractSailedBoat> Item registerBoat(String str, EntityType<T> boat) {
		return registerItem(
				str, properties -> new SailBoatItem(boat, properties), new Item.Properties().stacksTo(1)
				.component(DataComponents.BASE_COLOR, DyeColor.WHITE)
				.component(DataComponents.BANNER_PATTERNS, BannerPatternLayers.EMPTY)
		);
	}
	
	public static Item registerItem(String string, Function<Item.Properties, Item> function, Item.Properties properties) {
		return registerItem(ItemId(string), function, properties);
	}
	
	public static Item registerItem(ResourceKey<Item> resourceKey, Function<Item.Properties, Item> function, Item.Properties properties) {
		Item item = (Item)function.apply(properties.setId(resourceKey));
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}

		return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
	}
	
	public static void load() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
		.register((itemGroup) -> {
			itemGroup.accept(ModItems.OAK_SAIL_BOAT);
			itemGroup.accept(ModItems.SPRUCE_SAIL_BOAT);
			itemGroup.accept(ModItems.BIRCH_SAIL_BOAT);
			itemGroup.accept(ModItems.JUNGLE_SAIL_BOAT);
			itemGroup.accept(ModItems.ACACIA_SAIL_BOAT);
			itemGroup.accept(ModItems.CHERRY_SAIL_BOAT);
			itemGroup.accept(ModItems.DARK_OAK_SAIL_BOAT);
			itemGroup.accept(ModItems.PALE_OAK_SAIL_BOAT);
			itemGroup.accept(ModItems.MANGROVE_SAIL_BOAT);
			
			itemGroup.accept(ModItems.MEDIUM_OAK_BOAT);
			itemGroup.accept(ModItems.MEDIUM_SPRUCE_BOAT);
			itemGroup.accept(ModItems.MEDIUM_BIRCH_BOAT);
			itemGroup.accept(ModItems.MEDIUM_JUNGLE_BOAT);
			itemGroup.accept(ModItems.MEDIUM_ACACIA_BOAT);
			itemGroup.accept(ModItems.MEDIUM_CHERRY_BOAT);
			itemGroup.accept(ModItems.MEDIUM_DARK_OAK_BOAT);
			itemGroup.accept(ModItems.MEDIUM_PALE_OAK_BOAT);
			itemGroup.accept(ModItems.MEDIUM_MANGROVE_BOAT);
		});
		
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
		.register((itemGroup) -> {
			itemGroup.accept(ModItems.BOAT_UPGRADE);
		});
	}
}
