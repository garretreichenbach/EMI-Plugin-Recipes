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
public class AppleLiquor extends AlcoholRecipe {

	public AppleLiquor() {
		super("apple_liquor", 14, 5, BarrelType.ACACIA, 16, 6, 3);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack apples = new ItemStack(Items.APPLE);
		apples.setCount(12);
		return List.of(EmiStack.of(apples));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Apple Liquor"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xffdf5050), List.of()));
		return List.of(EmiStack.of(output));
	}
}
