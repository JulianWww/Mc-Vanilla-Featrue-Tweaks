package net.denanu.mc_vanille_feature_tweaks.entity.state;

import net.denanu.mc_vanille_feature_tweaks.item.boat.SailBoatItem;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BannerPatternLayers;

public class SailBoatRenderState extends BoatRenderState {
	public float phase;
	public BannerPatternLayers paterns;
	public DyeColor baseColor;
	
	public static SailBoatRenderState ofItemStack(ItemStack stack) {
		SailBoatRenderState state = new SailBoatRenderState();
		state.baseColor = stack.getComponents().get(DataComponents.BASE_COLOR);;
		state.paterns = stack.getComponents().get(DataComponents.BANNER_PATTERNS);
		state.entityType = ((SailBoatItem)stack.getItem()).entityType;
		return state;
		
	}
}
