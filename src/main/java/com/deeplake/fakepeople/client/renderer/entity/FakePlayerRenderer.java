package com.deeplake.fakepeople.client.renderer.entity;

import com.deeplake.fakepeople.Main;
import com.deeplake.fakepeople.world.entity.FakePeopleBase;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FakePlayerRenderer <T extends FakePeopleBase> extends HumanoidMobRenderer<T,PlayerModel<T>> {
    //    private static final ResourceLocation ZOMBIE_LOCATION = new ResourceLocation("textures/entity/alex.png");
    private static final ResourceLocation ZOMBIE_LOCATION = new ResourceLocation(Main.MOD_ID,"textures/entity/skin/a0.png");
    public static final int SIZE_SKIN = 100;

    private static ResourceLocation[] ALL_LOCATION;

    public FakePlayerRenderer(EntityRendererProvider.Context p_174456_) {
        this(p_174456_, ModelLayers.PLAYER, ModelLayers.PLAYER, ModelLayers.PLAYER);
    }

    public FakePlayerRenderer(EntityRendererProvider.Context p_174458_, ModelLayerLocation p_174459_, ModelLayerLocation p_174460_, ModelLayerLocation p_174461_) {
        this(p_174458_, new PlayerModel<>(p_174458_.bakeLayer(p_174459_),false),
                new PlayerModel<>(p_174458_.bakeLayer(p_174460_),false),
                new PlayerModel<>(p_174458_.bakeLayer(p_174461_),false));
    }

    public FakePlayerRenderer(EntityRendererProvider.Context p_173910_, PlayerModel p_173911_, PlayerModel p_173912_, PlayerModel p_173913_) {
        super(p_173910_, p_173911_, 0.5F);
        this.addLayer(new HumanoidArmorLayer<>(this, p_173912_, p_173913_, p_173910_.getModelManager()));
    }
//
//    public FakePlayerRenderer(EntityRendererProvider.Context p_173910_, M p_173911_, M p_173912_, M p_173913_) {
//        super(p_173910_, p_173911_, 0.5F);
//        this.addLayer(new HumanoidArmorLayer<>(this, p_173912_, p_173913_, p_173910_.getModelManager()));
//    }

    public ResourceLocation getTextureLocation(T p_113771_) {
        if (ALL_LOCATION == null)
        {
            ALL_LOCATION = new ResourceLocation[SIZE_SKIN];
            for (int i = 0; i < SIZE_SKIN; i++) {
                ALL_LOCATION[i] = new ResourceLocation(Main.MOD_ID,"textures/entity/skin/a" + i + ".png");
            }
        }

        int index = (int) (Math.abs(p_113771_.getUUID().getLeastSignificantBits())% SIZE_SKIN);
        return ALL_LOCATION[index];
    }
}
