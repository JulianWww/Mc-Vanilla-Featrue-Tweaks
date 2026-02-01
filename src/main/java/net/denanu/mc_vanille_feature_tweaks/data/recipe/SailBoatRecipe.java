package net.denanu.mc_vanille_feature_tweaks.data.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.denanu.mc_vanille_feature_tweaks.serializers.ModRecipeSerializers;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.references.Items;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.item.crafting.ShapedRecipePattern;
import net.minecraft.world.level.Level;

public class SailBoatRecipe extends CustomRecipe {
	private Item orig, result;
	
	public SailBoatRecipe(CraftingBookCategory craftingBookCategory, Holder<Item> orig, Holder<Item> result) {
		this(craftingBookCategory, orig.value(), result.value());
	}
	
	public SailBoatRecipe(CraftingBookCategory craftingBookCategory, Item orig, Item result) {
		super(craftingBookCategory);
		this.orig = orig;
		this.result = result;
	}

	public boolean matches(CraftingInput craftingInput, Level level) {
		if (craftingInput.ingredientCount() != 2) {
			return false;
		} else {
			boolean bl = false;
			boolean bl2 = false;

			for (int i = 0; i < craftingInput.size(); i++) {
				ItemStack itemStack = craftingInput.getItem(i);
				if (!itemStack.isEmpty()) {
					if (itemStack.getItem() instanceof BannerItem) {
						if (bl2) {
							return false;
						}

						bl2 = true;
					} else {
						
						if (!itemStack.is(this.orig)) {
							return false;
						}

						if (bl) {
							return false;
						}

						bl = true;
					}
				}
			}

			return bl && bl2;
		}
	}

	public ItemStack assemble(CraftingInput craftingInput, HolderLookup.Provider provider) {
		ItemStack itemStack = ItemStack.EMPTY;
		ItemStack itemStack2 = ItemStack.EMPTY;

		for (int i = 0; i < craftingInput.size(); i++) {
			ItemStack itemStack3 = craftingInput.getItem(i);
			if (!itemStack3.isEmpty()) {
				if (itemStack3.getItem() instanceof BannerItem) {
					itemStack = itemStack3;
				} else if (itemStack3.is(this.orig)) {
					itemStack2 = new ItemStack(this.result, 1);
				}
			}
		}

		if (itemStack2.isEmpty()) {
			return itemStack2;
		} else {
			itemStack2.set(DataComponents.BANNER_PATTERNS, itemStack.get(DataComponents.BANNER_PATTERNS));
			itemStack2.set(DataComponents.BASE_COLOR, ((BannerItem)itemStack.getItem()).getColor());
			return itemStack2;
		}
	}
	
	public Holder<Item> inBoat() {
		return this.orig.builtInRegistryHolder();
	}
	
	public Holder<Item> outBoat() {
		return this.result.builtInRegistryHolder();
	}

	@Override
	public RecipeSerializer<SailBoatRecipe> getSerializer() {
		return ModRecipeSerializers.SAIL_BOAT;
	}
	
	public static class Serializer implements RecipeSerializer<SailBoatRecipe> {
		public static final MapCodec<SailBoatRecipe> CODEC = RecordCodecBuilder.mapCodec(
				instance -> instance.group(
						CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(CraftingRecipe::category),
						Item.CODEC.fieldOf("in_boat").forGetter(r -> r.inBoat()),
						Item.CODEC.fieldOf("out_boat").forGetter(r -> r.outBoat())
					)
					.apply(instance, SailBoatRecipe::new)
			);
		public static final StreamCodec<RegistryFriendlyByteBuf, SailBoatRecipe> STREAM_CODEC = StreamCodec.of(
				SailBoatRecipe.Serializer::toNetwork, SailBoatRecipe.Serializer::fromNetwork
			);

		@Override
		public MapCodec<SailBoatRecipe> codec() {
			return Serializer.CODEC;
		}

		@Override
		public StreamCodec<RegistryFriendlyByteBuf, SailBoatRecipe> streamCodec() {
			return Serializer.STREAM_CODEC;
		}
		
		private static SailBoatRecipe fromNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
			CraftingBookCategory craftingBookCategory = registryFriendlyByteBuf.readEnum(CraftingBookCategory.class);
			Holder<Item> in_boat = Item.STREAM_CODEC.decode(registryFriendlyByteBuf);
			Holder<Item> out_boat = Item.STREAM_CODEC.decode(registryFriendlyByteBuf);
			return new SailBoatRecipe(craftingBookCategory, in_boat, out_boat);
		}

		private static void toNetwork(RegistryFriendlyByteBuf registryFriendlyByteBuf, SailBoatRecipe recipe) {
			registryFriendlyByteBuf.writeEnum(recipe.category());
			Item.STREAM_CODEC.encode(registryFriendlyByteBuf, recipe.inBoat());
			Item.STREAM_CODEC.encode(registryFriendlyByteBuf, recipe.outBoat());
		}
	}
}
