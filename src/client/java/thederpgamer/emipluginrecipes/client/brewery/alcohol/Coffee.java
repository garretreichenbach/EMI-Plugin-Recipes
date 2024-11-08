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
public class Coffee extends AlcoholRecipe {
	
	public Coffee() {
		super("coffee", -6, 3, BarrelType.ANY, 2, 0, 0, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack beans = new ItemStack(Items.COCOA_BEANS);
		beans.setCount(12);
		ItemStack milk = new ItemStack(Items.MILK_BUCKET);
		milk.setCount(2);
		return List.of(EmiStack.of(beans), EmiStack.of(milk));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Coffee"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.BLACK.getColorIndex()), List.of(
				new StatusEffectInstance(StatusEffects.REGENERATION, 5, 0),
				new StatusEffectInstance(StatusEffects.SPEED, 140, 0)
		)));
		return List.of(EmiStack.of(output));
	}
}
