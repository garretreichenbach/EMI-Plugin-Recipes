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
public class Absinthe extends AlcoholRecipe {

	public Absinthe() {
		super("absinthe", 42, 8, BarrelType.ANY, 3, 0, 6, 80);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack grass = Items.SHORT_GRASS.getDefaultStack();
		grass.setCount(15);
		return List.of(EmiStack.of(grass));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Absinthe"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.DARK_GREEN.getColorIndex()), List.of(new StatusEffectInstance(StatusEffects.POISON, 25, 0))));
		return List.of(EmiStack.of(output));
	}
}
