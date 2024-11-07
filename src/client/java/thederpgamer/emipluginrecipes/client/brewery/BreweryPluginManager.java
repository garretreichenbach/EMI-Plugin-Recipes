package thederpgamer.emipluginrecipes.client.brewery;

import dev.emi.emi.api.EmiRegistry;
import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import thederpgamer.emipluginrecipes.client.brewery.alcohol.*;
import thederpgamer.emipluginrecipes.client.brewery.cauldron.FermentedWheat;

import java.util.HashSet;
import java.util.Set;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class BreweryPluginManager {

	public static ItemStack cauldron;
	public static EmiRecipeCategory cauldronCategory;
	
	public static ItemStack anyBarrel;
	public static EmiRecipeCategory anyBarrelCategory;

	public static ItemStack oakBarrel;
	public static EmiRecipeCategory oakBarrelCategory;

	public static ItemStack spruceBarrel;
	public static EmiRecipeCategory spruceBarrelCategory;

	public static ItemStack birchBarrel;
	public static EmiRecipeCategory birchBarrelCategory;

	public static ItemStack jungleBarrel;
	public static EmiRecipeCategory jungleBarrelCategory;

	public static ItemStack acaciaBarrel;
	public static EmiRecipeCategory acaciaBarrelCategory;

	public static ItemStack darkOakBarrel;
	public static EmiRecipeCategory darkOakBarrelCategory;

	public static ItemStack crimsonBarrel;
	public static EmiRecipeCategory crimsonBarrelCategory;

	public static ItemStack warpedBarrel;
	public static EmiRecipeCategory warpedBarrelCategory;

	public static ItemStack mangroveBarrel;
	public static EmiRecipeCategory mangroveBarrelCategory;

	public static ItemStack cherryBarrel;
	public static EmiRecipeCategory cherryBarrelCategory;

	protected final Set<EmiRecipe> recipes = new HashSet<>() {
		{
			//Cauldron
			add(new FermentedWheat());
			//Barrels
			add(new WheatBeer());
			add(new Beer());
			add(new DarkBeer());
			add(new RedWine());
			add(new Mead());
			add(new AppleMead());
			add(new AppleCider());
			add(new AppleLiquor());
			add(new Whiskey());
			add(new Rum());
			add(new Vodka());
			add(new MushroomVodka());
			add(new Gin());
		}
	};

	public BreweryPluginManager(EmiRegistry registry) {
		cauldron = Items.CAULDRON.getDefaultStack();
		cauldronCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/cauldron"), EmiStack.of(cauldron));
		registry.addCategory(cauldronCategory);
		registry.addWorkstation(cauldronCategory, EmiStack.of(cauldron));
		
		anyBarrel = Items.BARREL.getDefaultStack();
		anyBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Any Barrel"));
		anyBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/any_barrel"), EmiStack.of(anyBarrel));
		registry.addCategory(anyBarrelCategory);
		registry.addWorkstation(anyBarrelCategory, EmiStack.of(anyBarrel));

		oakBarrel = Items.BARREL.getDefaultStack();
		oakBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Oak Barrel"));
		oakBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/oak_barrel"), EmiStack.of(oakBarrel));
		registry.addCategory(oakBarrelCategory);
		registry.addWorkstation(oakBarrelCategory, EmiStack.of(oakBarrel));

		spruceBarrel = Items.BARREL.getDefaultStack();
		spruceBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Spruce Barrel"));
		spruceBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/spruce_barrel"), EmiStack.of(spruceBarrel));
		registry.addCategory(spruceBarrelCategory);
		registry.addWorkstation(spruceBarrelCategory, EmiStack.of(spruceBarrel));

		birchBarrel = Items.BARREL.getDefaultStack();
		birchBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Birch Barrel"));
		birchBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/birch_barrel"), EmiStack.of(birchBarrel));
		registry.addCategory(birchBarrelCategory);
		registry.addWorkstation(birchBarrelCategory, EmiStack.of(birchBarrel));

		jungleBarrel = Items.BARREL.getDefaultStack();
		jungleBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Jungle Barrel"));
		jungleBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/jungle_barrel"), EmiStack.of(jungleBarrel));
		registry.addCategory(jungleBarrelCategory);
		registry.addWorkstation(jungleBarrelCategory, EmiStack.of(jungleBarrel));

		acaciaBarrel = Items.BARREL.getDefaultStack();
		acaciaBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Acacia Barrel"));
		acaciaBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/acacia_barrel"), EmiStack.of(acaciaBarrel));
		registry.addCategory(acaciaBarrelCategory);
		registry.addWorkstation(acaciaBarrelCategory, EmiStack.of(acaciaBarrel));

		darkOakBarrel = Items.BARREL.getDefaultStack();
		darkOakBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Dark Oak Barrel"));
		darkOakBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/dark_oak_barrel"), EmiStack.of(darkOakBarrel));
		registry.addCategory(darkOakBarrelCategory);
		registry.addWorkstation(darkOakBarrelCategory, EmiStack.of(darkOakBarrel));

		crimsonBarrel = Items.BARREL.getDefaultStack();
		crimsonBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Crimson Barrel"));
		crimsonBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/crimson_barrel"), EmiStack.of(crimsonBarrel));
		registry.addCategory(crimsonBarrelCategory);
		registry.addWorkstation(crimsonBarrelCategory, EmiStack.of(crimsonBarrel));

		warpedBarrel = Items.BARREL.getDefaultStack();
		warpedBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Warped Barrel"));
		warpedBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/warped_barrel"), EmiStack.of(warpedBarrel));
		registry.addCategory(warpedBarrelCategory);
		registry.addWorkstation(warpedBarrelCategory, EmiStack.of(warpedBarrel));

		mangroveBarrel = Items.BARREL.getDefaultStack();
		mangroveBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Mangrove Barrel"));
		mangroveBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/mangrove_barrel"), EmiStack.of(mangroveBarrel));
		registry.addCategory(mangroveBarrelCategory);
		registry.addWorkstation(mangroveBarrelCategory, EmiStack.of(mangroveBarrel));

		cherryBarrel = Items.BARREL.getDefaultStack();
		cherryBarrel.set(DataComponentTypes.CUSTOM_NAME, Text.of("Cherry Barrel"));
		cherryBarrelCategory = new EmiRecipeCategory(new Identifier("emipluginrecipes", "/cherry_barrel"), EmiStack.of(cherryBarrel));
		registry.addCategory(cherryBarrelCategory);
		registry.addWorkstation(cherryBarrelCategory, EmiStack.of(cherryBarrel));

		for(EmiRecipe entry : recipes) {
			registry.addEmiStackAfter(entry.getOutputs().getFirst(), emiStack -> emiStack.getItemStack().getItem().equals(Items.POTION));
			registry.removeRecipes(emiRecipe -> emiRecipe.getOutputs().getFirst().equals(entry.getOutputs().getFirst()) && !emiRecipe.getCategory().getId().getNamespace().equals("emipluginrecipes"));
			registry.addRecipe(entry);
		}
	}
}