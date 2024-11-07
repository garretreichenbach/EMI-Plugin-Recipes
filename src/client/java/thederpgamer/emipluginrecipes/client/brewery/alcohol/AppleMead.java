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
import thederpgamer.emipluginrecipes.client.brewery.AlcoholData;
import thederpgamer.emipluginrecipes.client.brewery.BreweryPluginManager;

import java.util.List;
import java.util.Optional;

/**
 * [Description]
 *
 * @author TheDerpGamer
 */
public class AppleMead extends AlcoholData {

	public AppleMead() {
		super(BreweryPluginManager.oakBarrelCategory, "apple_mead", 11, 4, BarrelType.OAK, 4, 4, 0);
	}

	@Override
	public List<EmiIngredient> getInputs() {
		ItemStack sugarcane = new ItemStack(Items.SUGAR_CANE);
		sugarcane.setCount(6);
		ItemStack apples = new ItemStack(Items.APPLE);
		apples.setCount(2);
		return List.of(EmiStack.of(sugarcane), EmiStack.of(apples));
	}

	@Override
	public List<EmiStack> getOutputs() {
		ItemStack output = Items.POTION.getDefaultStack();
		output.setCount(1);
		output.set(DataComponentTypes.CUSTOM_NAME, Text.of("Apple Mead"));
		output.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Optional.ofNullable(Potions.WATER), Optional.of(0xffb84d), List.of(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 150))));
		return List.of(EmiStack.of(output));
	}
}
