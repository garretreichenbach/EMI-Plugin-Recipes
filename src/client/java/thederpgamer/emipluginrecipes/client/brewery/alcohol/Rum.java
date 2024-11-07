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
public class Rum extends AlcoholRecipe {

	public Rum() {
		super("rum", 30, 6, BarrelType.OAK, 6, 14, 2, 30);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack sugarcane = new ItemStack(Items.SUGAR_CANE);
		sugarcane.setCount(18);
		return List.of(EmiStack.of(sugarcane));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Rum"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.DARK_RED.getColorIndex()), List.of(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 100, 1))));
		return List.of(EmiStack.of(output));
	}
}