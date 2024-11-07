package thederpgamer.emipluginrecipes.client.brewery.cauldron;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class FermentedWheat extends CauldronRecipe {
	
	public FermentedWheat() {
		super("fermented_wheat");
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack wheat = Items.WHEAT.getDefaultStack();
		wheat.setCount(1);
		return List.of(EmiStack.of(wheat));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Fermented Wheat Brew"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0x169c9c), List.of()));
		return List.of(EmiStack.of(output));
	}
}
