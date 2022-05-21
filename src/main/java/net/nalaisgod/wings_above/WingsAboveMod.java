package net.nalaisgod.wings_above;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingsAboveMod implements ModInitializer {

	public static final String MOD_ID = "wings_above";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//comment
	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}
