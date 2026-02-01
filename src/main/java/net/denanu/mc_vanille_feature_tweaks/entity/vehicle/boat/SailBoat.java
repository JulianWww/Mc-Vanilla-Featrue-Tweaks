package net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat;

import java.util.function.Supplier;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class SailBoat extends AbstractSailedBoat implements BoatAttrModifier {
	public SailBoat(EntityType<? extends AbstractBoat> entityType, Level level, Supplier<Item> supplier) {
		super(entityType, level, supplier);
	}
	
	@Override
	public float forwardAcc() {
		return 0.016447036378528897f;
	}

	@Override
	public float backwardsAcc() {
		return 0.001827448486503211f;
	}

	@Override
	public float waterFriction() {
		return 0.9671059272429422f;
	}

	@Override
	public float roationSpeedMod() {
		return 0.9f;
	}
	
	protected int getMaxPassengers() {
		return 1;
	}

	@Override
	public double getSailHeight() {
		return 2;
	}
}
