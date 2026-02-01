package net.denanu.mc_vanille_feature_tweaks.mixin;

import net.denanu.mc_vanille_feature_tweaks.entity.vehicle.boat.BoatAttrModifier;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractBoat.class)
public class AbstractBoatMixin {
	@Shadow
	private float deltaRotation;
	
	@ModifyConstant(method = "controlBoat()V", constant=@Constant(floatValue=0.04F))
	private float forwardacc(float val) {
		AbstractBoat boat = (AbstractBoat)(Object)this;
		if (boat instanceof BoatAttrModifier) {
			return ((BoatAttrModifier)boat).forwardAcc();
		}
		
		return val;
	}
	@ModifyConstant(method = "controlBoat()V", constant=@Constant(floatValue=0.005F))
	private float backacc(float val) {
		AbstractBoat boat = (AbstractBoat)(Object)this;
		if (boat instanceof BoatAttrModifier) {
			return ((BoatAttrModifier)boat).backwardsAcc();
		}
		
		return val;
	}
	
	@Inject(method="floatBoat()V", at=@At(value="INVOKE", target="Lnet/minecraft/world/entity/vehicle/boat/AbstractBoat;setDeltaMovement(DDD)V"))
	private void modRotArgs(CallbackInfo i) {
		AbstractBoat boat = (AbstractBoat)(Object)this;
		if (boat instanceof BoatAttrModifier) {
			this.deltaRotation *= ((BoatAttrModifier)boat).roationSpeedMod();
		}
	}
	
	
	@ModifyConstant(method = "floatBoat()V", constant=@Constant(floatValue=0.9F))
	private float friction(float val) {
		AbstractBoat boat = (AbstractBoat)(Object)this;
		if (boat instanceof BoatAttrModifier) {
			return ((BoatAttrModifier)boat).waterFriction();
		}
		
		return val;
	}
}