package name.init_mod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class MetalDetectorItem extends Item {

    //探測深度
    public final int detect_depth = 15;
    public MetalDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        //检测金属（铁、金）
        if (!context.getWorld().isClient) {
            boolean isDetected = false;
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();

            for (int i = 0; i < detect_depth; i++) {
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));
                if (isValuableBlock(state)) {
                    isDetected = true;
                    player.sendMessage(Text.translatable("msg.metal_detector.when_found_former").append(String.valueOf(i)).append(Text.translatable("msg.metal_detector.when_found_latter")) , false);
                    break;
                }
            }
            if (!isDetected) {
                player.sendMessage(Text.translatable("msg.metal_detector.not_found_former").append(String.valueOf(detect_depth)).append(Text.translatable("msg.metal_detector.not_found_latter")), false);
            }
        }

        //削减耐久
        context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.GOLD_ORE) || state.isOf(Blocks.DEEPSLATE_IRON_ORE) || state.isOf(Blocks.DEEPSLATE_GOLD_ORE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.init_mod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
