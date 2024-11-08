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
public class Tequila extends AlcoholRecipe {
	
	public Tequila() {
		super("tequila", 20, 5, BarrelType.BIRCH, 15, 12, 2);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack cactus = Items.CACTUS.getDefaultStack();
		cactus.setCount(8);
		return List.of(EmiStack.of(cactus));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Tequila"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xf5f07e), List.of()));
		return List.of(EmiStack.of(output));
	}
}
