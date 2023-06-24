package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import com.deeplake.fakepeople.world.entity.FakePeopleBase;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Main.MOD_ID);

//    public static final RegistryObject<EntityType<LoongBoatEntity>> LOONG_BOAT_ENTITY = Main.ENTITIES.register(LoongBoatEntity.ENTITY_NAME,
//            () -> EntityType.Builder.<LoongBoatEntity>of(LoongBoatEntity::new, MobCategory.MISC)
//                    .sized(1.375F, 0.5625F)
//                    .clientTrackingRange(10)
//                    .build(LoongBoatEntity.ENTITY_NAME));
    public static final RegistryObject<EntityType<FakePeopleBase>> FAKE_PEOPLE_ENTITY = Main.ENTITIES.register(Main.FAKE_PEOPLE_NAME,
            () -> EntityType.Builder.<FakePeopleBase>of(FakePeopleBase::new, MobCategory.CREATURE)
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(10)
                    .build(Main.FAKE_PEOPLE_NAME));

    private static <T extends Entity> RegistryObject<EntityType<T>> getEntityTypeRegistryObject(String name, EntityType.EntityFactory<T> factory, float sizeXZ, float sizeY, MobCategory category) {
        return ENTITIES.register(name, () -> getBuilder(factory, sizeXZ, sizeY, category)
                .build(name));
    }

    @NotNull
    private static <T extends Entity> EntityType.Builder<T> getBuilder(EntityType.EntityFactory<T> factory, float sizeXZ, float sizeY, MobCategory category) {
        return EntityType.Builder.of(factory, category)
                .sized(sizeXZ, sizeY)
                .clientTrackingRange(8)
                .setShouldReceiveVelocityUpdates(false);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> getEntityTypeRegistryObjectFireImmune(String name, EntityType.EntityFactory<T> factory, float sizeXZ, float sizeY, MobCategory category) {
        return ENTITIES.register(name, () -> getBuilder(factory, sizeXZ, sizeY, category).fireImmune()
                .build(name));
    }



    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(ModEntities.FAKE_PEOPLE_ENTITY.get(), FakePeopleBase.prepareAttributes().build());
//        event.put(ModEntities.WORLD_BOSS.get(), EntityWorldBoss.prepareAttributes().build());
//        event.put(ModEntities.MJDS_SKELETON.get(), EntityMJDSSkeleton.prepareAttributes().build());
//        event.put(ModEntities.MJDS_BLAZE.get(), EntityMJDSBlaze.prepareAttributes().build());
//        event.put(ModEntities.CLOUD_MONSTER.get(), EntityMJDSCloudMonster.prepareAttributes().build());
//        event.put(ModEntities.SHOWER_MONSTER.get(), EntityMJDSStoneEmitter.prepareAttributes().build());
//        event.put(ModEntities.BAT.get(), EntityMJDSBat.prepareAttributes().build());
    }

}
