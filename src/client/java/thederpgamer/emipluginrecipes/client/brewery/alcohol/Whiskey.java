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
public class Whiskey extends AlcoholRecipe {

	public Whiskey() {
		super("whiskey", 26, 7, BarrelType.SPRUCE, 10, 18, 2, 50);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack wheat = new ItemStack(Items.WHEAT);
		wheat.setCount(10);
		return List.of(EmiStack.of(wheat));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Apple Cider"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xf86820), List.of()));
		return List.of(EmiStack.of(output));
	}
}
