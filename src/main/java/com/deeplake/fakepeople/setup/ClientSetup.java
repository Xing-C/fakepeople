package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import com.deeplake.fakepeople.client.renderer.entity.FakePlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.deeplake.fakepeople.setup.ModEntities.FAKE_PEOPLE_AI_ENTITY;
import static com.deeplake.fakepeople.setup.ModEntities.FAKE_PEOPLE_ENTITY;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {


        });
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
//        event.registerLayerDefinition(ThiefModel.THIEF_LAYER, ThiefModel::createBodyLayer);
//        event.registerLayerDefinition(WorldBossModel.NORMAL_LAYER, WorldBossModel::createBodyLayer);
//        event.registerLayerDefinition(ModelStoneEmitter.LAYER_LOCATION, ModelStoneEmitter::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(FAKE_PEOPLE_ENTITY.get(), FakePlayerRenderer::new);
        event.registerEntityRenderer(FAKE_PEOPLE_AI_ENTITY.get(), FakePlayerRenderer::new);

    }
}
