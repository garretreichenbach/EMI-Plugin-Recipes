package thederpgamer.emipluginrecipes.client.brewery.alcohol;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.Colors;

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class RedWine extends AlcoholRecipe {

	public RedWine() {
		super("red_wine", 8, 4, BarrelType.ANY, 5, 20, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack berries = Items.SWEET_BERRIES.getDefaultStack();
		berries.setCount(5);
		return List.of(EmiStack.of(berries));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Red Wine"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Colors.RED), List.of()));
		return List.of(EmiStack.of(output));
	}
}
