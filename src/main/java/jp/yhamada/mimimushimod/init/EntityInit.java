package jp.yhamada.mimimushimod.init;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(
            ForgeRegistries.ENTITY_TYPES,
            MimiMushiMod.MOD_ID
    );
    public static final RegistryObject<EntityType<MimiMushiEntity>> MIMI_MUSHI = ENTITIES.register(
            "mimi_mushi",
            () -> EntityType.Builder
                    .of(MimiMushiEntity::new, MobCategory.CREATURE)
                    .sized(1.0f, 1.0f)
                    .build(MimiMushiMod.MOD_ID + ":mimi_mushi")
    );
}
