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
public class PotatoSoup extends AlcoholRecipe {

	public PotatoSoup() {
		super("potato_soup", 0, 1, BarrelType.ANY, 3, 0, 0, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack potatoes = new ItemStack(Items.POTATO);
		potatoes.setCount(5);
		ItemStack grass = new ItemStack(Items.SHORT_GRASS);
		grass.setCount(3);
		return List.of(EmiStack.of(potatoes), EmiStack.of(grass));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.ITEM_NAME, Text.of("Potato Soup"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(Formatting.GOLD.getColorIndex()), List.of(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0))));
		return List.of(EmiStack.of(output));
	}
}
