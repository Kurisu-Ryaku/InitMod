package name.init_mod.item;

import name.init_mod.InitMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//这是一个注册物品的辅助类
public class ModItems {

    //向Fabric注册新物品
    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(InitMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        InitMod.LOGGER.info("Registering Mod Items for" + InitMod.MOD_ID);
    }
}
