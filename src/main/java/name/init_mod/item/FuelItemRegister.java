package name.init_mod.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelItemRegister {
    public static void registerModFuelItems() {
        FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 800);
    }
}
