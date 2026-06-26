package com.example.chekushka.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChekushkaItem extends Item {

    // Еда: 4 полоски голода = 8 единиц (1 полоска = 2 единицы), насыщение 0.3
    public static final FoodProperties CHEKUSHKA_FOOD = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(0.3f)
            .alwaysEat()
            .build();

    public ChekushkaItem() {
        super(new Item.Properties()
                .food(CHEKUSHKA_FOOD)
                .stacksTo(16));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide && entity instanceof Player player) {
            // Сила III — 1 минута (1200 тиков)
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 2, false, true, true));

            // Скорость IV — 1 минута
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 3, false, true, true));

            // Слепота I — 1 минута
            player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200, 0, false, true, true));
        }

        return result;
    }
}
