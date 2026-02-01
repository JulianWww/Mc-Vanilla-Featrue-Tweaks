package net.denanu.mc_vanille_feature_tweaks.entity;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.entity.model.BoatMast;
import net.denanu.mc_vanille_feature_tweaks.entity.model.SailBoatModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayers {
	public static final ModelLayerLocation SAIL_BOAT = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "sail_boat"), "main");
	public static final ModelLayerLocation MEDIUM_BOAT = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "medium_boat"), "main");
	public static final ModelLayerLocation MEDIUM_BOAT_WATER_PATCH = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "medium_boat"), "water_patch");
	public static final ModelLayerLocation MEDIUM_MAST = new ModelLayerLocation(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "medium_mast"), "main");

	public static void load() {
		EntityModelLayerRegistry.registerModelLayer(SAIL_BOAT, () -> SailBoatModel.createBoatModel(15f));
		EntityModelLayerRegistry.registerModelLayer(MEDIUM_BOAT, () -> SailBoatModel.createMediumBoatModel(21.5f));
		EntityModelLayerRegistry.registerModelLayer(MEDIUM_BOAT_WATER_PATCH, () -> SailBoatModel.createWaterPatch(21.5f));
		EntityModelLayerRegistry.registerModelLayer(MEDIUM_MAST, () -> BoatMast.createMediumMast());
	}
}
