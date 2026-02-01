package net.denanu.mc_vanille_feature_tweaks.mixin.client;

import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.llamalad7.mixinextras.sugar.Local;

import net.denanu.mc_vanille_feature_tweaks.data.tag.ModItemTags;
import net.denanu.mc_vanille_feature_tweaks.entity.state.SailBoatRenderState;
import net.denanu.mc_vanille_feature_tweaks.gui.SmithingScreenEntityRenderers;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.SmithingScreen;
import net.minecraft.client.renderer.entity.state.ArmorStandRenderState;

@Mixin(SmithingScreen.class)
public class SmithingScreenMixin {
	@Shadow
	private ArmorStandRenderState armorStandPreview;
	
	private static final Vector3f BOAT_TRANSLATION = new Vector3f(0.0F, 0.0F, 0.0F);
	private static final Quaternionf BOAT_ANGLE = new Quaternionf().rotationXYZ(0.43633232F, 0.0F, (float) Math.PI);
	
	@Inject(
			method="renderBg()V", 
			at = @At(
					value="INVOKE", 
					target="Lnet/minecraft/client/gui/GuiGraphics;submitEntityRenderState(Lnet/minecraft/client/renderer/entity/state/EntityRenderState;FLorg/joml/Vector3f;Lorg/joml/Quaternionf;Lorg/joml/Quaternionf;IIII)V", 
					shift = At.Shift.BEFORE
				),
			cancellable=true
		)
	private void renderBigMixin(CallbackInfo ci, @Local GuiGraphics guiGraphics, @Local(ordinal=2) int k, @Local(ordinal=3) int l, @Local(ordinal=4) int m, @Local(ordinal=5) int n) {
		if (this.armorStandPreview.leftHandItemStack.is(ModItemTags.MEDIUM_SAILED_BOATS)) {
			SailBoatRenderState state = SailBoatRenderState.ofItemStack(this.armorStandPreview.leftHandItemStack);
			SmithingScreenEntityRenderers.renderMediumBoat(guiGraphics, state, k, l, m, n);
			ci.cancel();
		}
		
	}
}
