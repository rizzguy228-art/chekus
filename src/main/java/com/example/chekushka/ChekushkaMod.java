package com.example.chekushka;

import com.example.chekushka.init.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChekushkaMod.MOD_ID)
public class ChekushkaMod {

    public static final String MOD_ID = "chekushka";

    public ChekushkaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(modEventBus);
    }
}
