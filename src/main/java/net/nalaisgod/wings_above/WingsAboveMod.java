package net.nalaisgod.wings_above;

import net.fabricmc.api.ModInitializer;
import net.nalaisgod.wings_above.block.ModBlocks;
import net.nalaisgod.wings_above.effect.ModEffects;
import net.nalaisgod.wings_above.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WingsAboveMod implements ModInitializer {

	public static final String MOD_ID = "wings_above";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
//comment
	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerEffects();

	}
}
