package net.denanu.mc_vanille_feature_tweaks.entity.model;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.util.Mth;

public class SailBoatModel extends BoatModel{
	private final ImmutableList<ModelPart> additionalRightPaddles;
	private final ImmutableList<ModelPart> additionalLeftPaddles;
	
	
	public SailBoatModel(ModelPart modelPart, int number_of_paddles) {
		super(modelPart);
		this.additionalRightPaddles = this.getRightPaddles(modelPart, number_of_paddles);
		this.additionalLeftPaddles = this.getLeftPaddles(modelPart, number_of_paddles);
	}
	
	public ImmutableList<ModelPart> getRightPaddles(ModelPart modelPart, int number_of_paddles) {
		Builder<ModelPart> builder = ImmutableList.builder();
		for (int i=2; i<=number_of_paddles; i++) {
			builder.add(modelPart.getChild("right_paddle_" + String.valueOf(i)));
		}
		return builder.build();
	}
	
	public ImmutableList<ModelPart> getLeftPaddles(ModelPart modelPart, int number_of_paddles) {
		Builder<ModelPart> builder = ImmutableList.builder();
		for (int i=2; i<=number_of_paddles; i++) {
			builder.add(modelPart.getChild("left_paddle_" + String.valueOf(i)));
		}
		return builder.build();
	}
	
	@Override
	public void setupAnim(BoatRenderState boatRenderState) {
		super.setupAnim(boatRenderState);
		this.additionalLeftPaddles.forEach(paddle -> animatePaddle(boatRenderState.rowingTimeLeft, 0, paddle));
		this.additionalRightPaddles.forEach(paddle -> animatePaddle(boatRenderState.rowingTimeRight, 1, paddle));
	}
	
	private static void animatePaddle(float f, int i, ModelPart modelPart) {
		modelPart.xRot = Mth.clampedLerp((Mth.sin(-f) + 1.0F) / 2.0F, (float) (-Math.PI / 3), (float) (-Math.PI / 12));
		modelPart.yRot = Mth.clampedLerp((Mth.sin(-f + 1.0F) + 1.0F) / 2.0F, (float) (-Math.PI / 4), (float) (Math.PI / 4));
		if (i == 1) {
			modelPart.yRot = (float) Math.PI - modelPart.yRot;
		}
	}
	
	
	public static void create_bow(PartDefinition partDefinition, float length) {
		partDefinition.addOrReplaceChild(
				"front",
				CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(length, 4.0F, 0.0F, 0.0F, (float) (Math.PI / 2), 0.0F)
			);
	}
	
	private static void create_stern(PartDefinition partDefinition, float length) {
		partDefinition.addOrReplaceChild(
				"back",
				CubeListBuilder.create().texOffs(0, 19).addBox(-13.0F, -7.0F, -1.0F, 18.0F, 6.0F, 2.0F),
				PartPose.offsetAndRotation(-length, 4.0F, 4.0F, 0.0F, (float) (Math.PI * 3.0 / 2.0), 0.0F)
			);
	}
	
	private static void create_amidships(PartDefinition partDefinition, float length) {
		partDefinition.addOrReplaceChild(
				"bottom",
				CubeListBuilder.create().texOffs(0, 0).addBox(1-length, -9.0F, -3.0F, 2*(length-1), 16.0F, 3.0F),
				PartPose.offsetAndRotation(0.0F, 3.0F, 1.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
			);
		partDefinition.addOrReplaceChild(
				"right",
				CubeListBuilder.create().texOffs(0, 35).addBox(1-length, -7.0F, -1.0F, 2*(length-1), 6.0F, 2.0F),
				PartPose.offsetAndRotation(0.0F, 4.0F, -9.0F, 0.0F, (float) Math.PI, 0.0F)
			);
		partDefinition.addOrReplaceChild(
				"left", CubeListBuilder.create().texOffs(0, 43).addBox(1-length, -7.0F, -1.0F, 2*(length-1), 6.0F, 2.0F), 
				PartPose.offset(0.0F, 4.0F, 9.0F)
			);
	}
	
	private static void addPaddles(PartDefinition part, float length, float offset) {
		addPaddles(part, length, offset, "");
	}
	
	private static void addPaddles(PartDefinition part, float length, float offset, int index) {
		addPaddles(part, length, offset, "_"+String.valueOf(index));
	}
	
	private static void addPaddles(PartDefinition part, float length, float offset, String name_mod) {
		part.addOrReplaceChild(
				"left_paddle"+name_mod,
				CubeListBuilder.create().texOffs((int)(2+4*length), 0).addBox(-1f, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(-1.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F),
				PartPose.offsetAndRotation(offset, -5.0F, 9.0F, 0.0F, 0.0F, (float) (Math.PI / 16))
			);
		part.addOrReplaceChild(
				"right_paddle"+name_mod,
				CubeListBuilder.create().texOffs((int)(2+4*length), 20).addBox(-1f, 0.0F, -5.0F, 2.0F, 2.0F, 18.0F).addBox(1.001F, -3.0F, 8.0F, 1.0F, 6.0F, 7.0F),
				PartPose.offsetAndRotation(offset, -5.0F, -9.0F, 0.0F, (float) Math.PI, (float) (Math.PI / 16))
			);
	}
	
	private static void addCommonParts(PartDefinition partDefinition, float length) {
		create_bow(partDefinition, length);
		create_stern(partDefinition, length);
		create_amidships(partDefinition, length);
		addPaddles(partDefinition, length, length - 12f);
	}

	public static LayerDefinition createBoatModel(float length) {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		addCommonParts(partDefinition, length);
		
		
		return LayerDefinition.create(meshDefinition, 128, 64);
	}
	
	public static LayerDefinition createMediumBoatModel(float length) {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		addCommonParts(partDefinition, length);
		addPaddles(partDefinition, length, length - 24.8f, 2);
		
		
		return LayerDefinition.create(meshDefinition, 128, 64);
	}
	
	public static LayerDefinition createWaterPatch(float length) {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();
		partDefinition.addOrReplaceChild(
			"water_patch",
			CubeListBuilder.create().texOffs(0, 0).addBox(1-length, -9.0F, -3.0F, 2*(length-1), 16.0F, 3.0F),
			PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, (float) (Math.PI / 2), 0.0F, 0.0F)
		);
		return LayerDefinition.create(meshDefinition, 0, 0);
	}

}
