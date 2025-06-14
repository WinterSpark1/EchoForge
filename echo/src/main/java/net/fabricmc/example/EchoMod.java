package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EchoMod implements ModInitializer {
    public static final String MOD_ID = "echo";
    public static final Logger LOGGER = LogManager.getLogger("echo");

    @Override
    public void onInitialize() {
        LOGGER.info("Echo mod initialized.");

        ModItems.registerModItems();
    }
}

