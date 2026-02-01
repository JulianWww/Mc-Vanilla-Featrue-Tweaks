package net.denanu.mc_vanille_feature_tweaks.gui;

import org.joml.Quaternionf;
import org.joml.Vector3f;

import net.denanu.mc_vanille_feature_tweaks.entity.state.SailBoatRenderState;
import net.minecraft.client.gui.GuiGraphics;

public class SmithingScreenEntityRenderers {
	public static void renderMediumBoat(GuiGraphics guiGraphics, SailBoatRenderState state, int k, int l, int m, int n) {
		guiGraphics.submitEntityRenderState(state, 12.0F, new Vector3f(0.0F, 1.7F, 10.0F), new Quaternionf().rotationXYZ(0.43633232F, ((float) Math.PI)*1.2f, (float) Math.PI), null, k, l, m, n);
	}
}
