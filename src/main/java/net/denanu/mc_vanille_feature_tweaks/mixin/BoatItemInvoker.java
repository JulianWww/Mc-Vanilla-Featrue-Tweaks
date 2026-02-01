package net.denanu.mc_vanille_feature_tweaks.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

@Mixin(BoatItem.class)
public interface BoatItemInvoker {
	@Invoker("getBoat")
	AbstractBoat mc_vanilla_featrue_tweaks$getBoat(Level level, HitResult hitResult, ItemStack itemStack, Player player);
}
