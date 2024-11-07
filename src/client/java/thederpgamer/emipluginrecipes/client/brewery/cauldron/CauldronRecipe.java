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
		return 40;
	}

	@Override
	public void addWidgets(WidgetHolder widgetHolder) {
		widgetHolder.addFillingArrow(30, 30, 5 * 1000);
		if(getInputs().size() > 1) {
			int y = 30 - (getInputs().size() * 10);
			for(int i = 0; i < getInputs().size(); i ++) widgetHolder.addSlot(getInputs().get(i), 0, y + (i * 20));
		} else widgetHolder.addSlot(getInputs().getFirst(), 0, 30);

		if(getOutputs().size() > 1) {
			int y = 30 - (getOutputs().size() * 10);
			for(int i = 0; i < getOutputs().size(); i ++) widgetHolder.addSlot(getOutputs().get(i), 60, y + (i * 20)).recipeContext(this);
		} else widgetHolder.addSlot(getOutputs().getFirst(), 60, 30).recipeContext(this);
	}
}
