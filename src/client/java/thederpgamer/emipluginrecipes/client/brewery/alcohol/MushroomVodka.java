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

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class MushroomVodka extends AlcoholRecipe {

	public MushroomVodka() {
		super("mushroom_vodka", 18, 7, BarrelType.ANY, 18, 0, 5);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack potatoes = new ItemStack(Items.POTATO);
		potatoes.setCount(10);
		ItemStack redMushrooms = new ItemStack(Items.RED_MUSHROOM);
		redMushrooms.setCount(3);
		ItemStack brownMushrooms = new ItemStack(Items.BROWN_MUSHROOM);
		brownMushrooms.setCount(3);
		return List.of(EmiStack.of(potatoes), EmiStack.of(redMushrooms), EmiStack.of(brownMushrooms));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Mushroom Vodka"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xff9999), List.of(
				new StatusEffectInstance(StatusEffects.WEAKNESS, 80, 1),
				new StatusEffectInstance(StatusEffects.NAUSEA, 27, 1),
				new StatusEffectInstance(StatusEffects.NIGHT_VISION, 80, 1),
				new StatusEffectInstance(StatusEffects.BLINDNESS, 2, 1),
				new StatusEffectInstance(StatusEffects.SLOWNESS, 3, 1)
		)));
		return List.of(EmiStack.of(output));
	}
}
