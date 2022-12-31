package jp.yhamada.mimimushimod.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class MimiMushiEntity extends Bee {
    public MimiMushiEntity(EntityType<? extends Bee> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder getMimiMushiEntityAttributes() {
        return Mob.createMobAttributes()
                .add(ForgeMod.ENTITY_GRAVITY.get(), 0.5f)
                .add(Attributes.MAX_HEALTH, 25.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.7246D)
                .add(Attributes.ATTACK_DAMAGE, 3D)
                .add(Attributes.FLYING_SPEED, 1.0D);
    }

}
