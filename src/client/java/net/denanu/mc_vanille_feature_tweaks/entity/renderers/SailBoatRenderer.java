package net.denanu.mc_vanille_feature_tweaks.entity.renderers;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.denanu.mc_vanille_feature_tweaks.entity.ModModelLayers;
import net.denanu.mc_vanille_feature_tweaks.entity.model.SailBoatModel;
import net.denanu.mc_vanille_feature_tweaks.entity.state.SailBoatRenderState;
import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.AbstractSailedBoat;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.banner.BannerFlagModel;
import net.minecraft.client.model.object.banner.BannerModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BannerRenderer;
import net.minecraft.client.renderer.entity.AbstractBoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.MaterialSet;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.phys.AABB;

public class SailBoatRenderer extends AbstractBoatRenderer {
	private final Model.Simple waterPatchModel;
	private final Identifier texture;
	private final SailBoatModel model;
	private final MaterialSet materials;
	private final BannerFlagModel sailModel;
	private final ImmutableList<SailPosition> sailPositions;
	
	public static SailBoatRenderer forSailBoat(EntityRendererProvider.Context context, Identifier texture) {
		return new SailBoatRenderer(context, ModModelLayers.SAIL_BOAT, texture, 1, ImmutableList.of(SailPosition.shortSail(0.6f)));
	}
	
	public static SailBoatRenderer forMediumBoat(EntityRendererProvider.Context context, Identifier texture) {
		return new SailBoatRenderer(context, ModModelLayers.MEDIUM_BOAT, texture, 2, ImmutableList.of(SailPosition.mediumSail(0.6f)));
	}
	
	public SailBoatRenderer(EntityRendererProvider.Context context, ModelLayerLocation modelLayerLocation, Identifier texture_loc, int number_of_paddles, ImmutableList<SailPosition> sailPositions) {
		super(context);
		this.texture = texture_loc.withPath(str -> "textures/entity/" + str + ".png");		
		ModelLayerLocation water_patch = this.getWaterPatch(modelLayerLocation);
		
		this.waterPatchModel = new Model.Simple(context.bakeLayer(water_patch), identifier -> RenderTypes.waterMask());
		this.model = new SailBoatModel(context.bakeLayer(modelLayerLocation), number_of_paddles);
		this.materials = context.getMaterials();
		sailPositions.forEach(val -> val.model = new BannerModel(context.bakeLayer(val.mast)));
		this.sailModel = new BannerFlagModel(context.bakeLayer(ModelLayers.STANDING_BANNER_FLAG));
		this.sailPositions = sailPositions;
	}

	private ModelLayerLocation getWaterPatch(ModelLayerLocation modelLayerLocation) {
		if (modelLayerLocation.equals(ModModelLayers.MEDIUM_BOAT)) {
			return ModModelLayers.MEDIUM_BOAT_WATER_PATCH;
		}
		return ModelLayers.BOAT_WATER_PATCH;
	}

	@Override
	protected EntityModel<BoatRenderState> model() {
		return this.model;
	}

	@Override
	protected RenderType renderType() {
		return this.model.renderType(this.texture);
	}
	
	@Override
	protected void submitTypeAdditions(BoatRenderState boatRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, int i) {
		super.submitTypeAdditions(boatRenderState, poseStack, submitNodeCollector, i);
		if (!boatRenderState.isUnderWater) {
			submitNodeCollector.submitModel(
				this.waterPatchModel,
				Unit.INSTANCE,
				poseStack,
				this.waterPatchModel.renderType(this.texture),
				i,
				OverlayTexture.NO_OVERLAY,
				boatRenderState.outlineColor,
				null
			);
		}
		SailBoatRenderState state = (SailBoatRenderState)boatRenderState;
		this.sailPositions.forEach(pos -> 
			submitBanner(
				this.materials,
				poseStack,
				submitNodeCollector,
				i,
				OverlayTexture.NO_OVERLAY,
				pos.model,
				this.sailModel,
				state.phase,
				state.baseColor,
				state.paterns,
				0,
				pos
				)
			);
		
	}
	
	public static void submitBanner(
			MaterialSet materialSet,
			PoseStack poseStack,
			SubmitNodeCollector submitNodeCollector,
			int i,
			int j,
			BannerModel bannerModel,
			BannerFlagModel bannerFlagModel,
			float g,
			DyeColor dyeColor,
			BannerPatternLayers bannerPatternLayers,
			int k,
			SailPosition pos
		) {
			poseStack.pushPose();
			poseStack.mulPose(Axis.YP.rotationDegrees(-90));
			poseStack.translate(0.0f, -pos.height, pos.x_offset);
			Material material = ModelBakery.BANNER_BASE;
			submitNodeCollector.submitModel(
				bannerModel, Unit.INSTANCE, poseStack, material.renderType(RenderTypes::entitySolid), i, j, -1, materialSet.get(material), k, null
			);
			BannerRenderer.submitPatterns(
				materialSet, poseStack, submitNodeCollector, i, j, bannerFlagModel, g, material, true, dyeColor, bannerPatternLayers, false, null, k
			);
			poseStack.popPose();
		}
	
	protected AABB getBoundingBoxForCulling(AbstractBoat entity) {
		AbstractSailedBoat boat = (AbstractSailedBoat) entity;
		AABB box = entity.getBoundingBox();
		double max_y = box.maxY + boat.getSailHeight();
		AABB render_box = box.setMaxY(max_y);
		return render_box;
	}
	
	public BoatRenderState createRenderState() {
		return new SailBoatRenderState();
	}
	
	public void extractRenderState(AbstractBoat abstractBoat, BoatRenderState boatRenderState, float f) {
		super.extractRenderState(abstractBoat, boatRenderState, f);
		SailBoatRenderState state = (SailBoatRenderState) boatRenderState;
		AbstractSailedBoat boat = (AbstractSailedBoat) abstractBoat;
		state.phase = (state.ageInTicks / 100f);
		state.baseColor = boat.getSailColor();
		state.paterns = boat.getPaterns();
	}
	
	public static class SailPosition {
		float x_offset, height;
		ModelLayerLocation mast;
		BannerModel model;
		
		private SailPosition(float x, float h, ModelLayerLocation mast) {
			this.x_offset = x;
			this.height = h;
			this.mast = mast;			
		}
		
		public static SailPosition shortSail(float x_offset) {
			return new SailPosition(x_offset, 0f, ModelLayers.STANDING_BANNER);
		}
		public static SailPosition mediumSail(float x_offset) {
			return new SailPosition(x_offset, 1.0f, ModModelLayers.MEDIUM_MAST);
		}
	}
}