package jp.yhamada.mimimushimod.items;

import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class MimiMushiBomb extends Item {
    private static final double EXPLOSION_RADIUS = 100.0d;

    public MimiMushiBomb(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide()) {
            return super.use(level, player, hand);
        }
        AABB searchArea = new AABB(
                player.getX() - EXPLOSION_RADIUS,
                player.getY() - EXPLOSION_RADIUS,
                player.getZ() - EXPLOSION_RADIUS,
                player.getX() + EXPLOSION_RADIUS,
                player.getY() + EXPLOSION_RADIUS,
                player.getZ() + EXPLOSION_RADIUS
        );
        List<Entity> entities = level.getEntities(player, searchArea);
        for (Entity e : entities) {
            if (e instanceof MimiMushiEntity mimiMushi) {
                level.explode(
                        player,
                        mimiMushi.getX(),
                        mimiMushi.getY(),
                        mimiMushi.getZ(),
                        6.0f,
                        false,
                        Explosion.BlockInteraction.BREAK
                );
                mimiMushi.kill();
            }
        }
        return super.use(level, player, hand);
    }
}
