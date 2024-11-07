package thederpgamer.emipluginrecipes.client;

import dev.emi.emi.api.EmiPlugin;
import dev.emi.emi.api.EmiRegistry;
import thederpgamer.emipluginrecipes.client.brewery.BreweryPluginManager;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class EMIPluginRecipesPlugin implements EmiPlugin {

	private BreweryPluginManager breweryPluginManager;
	
	@Override
	public void register(EmiRegistry registry) {
		breweryPluginManager = new BreweryPluginManager(registry);
	}
}