package com.github.swcreeperking.wynnautoattack;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Wynnautoattack implements ModInitializer {
    public static final String MOD_ID = "wynnautoattack";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Hello to the World of Wynncraft!");
    }
}
