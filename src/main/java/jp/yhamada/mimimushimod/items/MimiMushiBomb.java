package jp.yhamada.mimimushimod.items;

import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
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
import java.util.Objects;

public class MimiMushiBomb extends Item {
    private static final double SEARCH_RADIUS = 100.0d;

    public MimiMushiBomb(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (hand.equals(InteractionHand.MAIN_HAND)) {
            var mimiMushiList = getMimiMushi(level, player);
            if (level.isClientSide()) {
                for (var e : mimiMushiList) {
                    showPreExplosionParticles(level, player, e);
                }
            } else {
                explodeMimiMushi(level, player, mimiMushiList);
            }
        }
        return super.use(level, player, hand);
    }

    private List<MimiMushiEntity> getMimiMushi(Level level, Player player) {
        AABB searchArea = new AABB(
                player.getX() - SEARCH_RADIUS,
                player.getY() - SEARCH_RADIUS,
                player.getZ() - SEARCH_RADIUS,
                player.getX() + SEARCH_RADIUS,
                player.getY() + SEARCH_RADIUS,
                player.getZ() + SEARCH_RADIUS
        );
        List<MimiMushiEntity> MimiMushiList = level
                .getEntities(player, searchArea)
                .stream()
                .map(entity -> {
                    if (entity instanceof MimiMushiEntity mimiMushiEntity) {
                        return mimiMushiEntity;
                    } else {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .toList();
        return MimiMushiList;
    }

    private void explodeMimiMushi(Level level, Player player, List<MimiMushiEntity> mimiMushiEntityList) {
        for (MimiMushiEntity e : mimiMushiEntityList) {
            level.explode(
                    player,
                    e.getX(),
                    e.getY(),
                    e.getZ(),
                    6.0f,
                    false,
                    Explosion.BlockInteraction.BREAK
            );
        }
    }

    private void showPreExplosionParticles(Level level, Player player, Entity entity) {
        var playerPos = player.getPosition(0.0f).add(0, 0.7, 0);
        var entityPos = entity.getPosition(0.5f);
        for (float delta = 0.0f; delta < 1.0f; delta += 1e-2f) {
            var x = Mth.lerp(delta, playerPos.x(), entityPos.x());
            var y = Mth.lerp(delta, playerPos.y(), entityPos.y());
            var z = Mth.lerp(delta, playerPos.z(), entityPos.z());
            level.addParticle(ParticleTypes.FLAME, x, y, z, 0, 0, 0);
        }
    }
}
