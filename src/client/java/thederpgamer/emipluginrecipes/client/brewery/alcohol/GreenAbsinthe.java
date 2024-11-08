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
public class GreenAbsinthe extends AlcoholRecipe {
	
	public GreenAbsinthe() {
		super("green_absinthe", 46, 9, BarrelType.ANY, 5, 0, 6, 85);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack grass = Items.SHORT_GRASS.getDefaultStack();
		grass.setCount(17);
		ItemStack potato = Items.POISONOUS_POTATO.getDefaultStack();
		potato.setCount(2);
		return List.of(EmiStack.of(grass), EmiStack.of(potato));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Green Absinthe"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.GREEN.getColorIndex()), List.of(
				new StatusEffectInstance(StatusEffects.POISON, 40, 0), 
				new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1),
				new StatusEffectInstance(StatusEffects.NIGHT_VISION, 60, 0))));
		return List.of(EmiStack.of(output));
	}
}
