package com.merlin2092.variants;

import com.merlin2092.setup.Registration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Variants.MOD_ID)                                                                 // The value here should match an entry in the META-INF/mods.toml file
public class Variants {

    public static final String MOD_ID = "variants";
    private static final Logger LOGGER = LogManager.getLogger();                      // Directly reference a log4j logger.

    public Variants() {
        Registration.init();

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);                                            // Register the setup method for mod-loading

        MinecraftForge.EVENT_BUS.register(this);                                // Register ourselves for server and other game events we are interested in
    }

    private void setup(final FMLCommonSetupEvent event) {
    }
}
