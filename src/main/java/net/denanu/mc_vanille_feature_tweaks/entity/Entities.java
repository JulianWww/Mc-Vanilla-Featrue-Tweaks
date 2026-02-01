package net.denanu.mc_vanille_feature_tweaks.entity;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;

import java.util.function.Supplier;

import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.MediumBoat;
import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.SailBoat;
import net.denanu.mc_vanille_feature_tweaks.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;

public class Entities {
	
	public static final EntityType<SailBoat> OAK_SAIL_BOAT = register(
			"oak_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> SPRUCE_SAIL_BOAT = register(
			"spruce_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.SPRUCE_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> BIRCH_SAIL_BOAT = register(
			"birch_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.BIRCH_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> JUNGLE_SAIL_BOAT = register(
			"jungle_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.JUNGLE_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> ACACIA_SAIL_BOAT = register(
			"acacia_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.ACACIA_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> CHERRY_SAIL_BOAT = register(
			"cherry_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.CHERRY_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> DARK_OAK_SAIL_BOAT = register(
			"dark_oak_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.DARK_OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> PALE_OAK_SAIL_BOAT = register(
			"pale_oak_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.PALE_OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<SailBoat> MANGROVE_SAIL_BOAT = register(
			"mangrove_sail_boat",
			EntityType.Builder.of(sailBoatFactory(() -> ModItems.MANGROVE_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	
	
	public static final EntityType<MediumBoat> MEDIUM_OAK_BOAT = register(
			"medium_oak_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_SPRUCE_BOAT = register(
			"medium_spruce_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.SPRUCE_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_BIRCH_BOAT = register(
				"medium_birch_boat",
				EntityType.Builder.of(mediumBoatFactory(() -> ModItems.BIRCH_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
			);
	public static final EntityType<MediumBoat> MEDIUM_JUNGLE_BOAT = register(
			"medium_jungle_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.BIRCH_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_ACACIA_BOAT = register(
			"medium_acacia_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.ACACIA_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_CHERRY_BOAT = register(
			"medium_cherry_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.CHERRY_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_DARK_OAK_BOAT = register(
			"medium_dark_oak_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.DARK_OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_PALE_OAK_BOAT = register(
			"medium_pale_oak_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.PALE_OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);
	public static final EntityType<MediumBoat> MEDIUM_MANGROVE_BOAT = register(
			"medium_mangrove_boat",
			EntityType.Builder.of(mediumBoatFactory(() -> ModItems.PALE_OAK_SAIL_BOAT), MobCategory.MISC).noLootTable().sized(2F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10)
		);

	
	
	
	private static EntityType.EntityFactory<SailBoat> sailBoatFactory(Supplier<Item> supplier) {
		return (entityType, level) -> new SailBoat(entityType, level, supplier);
	}
	
	private static EntityType.EntityFactory<MediumBoat> mediumBoatFactory(Supplier<Item> supplier) {
		return (entityType, level) -> new MediumBoat(entityType, level, supplier);
	}
	
	private static <T extends Entity> EntityType<T> register(ResourceKey<EntityType<?>> resourceKey, EntityType.Builder<T> builder) {
		return Registry.register(BuiltInRegistries.ENTITY_TYPE, resourceKey, builder.build(resourceKey));
	}
	
	private static <T extends Entity> EntityType<T> register(String string, EntityType.Builder<T> builder) {
		return register(EntityId(string), builder);
	}
	
	private static ResourceKey<EntityType<?>> EntityId(String string) {
		return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID ,string));
	}
	

	public static void load() {
		
	}
}
