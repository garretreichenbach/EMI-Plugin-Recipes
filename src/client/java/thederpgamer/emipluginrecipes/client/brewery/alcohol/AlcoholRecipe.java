package thederpgamer.emipluginrecipes.client.brewery.alcohol;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import thederpgamer.emipluginrecipes.client.brewery.BreweryPluginManager;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public abstract class AlcoholRecipe implements EmiRecipe {

	public enum BarrelType {
		ANY("Any Barrel", BreweryPluginManager.anyBarrelCategory),
		BIRCH("Birch Barrel", BreweryPluginManager.birchBarrelCategory),
		OAK("Oak Barrel", BreweryPluginManager.oakBarrelCategory),
		JUNGLE("Jungle Barrel", BreweryPluginManager.jungleBarrelCategory),
		SPRUCE("Spruce Barrel", BreweryPluginManager.spruceBarrelCategory),
		ACACIA("Acacia Barrel", BreweryPluginManager.acaciaBarrelCategory),
		DARK_OAK("Dark Oak Barrel", BreweryPluginManager.darkOakBarrelCategory),
		CRIMSON("Crimson Barrel", BreweryPluginManager.crimsonBarrelCategory),
		WARPED("Warped Barrel", BreweryPluginManager.warpedBarrelCategory),
		MANGROVE("Mangrove Barrel", BreweryPluginManager.mangroveBarrelCategory),
		CHERRY("Cherry Barrel", BreweryPluginManager.cherryBarrelCategory);

		private final String name;
		private final EmiRecipeCategory category;

		BarrelType(String name, EmiRecipeCategory category) {
			this.name = name;
			this.category = category;
		}

		public String getName() {
			return name;
		}

		public EmiRecipeCategory getCategory() {
			return category;
		}
	}

	private final EmiRecipeCategory category;
	private final String identifier;
	private final int alcoholLevel;
	private final int difficulty;
	private final BarrelType barrelType;
	private final int brewingTime;
	private final int agingDays;
	private final int distillation;
	private final int distillationTime;

	protected AlcoholRecipe(String identifier, int alcoholLevel, int difficulty, BarrelType barrelType, int brewingTime, int agingDays, int distillation, int distillationTime) {
		this.identifier = identifier;
		this.alcoholLevel = alcoholLevel;
		this.difficulty = difficulty;
		this.barrelType = barrelType;
		this.brewingTime = brewingTime;
		this.agingDays = agingDays;
		this.distillation = distillation;
		this.distillationTime = distillationTime;
		category = barrelType.getCategory();
	}

	protected AlcoholRecipe(String identifier, int alcoholLevel, int difficulty, BarrelType barrelType, int brewingTime, int agingDays, int distillation) {
		this(identifier, alcoholLevel, difficulty, barrelType, brewingTime, agingDays, distillation, 40);
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return category;
	}

	@Override
	public @Nullable Identifier getId() {
		return new Identifier("emipluginrecipes", "/" + identifier);
	}

	@Override
	public int getDisplayWidth() {
		return 100 + (getInputs().size() * 20) + (getOutputs().size() * 20);
	}

	@Override
	public int getDisplayHeight() {
		return 100;
	}

	public void addWidgets(WidgetHolder widgetHolder) {
		widgetHolder.addText(Text.of("Alcohol Level: " + alcoholLevel), 0, 0, 0, false);
		widgetHolder.addText(Text.of("Difficulty: " + difficulty), 0, 10, 0, false);
		widgetHolder.addText(Text.of("Produced In: " + barrelType.getName()), 0, 20, 0, false);
		widgetHolder.addText(Text.of("Brewing Time: " + brewingTime + " s"), 0, 30, 0, false);
		widgetHolder.addText(Text.of("Aging Time: " + agingDays + " days"), 0, 40, 0, false);
		widgetHolder.addText(Text.of("Distillation: " + (distillation == 0 ? "None" : distillation + " times, " + distillationTime + "s each")), 0, 50, 0, false);
		//Align them horizontally, with the arrow in the middle
		for(int i = 0; i < getInputs().size(); i++) widgetHolder.addSlot(getInputs().get(i), 20 + (i * 20), 80);
		widgetHolder.addFillingArrow(27 + (getInputs().size() * 20), 80, brewingTime * 1000);
		for(int i = 0; i < getOutputs().size(); i++) widgetHolder.addSlot(getOutputs().get(i), 60 + (getInputs().size() * 20) + (i * 20), 80).recipeContext(this);
	}
}