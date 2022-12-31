package jp.yhamada.mimimushimod.client.renderer;

import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.client.models.MimiMushiEntityModel;
import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MimiMushiEntityRenderer extends MobRenderer<MimiMushiEntity, MimiMushiEntityModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(
            MimiMushiMod.MOD_ID,
            "textures/entities/mimi_mushi_entity.png"
    );

    public MimiMushiEntityRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new MimiMushiEntityModel(ctx.bakeLayer(MimiMushiEntityModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(MimiMushiEntity p_114482_) {
        return TEXTURE;
    }
}
