package thederpgamer.emipluginrecipes.client.brewery.alcohol;

import dev.emi.emi.api.stack.EmiIngredient;
import dev.emi.emi.api.stack.EmiStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class Vodka extends AlcoholRecipe {

	public Vodka() {
		super("vodka", 20, 4, BarrelType.ANY, 15, 0, 3);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack potatoes = new ItemStack(Items.POTATO);
		potatoes.setCount(10);
		return List.of(EmiStack.of(potatoes));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Vodka"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.WHITE.getColorIndex()), List.of(new StatusEffectInstance(StatusEffects.WEAKNESS, 15, 1), new StatusEffectInstance(StatusEffects.POISON, 10, 1))));
		return List.of(EmiStack.of(output));
	}
}
