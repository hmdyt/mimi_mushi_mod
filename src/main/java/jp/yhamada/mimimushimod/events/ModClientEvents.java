package jp.yhamada.mimimushimod.events;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.client.models.MimiMushiEntityModel;
import jp.yhamada.mimimushimod.client.renderer.MimiMushiEntityRenderer;
import jp.yhamada.mimimushimod.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MimiMushiMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {
    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.MIMI_MUSHI.get(), MimiMushiEntityRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MimiMushiEntityModel.LAYER_LOCATION, MimiMushiEntityModel::createBodyLayer);
    }
}
