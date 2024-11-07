package thederpgamer.emipluginrecipes.client.brewery.alcohol;

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
public class Beer extends AlcoholRecipe {
	
	public Beer() {
		super("beer", 6, 1, BarrelType.ANY, 8, 3, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack wheat = Items.WHEAT.getDefaultStack();
		wheat.setCount(6);
		return List.of(EmiStack.of(wheat));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Beer"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xffd333), List.of()));
		return List.of(EmiStack.of(output));
	}
}
