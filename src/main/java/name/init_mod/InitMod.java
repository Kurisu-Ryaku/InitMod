package name.init_mod;

import name.init_mod.block.ModBlocks;
import name.init_mod.item.ModItemGroups;
import name.init_mod.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static name.init_mod.item.FuelItemRegister.registerModFuelItems;

public class InitMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "init-mod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerItemGroup();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		registerModFuelItems();
	}
}