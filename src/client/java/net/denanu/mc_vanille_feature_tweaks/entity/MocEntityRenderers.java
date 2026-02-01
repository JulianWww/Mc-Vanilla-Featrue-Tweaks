package net.denanu.mc_vanille_feature_tweaks.entity;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.entity.renderers.SailBoatRenderer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.Identifier;

public class MocEntityRenderers {
	public static void load() {		
		EntityRenderers.register(Entities.OAK_SAIL_BOAT, 		(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/oak")));
		EntityRenderers.register(Entities.SPRUCE_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/spruce")));
		EntityRenderers.register(Entities.BIRCH_SAIL_BOAT, 		(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/birch")));
		EntityRenderers.register(Entities.JUNGLE_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/jungle")));
		EntityRenderers.register(Entities.ACACIA_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/acacia")));
		EntityRenderers.register(Entities.CHERRY_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/cherry")));
		EntityRenderers.register(Entities.DARK_OAK_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/dark_oak")));
		EntityRenderers.register(Entities.PALE_OAK_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/pale_oak")));
		EntityRenderers.register(Entities.MANGROVE_SAIL_BOAT, 	(context) -> SailBoatRenderer.forSailBoat(context, Identifier.withDefaultNamespace("boat/mangrove")));
		
		EntityRenderers.register(Entities.MEDIUM_OAK_BOAT, 		(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_oak")));
		EntityRenderers.register(Entities.MEDIUM_SPRUCE_BOAT, 	(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_spruce")));
		EntityRenderers.register(Entities.MEDIUM_BIRCH_BOAT, 	(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_birch")));
		EntityRenderers.register(Entities.MEDIUM_JUNGLE_BOAT, 	(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_jungle")));
		EntityRenderers.register(Entities.MEDIUM_ACACIA_BOAT, 	(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_acacia")));
		EntityRenderers.register(Entities.MEDIUM_CHERRY_BOAT, 	(context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_cherry")));
		EntityRenderers.register(Entities.MEDIUM_DARK_OAK_BOAT, (context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_dark_oak")));
		EntityRenderers.register(Entities.MEDIUM_PALE_OAK_BOAT, (context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_pale_oak")));
		EntityRenderers.register(Entities.MEDIUM_MANGROVE_BOAT, (context) -> SailBoatRenderer.forMediumBoat(context, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "boat/medium_mangrove")));	
	}
}
