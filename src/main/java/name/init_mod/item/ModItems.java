package name.init_mod.item;

import name.init_mod.InitMod;
import name.init_mod.item.custom.MetalDetectorItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

//这是一个注册物品的辅助类
public class ModItems {

    //在这里声明物品
    public static final Item THIGH = registerItem("thigh", new Item(new FabricItemSettings()));
    public static final Item METAL_DETECTOR = registerItem("metal_detector", new MetalDetectorItem(new FabricItemSettings().maxDamage(32)));

    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    //将物品添加到物品分类组
    private static void addItemsToItemIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(THIGH);
        entries.add(RUBY);
        entries.add(RAW_RUBY);
    }

    //向Fabric注册新物品
    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(InitMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        InitMod.LOGGER.info("Registering Mod Items for" + InitMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToItemIngredientItemGroup);
    }
}
