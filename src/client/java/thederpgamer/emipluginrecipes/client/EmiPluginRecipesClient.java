package thederpgamer.emipluginrecipes.client;

import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmiPluginRecipesClient implements ClientModInitializer {

	private static EmiPluginRecipesClient instance;
	
	public static EmiPluginRecipesClient getInstance() {
		return instance;
	}

	private Logger logger;

	@Override
	public void onInitializeClient() {
		instance = this;
		logger = LogManager.getLogger("EMIPluginRecipes");
	}
	
	public void logDebug(String message) {
		logger.debug(message);
	}
	
	public void logInfo(String message) {
		logger.info(message);
	}
	
	public void logWarning(String message) {
		logger.warn(message);
	}
	
	public void logError(String message) {
		logger.error(message);
	}
	
	public void logError(String message, Throwable throwable) {
		throwable.printStackTrace();
		message += "\n" + throwable.getMessage() + "\nStacktrace:";
		StringBuilder messageBuilder = new StringBuilder(message);
		for(StackTraceElement element : throwable.getStackTrace()) messageBuilder.append("\n\t").append(element.toString());
		message = messageBuilder.toString();
		logger.error(message);
	}
}
