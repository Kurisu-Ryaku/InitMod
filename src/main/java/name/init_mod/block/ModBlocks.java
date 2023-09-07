package name.init_mod.block;

import name.init_mod.InitMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    //新建一個方塊， 使用copyOf讓它擁有和IRON_BLCOK相同的屬性（挖掘時間、爆炸抗性...）又覆蓋其sound為紫水晶
    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK))
            );
    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK))
    );

    //新建一個方塊， 使用create自定義其屬性
//    public static final Block RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
//            new Block(FabricBlockSettings.create().)
//    );

    //添加方塊
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(InitMod.MOD_ID, name), block);
    }

    //添加方塊item
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(InitMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings())
                );
    }

    public static void registerModBlocks() {
        InitMod.LOGGER.info("Registering ModBlcoks for" + InitMod.MOD_ID);
    }
}
