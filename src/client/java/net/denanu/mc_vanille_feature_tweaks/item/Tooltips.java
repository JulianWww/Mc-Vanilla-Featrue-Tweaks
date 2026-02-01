package net.denanu.mc_vanille_feature_tweaks.item;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;

public class Tooltips {
	public static void load() {
		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
		      if (!itemStack.is(ModItems.CHERRY_SAIL_BOAT)) {
		        return;
		      }
		      list.add(Component.translatable("mc-vanilla-featrue-tweaks.sail.color", 
		    		  Component.translatable("color.minecraft." + itemStack.get(DataComponents.BASE_COLOR).getName())));
		    });
	}
}
