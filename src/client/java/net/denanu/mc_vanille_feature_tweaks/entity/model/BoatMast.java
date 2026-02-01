package net.denanu.mc_vanille_feature_tweaks.entity.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.object.banner.BannerModel;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.util.Unit;

public class BoatMast extends Model<Unit> {
	public BoatMast(ModelPart modelPart) {
		super(modelPart, RenderTypes::entitySolid);
	}

	public static LayerDefinition createMediumMast() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		partDefinition.addOrReplaceChild("pole", CubeListBuilder.create().texOffs(44, 0).addBox(-1.0F, -42.0F, -1.0F, 2.0F, 42.0F, 2.0F), PartPose.ZERO);
		partDefinition.addOrReplaceChild("pole_2", CubeListBuilder.create().texOffs(44, 3).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 19.0F, 2.0F), PartPose.ZERO);

		partDefinition.addOrReplaceChild(
			"bar", CubeListBuilder.create().texOffs(0, 42).addBox(-10.0F, -44.0F, -1.0F, 20.0F, 2.0F, 2.0F), PartPose.ZERO
		);
		return LayerDefinition.create(meshDefinition, 64, 64);
	}
}
