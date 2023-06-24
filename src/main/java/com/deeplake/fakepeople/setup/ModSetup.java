package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {

    public static final CreativeModeTab ITEM_GROUP =
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 4)
                    .title(Component.translatable(Main.MOD_ID+".tab1"))
                    .icon(() -> {
        return new ItemStack(Items.REDSTONE);}).build();


    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
//        bus.addListener(Ores::onBiomeLoadingEvent);
//        bus.addGenericListener(Entity.class, ManaEvents::onAttachCapabilitiesPlayer);
//        bus.addListener(ManaEvents::onPlayerCloned);
//        bus.addListener(ManaEvents::onRegisterCapabilities);
//        bus.addListener(ManaEvents::onWorldTick);
    }

    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
//            Ores.registerConfiguredFeatures();
//            Dimensions.register();
        });
        Messages.register();
    }

}
