package name.init_mod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        //检测金属（铁、金）
        if(!context.getWorld().isClient) {
            String msg = "NOT FOUND ANY METAL WITHIN 15 BLOCKS UNDERGROUND!";

            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            for (int i = 0; i < 15; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                if (isValuableBlock(state)) {
                    msg = "METAL DETECTED "+ i +" BLOCKS UNDER!";
                    break;
                }
            }

            player.sendMessage(Text.literal(msg), false);
        }

        //削减耐久
        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE);
    }
}
