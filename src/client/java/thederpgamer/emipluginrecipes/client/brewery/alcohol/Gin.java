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
public class Gin extends AlcoholRecipe {
	
	public Gin() {
		super("gin", 20, 1, BarrelType.ANY, 6, 0, 2);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack wheat = new ItemStack(Items.WHEAT);
		wheat.setCount(9);
		ItemStack blueOrchids = new ItemStack(Items.BLUE_ORCHID);
		blueOrchids.setCount(6);
		ItemStack cornFlowers = new ItemStack(Items.CORNFLOWER);
		cornFlowers.setCount(6);
		ItemStack apples = new ItemStack(Items.APPLE);
		apples.setCount(1);
		return List.of(EmiStack.of(wheat), EmiIngredient.of(List.of(EmiStack.of(blueOrchids), EmiStack.of(cornFlowers))), EmiStack.of(apples));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Gin"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0x99ddff), List.of()));
		return List.of(EmiStack.of(output));
	}
}
