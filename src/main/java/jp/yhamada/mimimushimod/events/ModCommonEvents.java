package jp.yhamada.mimimushimod.events;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import jp.yhamada.mimimushimod.init.EntityInit;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = MimiMushiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(EntityInit.MIMI_MUSHI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, MimiMushiEntity::canSpawn);
        });
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event) {
        event.put(
                EntityInit.MIMI_MUSHI.get(),
                MimiMushiEntity.getMimiMushiEntityAttributes().build()
        );
    }
}
