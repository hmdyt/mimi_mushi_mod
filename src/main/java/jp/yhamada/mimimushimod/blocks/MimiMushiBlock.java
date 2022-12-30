package jp.yhamada.mimimushimod.blocks;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MimiMushiBlock extends Block {

    public MimiMushiBlock(Properties p_49795_) {
        super(p_49795_);
    }


    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide()) {
            if (hand.equals(InteractionHand.MAIN_HAND)) {
                world.explode(player, pos.getX(), pos.getY(), pos.getZ(), 6.0F, true, Explosion.BlockInteraction.BREAK);
            }
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void wasExploded(Level world, BlockPos pos, Explosion explosion) {
        if (!world.isClientSide()) {
            Minecraft.getInstance().player.sendSystemMessage(Component.literal("[mimi] uwa-"));
            world.explode(null, pos.getX(), pos.getY(), pos.getZ(), 6.0F, true, Explosion.BlockInteraction.BREAK);
        }
        super.wasExploded(world, pos, explosion);
    }
}
