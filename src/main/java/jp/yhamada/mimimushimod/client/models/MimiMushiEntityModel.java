// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

package jp.yhamada.mimimushimod.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import jp.yhamada.mimimushimod.MimiMushiMod;
import jp.yhamada.mimimushimod.entities.MimiMushiEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class MimiMushiEntityModel extends EntityModel<MimiMushiEntity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(MimiMushiMod.MOD_ID, "mimi_mushi_entity"),
            "main"
    );
    private final ModelPart leftLeg;
    private final ModelPart leftLeg2;
    private final ModelPart antenna;
    private final ModelPart bb_main;

    public MimiMushiEntityModel(ModelPart root) {
        this.leftLeg = root.getChild("leftLeg");
        this.leftLeg2 = root.getChild("leftLeg2");
        this.antenna = root.getChild("antenna");
        this.bb_main = root.getChild("bb_main");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(-3.5F, 23.5F, 0.5F));

        PartDefinition back_r1 = leftLeg.addOrReplaceChild("back_r1", CubeListBuilder.create().texOffs(14, 8).addBox(-6.9333F, 0.3293F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(16, 16).addBox(-6.9333F, 0.3293F, 1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -5.4612F, 0.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition leftLeg2 = partdefinition.addOrReplaceChild("leftLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7856F, 21.9679F, -0.5F, 0.0F, 0.0F, 1.7453F));

        PartDefinition back_r2 = leftLeg2.addOrReplaceChild("back_r2", CubeListBuilder.create().texOffs(14, 4).addBox(1.6576F, 0.6578F, -5.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(14, 6).addBox(1.6576F, 0.6578F, 1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5594F, 2.4407F, 1.0F, 0.0F, 0.0F, -0.8727F));

        PartDefinition antenna = partdefinition.addOrReplaceChild("antenna", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -11.0F));

        PartDefinition right_r1 = antenna.addOrReplaceChild("right_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.4409F, -5.0002F, 3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9612F, 0.5F, 0.0F, 0.0F, 0.1745F));

        PartDefinition left_r1 = antenna.addOrReplaceChild("left_r1", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5591F, -5.0002F, 3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9612F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -6.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition leftFeather_r1 = bb_main.addOrReplaceChild("leftFeather_r1", CubeListBuilder.create().texOffs(12, 12).addBox(-6.0057F, 0.3741F, -3.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9612F, 0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition rightFeather_r1 = bb_main.addOrReplaceChild("rightFeather_r1", CubeListBuilder.create().texOffs(14, 0).addBox(0.0057F, 0.3741F, -3.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9612F, 0.5F, 0.0F, 0.0F, -0.3491F));

        PartDefinition head_r1 = bb_main.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -2.0F, 8.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(MimiMushiEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        leftLeg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}