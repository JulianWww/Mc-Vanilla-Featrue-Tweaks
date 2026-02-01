package net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat;

import java.util.Optional;
import java.util.function.Supplier;

import net.denanu.mc_vanille_feature_tweaks.entity.ModEntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BannerPatternLayers;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public abstract class AbstractSailedBoat extends AbstractBoat implements BoatAttrModifier {
	protected static final EntityDataAccessor<DyeColor> SAIL_COLOR = SynchedEntityData.defineId(AbstractSailedBoat.class, ModEntityDataSerializers.DYE_COLOR);
	protected static final EntityDataAccessor<BannerPatternLayers> SAIL_PATTERN = SynchedEntityData.defineId(AbstractSailedBoat.class, ModEntityDataSerializers.PATTERN_LAYERS);

	public AbstractSailedBoat(EntityType<? extends AbstractBoat> entityType, Level level, Supplier<Item> supplier) {
		super(entityType, level, supplier);
	}
	
	protected void readAdditionalSaveData(ValueInput valueInput) {
		Optional<ValueInput> sail = valueInput.child("sail");
		if (sail.isPresent()) {
			this.setSailColor((DyeColor)sail.get().read("color", DyeColor.CODEC).orElse(DyeColor.WHITE));
			this.setPattern((BannerPatternLayers)valueInput.read("patterns", BannerPatternLayers.CODEC).orElse(BannerPatternLayers.EMPTY));
		}
	}

	protected void addAdditionalSaveData(ValueOutput valueOutput) {
		ValueOutput sail = valueOutput.child("sail");
		sail.store("color", DyeColor.CODEC, this.getSailColor());
		if (this.getPaterns() != BannerPatternLayers.EMPTY) {
			sail.store("patterns", BannerPatternLayers.CODEC, this.getPaterns());
		}
	}
	
	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(SAIL_COLOR, DyeColor.WHITE);
		builder.define(SAIL_PATTERN, BannerPatternLayers.EMPTY);
	}
	
	public BannerPatternLayers getPaterns() {
		return this.entityData.get(SailBoat.SAIL_PATTERN);
	}
	
	public DyeColor getSailColor() {
		return this.entityData.get(SAIL_COLOR);
	}
	
	public void setSailColor(DyeColor color) {
		this.entityData.set(SAIL_COLOR, color);
	}
	
	public void setPattern(BannerPatternLayers pattern) {
		this.entityData.set(SailBoat.SAIL_PATTERN, pattern);
	}
	
	@Override
	protected double rideHeight(EntityDimensions entityDimensions) {
		return entityDimensions.height() / 3.0F;
	}

	public abstract double getSailHeight();
}
