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
public class Eggnog extends AlcoholRecipe {
	
	public Eggnog() {
		super("eggnog", 10, 4, BarrelType.ANY, 2, 3, 0, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack egg = new ItemStack(Items.EGG);
		egg.setCount(5);
		ItemStack sugar = new ItemStack(Items.SUGAR);
		sugar.setCount(2);
		ItemStack milk = new ItemStack(Items.MILK_BUCKET);
		milk.setCount(1);
		return List.of(EmiStack.of(egg), EmiStack.of(sugar), EmiStack.of(milk));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Eggnog"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xffe680), List.of()));
		return List.of(EmiStack.of(output));
	}
}
