package thederpgamer.emipluginrecipes.client.brewery;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public abstract class AlcoholData implements EmiRecipe {

	public enum BarrelType {
		ANY("Any Barrel"),
		BIRCH("Birch Barrel"),
		OAK("Oak Barrel"),
		JUNGLE("Jungle Barrel"),
		SPRUCE("Spruce Barrel"),
		ACACIA("Acacia Barrel"),
		DARK_OAK("Dark Oak Barrel"),
		CRIMSON("Crimson Barrel"),
		WARPED("Warped Barrel"),
		MANGROVE("Mangrove Barrel"),
		CHERRY("Cherry Barrel");

		private final String name;

		BarrelType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
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

	protected AlcoholData(EmiRecipeCategory category, String identifier, int alcoholLevel, int difficulty, BarrelType barrelType, int brewingTime, int agingDays, int distillation) {
		this.category = category;
		this.identifier = identifier;
		this.alcoholLevel = alcoholLevel;
		this.difficulty = difficulty;
		this.barrelType = barrelType;
		this.brewingTime = brewingTime;
		this.agingDays = agingDays;
		this.distillation = distillation;
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
		return 80;
	}

	@Override
	public int getDisplayHeight() {
		return 40;
	}

	public void addWidgets(WidgetHolder widgetHolder) {
		widgetHolder.addText(Text.of("Alcohol Level: " + alcoholLevel), 0, 0, 0, false);
		widgetHolder.addText(Text.of("Difficulty: " + difficulty), 0, 5, 0, false);
		widgetHolder.addText(Text.of("Produced In: " + barrelType.getName()), 0, 10, 0, false);
		widgetHolder.addText(Text.of("Brewing Time: " + brewingTime + " seconds"), 0, 15, 0, false);
		widgetHolder.addText(Text.of("Aging Time: " + agingDays + " days"), 0, 20, 0, false);
		widgetHolder.addText(Text.of("Distillation: " + (distillation == 0 ? "None" : distillation + " times")), 0, 25, 0, false);
		widgetHolder.addFillingArrow(30, 30, brewingTime * 1000);
		widgetHolder.addSlot(getInputs().getFirst(), 0, 30);
		widgetHolder.addSlot(getOutputs().getFirst(), 60, 30).recipeContext(this);
	}
}
