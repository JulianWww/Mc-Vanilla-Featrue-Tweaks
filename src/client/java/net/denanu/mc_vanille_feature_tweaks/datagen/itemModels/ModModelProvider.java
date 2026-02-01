package net.denanu.mc_vanille_feature_tweaks.datagen.itemModels;

import java.util.LinkedList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.context.CommandContext;

import net.denanu.mc_vanille_feature_tweaks.Mcvanillafeatruetweaks;
import net.denanu.mc_vanille_feature_tweaks.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.select.ComponentContents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;

public class ModModelProvider extends FabricModelProvider {
	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
	}

	@Override
	public void generateItemModels(ItemModelGenerators gen) {
		this.generateBoatModel(gen, ModItems.OAK_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/oak_boat")));
		this.generateBoatModel(gen, ModItems.SPRUCE_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/spruce_boat")));
		this.generateBoatModel(gen, ModItems.BIRCH_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/birch_boat")));
		this.generateBoatModel(gen, ModItems.JUNGLE_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/jungle_boat")));
		this.generateBoatModel(gen, ModItems.ACACIA_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/acacia_boat")));
		this.generateBoatModel(gen, ModItems.CHERRY_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/cherry_boat")));
		this.generateBoatModel(gen, ModItems.DARK_OAK_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/dark_oak_boat")));
		this.generateBoatModel(gen, ModItems.PALE_OAK_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/pale_oak_boat")));
		this.generateBoatModel(gen, ModItems.MANGROVE_SAIL_BOAT, List.of(Identifier.withDefaultNamespace("item/mangrove_boat")));
		
		gen.generateFlatItem(ModItems.BOAT_UPGRADE, ModelTemplates.FLAT_ITEM);
		
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_OAK_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/oak_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_SPRUCE_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/spruce_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_BIRCH_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/birch_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_JUNGLE_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/jungle_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_ACACIA_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/acacia_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_CHERRY_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/cherry_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_DARK_OAK_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/dark_oak_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_PALE_OAK_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/pale_oak_boat"))));
		this.generateMediumBoatModel(gen, ModItems.MEDIUM_MANGROVE_BOAT, new LinkedList<>(List.of(Identifier.withDefaultNamespace("item/mangrove_boat"))));
	}
	
	private ItemModel.Unbaked getBoatSailModel(Item item, String color, List<Identifier> base, ItemModelGenerators gen) {
		TextureMapping model;
		ModelTemplate template;
		Identifier sail_id = Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "item/" + color + "_sail");
		if (base.size() == 1) {
			model = TextureMapping.layered(base.getFirst(), sail_id);
			template = ModelTemplates.TWO_LAYERED_ITEM;
		}
		else {
			model = TextureMapping.layered(base.getFirst(), base.getLast(), sail_id);
			template = ModelTemplates.THREE_LAYERED_ITEM;
		}
		return ItemModelUtils.plainModel(
				template.create(
						ModelLocationUtils.getModelLocation(item, "_" + color + "_sail"), 
						model, 
						gen.modelOutput
					)
					
				);
	}
	
	private void generateMediumBoatModel(ItemModelGenerators gen, Item item, List<Identifier> baseTexture) {
		baseTexture.add(Identifier.fromNamespaceAndPath(Mcvanillafeatruetweaks.MOD_ID, "item/medium_boat_overlay"));
		generateBoatModel(gen, item, baseTexture);
	}
	
	private void generateBoatModel(ItemModelGenerators gen, Item item, List<Identifier> baseTexture) {
		ItemModel.Unbaked black_boat = this.getBoatSailModel(item, "black", baseTexture, gen);
		ItemModel.Unbaked blue_boat = this.getBoatSailModel(item, "blue", baseTexture, gen);
		ItemModel.Unbaked brown_boat = this.getBoatSailModel(item, "brown", baseTexture, gen);
		ItemModel.Unbaked cyan_boat = this.getBoatSailModel(item, "cyan", baseTexture, gen);
		ItemModel.Unbaked gray_boat = this.getBoatSailModel(item, "gray", baseTexture, gen);
		ItemModel.Unbaked green_boat = this.getBoatSailModel(item, "green", baseTexture, gen);
		ItemModel.Unbaked light_blue_boat = this.getBoatSailModel(item, "light_blue", baseTexture, gen);
		ItemModel.Unbaked light_gray_boat = this.getBoatSailModel(item, "light_gray", baseTexture, gen);
		ItemModel.Unbaked lime_boat = this.getBoatSailModel(item, "lime", baseTexture, gen);
		ItemModel.Unbaked magenta_boat = this.getBoatSailModel(item, "magenta", baseTexture, gen);
		ItemModel.Unbaked orange_boat = this.getBoatSailModel(item, "orange", baseTexture, gen);
		ItemModel.Unbaked pink_boat = this.getBoatSailModel(item, "pink", baseTexture, gen);
		ItemModel.Unbaked purple_boat = this.getBoatSailModel(item, "purple", baseTexture, gen);
		ItemModel.Unbaked red_boat = this.getBoatSailModel(item, "red", baseTexture, gen);
		ItemModel.Unbaked white_boat = this.getBoatSailModel(item, "white", baseTexture, gen);
		ItemModel.Unbaked yellow_boat = this.getBoatSailModel(item, "yellow", baseTexture, gen);
		
		
		gen.itemModelOutput.accept(
				item,
				ItemModelUtils.select(
						new ComponentContents<>(DataComponents.BASE_COLOR), 
								ItemModelUtils.when(DyeColor.BLACK, black_boat),
								ItemModelUtils.when(DyeColor.BLUE, blue_boat),
								ItemModelUtils.when(DyeColor.BROWN, brown_boat),
								ItemModelUtils.when(DyeColor.CYAN, cyan_boat),
								ItemModelUtils.when(DyeColor.GRAY, gray_boat),
								ItemModelUtils.when(DyeColor.GREEN, green_boat),
								ItemModelUtils.when(DyeColor.LIGHT_BLUE, light_blue_boat),
								ItemModelUtils.when(DyeColor.LIGHT_GRAY, light_gray_boat),
								ItemModelUtils.when(DyeColor.LIME, lime_boat),
								ItemModelUtils.when(DyeColor.MAGENTA, magenta_boat),
								ItemModelUtils.when(DyeColor.ORANGE, orange_boat),
								ItemModelUtils.when(DyeColor.PINK, pink_boat),
								ItemModelUtils.when(DyeColor.PURPLE, purple_boat),
								ItemModelUtils.when(DyeColor.RED, red_boat),
								ItemModelUtils.when(DyeColor.WHITE, white_boat),
								ItemModelUtils.when(DyeColor.YELLOW, yellow_boat)
						));
	}

	@Override
	public String getName() {
		return Mcvanillafeatruetweaks.MOD_ID + " model generator";
	}
}