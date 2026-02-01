package net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat;

import java.util.function.Supplier;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class LargeBoat extends AbstractSailedBoat {

	public LargeBoat(EntityType<? extends AbstractBoat> entityType, Level level, Supplier<Item> supplier) {
		super(entityType, level, supplier);
	}

	@Override
	public float forwardAcc() {
		return 0.005756462732485114f;
	}

	@Override
	public float backwardsAcc() {
		return 0.0003198034851380619f;
	}

	@Override
	public float waterFriction() {
		return 0.9942435372675149f;
	}

	@Override
	public float roationSpeedMod() {
		return 0.3f;
	}
	
	protected int getMaxPassengers() {
		return 4;
	}
	
	protected float getSinglePassengerXOffset() {
		return 0.5f;
	}
	
	@Override
	protected Vec3 getPassengerAttachmentPoint(Entity entity, EntityDimensions entityDimensions, float f) {
		float g = 0.5f;
		if (this.getPassengers().size() > 2) {
			g = 0.7f;
		}
		if (this.getPassengers().size() > 1) {
			int i = this.getPassengers().indexOf(entity);
			g -= 0.8*i;
		}

		return new Vec3(0.0, this.rideHeight(entityDimensions), g).yRot(-this.getYRot() * (float) (Math.PI / 180.0));
	}

	@Override
	public double getSailHeight() {
		return 4d;
	}
}
