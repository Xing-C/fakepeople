package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import com.deeplake.fakepeople.client.renderer.entity.FakePlayerRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.deeplake.fakepeople.setup.ModEntities.FAKE_PEOPLE_ENTITY;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
//            MenuScreens.register(ModBlocks.POWERGEN_CONTAINER.get(), PowergenScreen::new);
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.SP_GLASS.get(), RenderType.translucent());
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.DARKNESS.get(), RenderType.translucent());
//            PowergenRenderer.register();

        });
//        MinecraftForge.EVENT_BUS.addListener(KeyInputHandler::onKeyInput);
//        KeyBindings.init();

//        ModSounds.initMusic();
//        OverlayRegistry.registerOverlayAbove(HOTBAR_ELEMENT, "name", ManaOverlay.HUD_MANA);
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
//        event.registerEntityRenderer(ModEntities.WORLD_BOSS.get(), BossRenderer::new);
//        event.registerEntityRenderer(ModEntities.REVIVE_MIST.get(), VoidRenderer::new);
//        event.registerEntityRenderer(ModEntities.DAMP_SPHERE.get(), VoidRenderer::new);
//        event.registerEntityRenderer(ModEntities.MJDS_SKELETON.get(), SkeletonRenderer::new);
//        event.registerEntityRenderer(ModEntities.MJDS_BLAZE.get(), BlazeRenderer::new);
//        event.registerEntityRenderer(ModEntities.BULLET1.get(), ThrownItemRenderer::new);
//        event.registerEntityRenderer(ModEntities.BULLET2.get(), ThrownItemRenderer::new);
//        event.registerEntityRenderer(ModEntities.BULLET_SHOWER.get(), ThrownItemRenderer::new);
//        event.registerEntityRenderer(ModEntities.BULLET_KB.get(), ThrownItemRenderer::new);
//        event.registerEntityRenderer(ModEntities.CLOUD_MONSTER.get(), HumanoidRenderer::new);
//        event.registerEntityRenderer(ModEntities.SHOWER_MONSTER.get(), ShowerMonsterRenderer::new);
//        event.registerEntityRenderer(ModEntities.BAT.get(), BatRenderer::new);
    }
}
