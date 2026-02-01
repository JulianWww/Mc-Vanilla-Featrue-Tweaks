package net.denanu.mc_vanille_feature_tweaks.data.recipe;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.item.crafting.TransmuteResult;
import net.minecraft.world.level.ItemLike;

public class ModRecipeProvider extends FabricRecipeProvider {

	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public String getName() {
		return Mcvanillafeatruetweaks.MOD_ID + " recipe generator";
	}

	@Override
	protected RecipeProvider createRecipeProvider(Provider registryLookup, RecipeOutput exporter) {
		return new RecipeProvider(registryLookup, exporter) {	
			public void smithBoat(Item inBoat, Item outBoat) {
				SpecialRecipeBuilder.special(
						cat -> new SmithingTransformRecipe(
								Optional.of(Ingredient.of(ModItems.BOAT_UPGRADE)), 
								Ingredient.of(inBoat), 
								Optional.empty(), 
								new TransmuteResult(outBoat)))
				.save(this.output, RecipeProvider.getItemName(outBoat) + "_smithing");;
			}
			
			@Override
			public void buildRecipes() {
				HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
				
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.OAK_BOAT, ModItems.OAK_SAIL_BOAT)).save(this.output, getid("oak_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.SPRUCE_BOAT, ModItems.SPRUCE_SAIL_BOAT)).save(this.output, getid("spruce_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.BIRCH_BOAT, ModItems.BIRCH_SAIL_BOAT)).save(this.output, getid("birch_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.JUNGLE_BOAT, ModItems.JUNGLE_SAIL_BOAT)).save(this.output, getid("jungle_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.ACACIA_BOAT, ModItems.ACACIA_SAIL_BOAT)).save(this.output, getid("acacia_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.CHERRY_BOAT, ModItems.CHERRY_SAIL_BOAT)).save(this.output, getid("cherry_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.DARK_OAK_BOAT, ModItems.DARK_OAK_SAIL_BOAT)).save(this.output, getid("dark_oak_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.PALE_OAK_BOAT, ModItems.PALE_OAK_SAIL_BOAT)).save(this.output, getid("pale_oak_sail_boat"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, Items.MANGROVE_BOAT, ModItems.MANGROVE_SAIL_BOAT)).save(this.output, getid("mangrove_sail_boat"));
				
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.OAK_SAIL_BOAT, ModItems.OAK_SAIL_BOAT)).save(this.output, getid("oak_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.SPRUCE_SAIL_BOAT, ModItems.SPRUCE_SAIL_BOAT)).save(this.output, getid("spruce_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.BIRCH_SAIL_BOAT, ModItems.BIRCH_SAIL_BOAT)).save(this.output, getid("birch_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.JUNGLE_SAIL_BOAT, ModItems.JUNGLE_SAIL_BOAT)).save(this.output, getid("jungle_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.ACACIA_SAIL_BOAT, ModItems.ACACIA_SAIL_BOAT)).save(this.output, getid("acacia_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.CHERRY_SAIL_BOAT, ModItems.CHERRY_SAIL_BOAT)).save(this.output, getid("cherry_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.DARK_OAK_SAIL_BOAT, ModItems.DARK_OAK_SAIL_BOAT)).save(this.output, getid("dark_oak_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.PALE_OAK_SAIL_BOAT, ModItems.PALE_OAK_SAIL_BOAT)).save(this.output, getid("pale_oak_sail_boat_decorate"));
				SpecialRecipeBuilder.special(cat -> new SailBoatRecipe(cat, ModItems.MANGROVE_SAIL_BOAT, ModItems.MANGROVE_SAIL_BOAT)).save(this.output, getid("mangrove_sail_boat_decorate"));
				
				this.smithBoat(ModItems.OAK_SAIL_BOAT, ModItems.MEDIUM_OAK_BOAT);
				this.smithBoat(ModItems.SPRUCE_SAIL_BOAT, ModItems.MEDIUM_SPRUCE_BOAT);
				this.smithBoat(ModItems.BIRCH_SAIL_BOAT, ModItems.MEDIUM_BIRCH_BOAT);
				this.smithBoat(ModItems.JUNGLE_SAIL_BOAT, ModItems.MEDIUM_JUNGLE_BOAT);
				this.smithBoat(ModItems.ACACIA_SAIL_BOAT, ModItems.MEDIUM_ACACIA_BOAT);
				this.smithBoat(ModItems.CHERRY_SAIL_BOAT, ModItems.MEDIUM_CHERRY_BOAT);
				this.smithBoat(ModItems.DARK_OAK_SAIL_BOAT, ModItems.MEDIUM_DARK_OAK_BOAT);
				this.smithBoat(ModItems.PALE_OAK_SAIL_BOAT, ModItems.MEDIUM_PALE_OAK_BOAT);
				this.smithBoat(ModItems.MANGROVE_SAIL_BOAT, ModItems.MEDIUM_MANGROVE_BOAT);
			}
		};
	}
	
	public static String getid(String str) {
		return Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, str).toString();
	}
}
