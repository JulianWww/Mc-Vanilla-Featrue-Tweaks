package net.denanu.mc_vanille_feature_tweaks.serializers;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.data.recipe.SailBoatRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
	public static RecipeSerializer<SailBoatRecipe> SAIL_BOAT = register(
			"crafting_special_sailbat", new SailBoatRecipe.Serializer()
		);
	
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String string, S recipeSerializer) {
		return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, string), recipeSerializer);
	}
	
	public static void load() {
		
	}
}
