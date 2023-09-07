package name.init_mod.item;

import name.init_mod.InitMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    //向fabric注冊新的CREATIVE MODE自定義物品分類
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(InitMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup_ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {
                        //將物品添加到自定義物品分類中
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.THIGH);
                        entries.add(Items.LADDER);
                    }).build());

    public static void registerItemGroup() {
        InitMod.LOGGER.info("Registering Item Groups for" + InitMod.MOD_ID);
    }
}
