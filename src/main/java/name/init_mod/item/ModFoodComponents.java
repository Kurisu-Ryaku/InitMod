package name.init_mod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {

    //    TOMATO
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(2).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 300), 0.66f).build();
    //    Saturation:饱和度

    public static final FoodComponent PRESERVED_EGG = new FoodComponent.Builder().hunger(10).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 300), 0.66f).build();
}
