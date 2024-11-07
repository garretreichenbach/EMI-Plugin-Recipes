package thederpgamer.emipluginrecipes.client.brewery.alcohol;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import thederpgamer.emipluginrecipes.client.brewery.AlcoholData;
import thederpgamer.emipluginrecipes.client.brewery.BreweryPluginManager;

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class Mead extends AlcoholData {
	
	public Mead() {
		super(BreweryPluginManager.oakBarrelCategory, "mead", 9, 2, BarrelType.OAK, 3, 4, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack sugarcane = new ItemStack(Items.SUGAR_CANE);
		sugarcane.setCount(6);
		return List.of(EmiStack.of(sugarcane));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Mead"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xffb84d), List.of()));
		return List.of(EmiStack.of(output));
	}
}
