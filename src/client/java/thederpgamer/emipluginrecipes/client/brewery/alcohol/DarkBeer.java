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
public class DarkBeer extends AlcoholRecipe {
	
	public DarkBeer() {
		super("dark_beer", 7, 2, BarrelType.DARK_OAK, 8, 8, 0);
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
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Dark Beer"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0x650013), List.of()));
		return List.of(EmiStack.of(output));
	}
}
