package com.example.chekushka.init;

import com.example.chekushka.ChekushkaMod;
import com.example.chekushka.item.ChekushkaItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<net.minecraft.world.item.Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ChekushkaMod.MOD_ID);

    public static final RegistryObject<ChekushkaItem> CHEKUSHKA =
            ITEMS.register("chekushka", ChekushkaItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        eventBus.addListener(ModItems::addCreative);
    }

    // Добавляем предмет в раздел "Еда и напитки" (Food and Drinks)
    private static void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(CHEKUSHKA);
        }
    }
}
