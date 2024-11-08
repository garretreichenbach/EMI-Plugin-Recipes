package thederpgamer.emipluginrecipes.client.brewery.cauldron;

import dev.emi.emi.api.recipe.EmiRecipe;
import dev.emi.emi.api.recipe.EmiRecipeCategory;
import dev.emi.emi.api.widget.WidgetHolder;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import thederpgamer.emipluginrecipes.client.brewery.BreweryPluginManager;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public abstract class CauldronRecipe implements EmiRecipe {

	private final String identifier;

	protected CauldronRecipe(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public EmiRecipeCategory getCategory() {
		return BreweryPluginManager.cauldronCategory;
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
		return 30 + (Math.max(getInputs().size(), getOutputs().size()) * 20);
	}

	@Override
	public void addWidgets(WidgetHolder widgetHolder) {
		for(int i = 0; i < getInputs().size(); i ++) widgetHolder.addSlot(getInputs().get(i), 0, 30 + (i * 20));
		widgetHolder.addFillingArrow(27, 30, 5 * 1000);
		for(int i = 0; i < getOutputs().size(); i ++) widgetHolder.addSlot(getOutputs().get(i), 60, 30 + (i * 20)).recipeContext(this);
	}
}
