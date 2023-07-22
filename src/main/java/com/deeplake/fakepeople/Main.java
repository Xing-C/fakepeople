package com.deeplake.fakepeople;

import com.deeplake.fakepeople.world.item.FakePeopleItem;
import com.deeplake.fakepeople.world.item.FakePeopltemWithAI;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(Main.MOD_ID)
public class Main {
    public static final String MOD_ID = "fakepeople";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final boolean SHOW_WARN = true;
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES  = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);

    public static final RegistryObject<FakePeopleItem> LOONG_BOAT_ITEM = ITEMS.register(FakePeopleItem.ITEM_NAME,
            FakePeopleItem::new);

    public static final RegistryObject<FakePeopleItem> ITEM_WITH_AI = ITEMS.register(FakePeopltemWithAI.ITEM_NAME,
            FakePeopltemWithAI::new);

    public static final String FAKE_PEOPLE_NAME = "fake_people";
    public static final String FAKE_PEOPLE_AI_NAME = "fake_people_ai";

    public Main() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);
        ENTITIES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
            event.accept(LOONG_BOAT_ITEM);
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
//            event.registerEntityRenderer(LOONG_BOAT_ENTITY.get(), LoongBoatEntityRenderer::new);

        }

        @SubscribeEvent
        public static void registerLayerDefinitions(final EntityRenderersEvent.RegisterLayerDefinitions event) {
//            event.registerLayerDefinition(LoongBoatEntityModel.VanillaModel.getModelLayerLocation(),
//                    LoongBoatEntityModel.VanillaModel::createBodyModel);
        }
    }

    //Logging
    public static void LogWarning(String str, Object...args)
    {
        if (SHOW_WARN)
        {
            LOGGER.warn(String.format(str, args));
        }
    }

    public static void LogWarning(String str)
    {
        if (SHOW_WARN)
        {
            LOGGER.warn(str);
        }
    }

    public static void Log(String str)
    {
        //if (ModConfig.GeneralConf.LOG_ON)
        {
            LOGGER.info(str);
        }
    }

    public static void Log(String str, Object...args)
    {
        //if (ModConfig.GeneralConf.LOG_ON)
        {
            LOGGER.info(String.format(str, args));
        }
    }
}
