package net.denanu.mc_vanille_feature_tweaks.entity;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricTrackedDataRegistry;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

public class ModEntityDataSerializers {
	public static final EntityDataSerializer<DyeColor> DYE_COLOR = EntityDataSerializer.forValueType(DyeColor.STREAM_CODEC);
	public static final EntityDataSerializer<BannerPatternLayers> PATTERN_LAYERS = EntityDataSerializer.forValueType(BannerPatternLayers.STREAM_CODEC);
	
	public static void registerSerializer(String type, EntityDataSerializer<?> entityDataSerializer) {
		FabricTrackedDataRegistry.register(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, type), entityDataSerializer);
	}
	
	static {
		registerSerializer("dye_color", DYE_COLOR);
		registerSerializer("banner_pattern", PATTERN_LAYERS);
	}
	
	public static void load() {
		
	}
}
