package net.denanu.mc_vanille_feature_tweaks.entity.renderers;

import java.util.Set;

import com.google.common.collect.Sets;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.entity.model.SailBoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.resources.Identifier;

public class ModEntitiyLayers {
	private static final String DEFAULT_LAYER = "main";
	private static final Set<ModelLayerLocation> ALL_MODELS = Sets.<ModelLayerLocation>newHashSet();
	
	public static final ModelLayerLocation OAK_BOAT = register("boat/oak");
	
	private static ModelLayerLocation register(String string) {
		return register(string, DEFAULT_LAYER);
	}

	private static ModelLayerLocation register(String string, String string2) {
		ModelLayerLocation modelLayerLocation = createLocation(string, string2);
		if (!ALL_MODELS.add(modelLayerLocation)) {
			throw new IllegalStateException("Duplicate registration for " + modelLayerLocation);
		} else {
			return modelLayerLocation;
		}
	}
	
	private static ModelLayerLocation createLocation(String string, String string2) {
		return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, string), string2);
	}
	
	LayerDefinition layerDefinition55 = SailBoatModel.createBoatModel();
}
