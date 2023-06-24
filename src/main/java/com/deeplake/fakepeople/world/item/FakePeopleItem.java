package com.deeplake.fakepeople.world.item;

import com.deeplake.fakepeople.world.entity.FakePeopleBase;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;
import java.util.function.Predicate;

public class FakePeopleItem extends Item  {
    private static final Predicate<Entity> PICKABLE_ENTITY_PREDICATE =
            EntitySelector.NO_SPECTATORS.and(Entity::isPickable);
    public static final String ITEM_NAME = "basic_fake";
//    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public FakePeopleItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
    }

//    @Override
//    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
//        consumer.accept(new IClientItemExtensions() {
//            private GeoItemRenderer<FakePeopleBase> renderer = null;
//
//            @Override
//            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
//                if (this.renderer == null) {
//                    this.renderer = new GeoItemRenderer<>(new LoongBoatItemModel());
//                }
//                return this.renderer;
//            }
//        });
//    }

//    @Override
//    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {}

    /**
     * @see net.minecraft.world.item.BoatItem#use
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        HitResult hitresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
        if (hitresult.getType() == HitResult.Type.MISS) {
            return InteractionResultHolder.pass(itemstack);
        } else {
            Vec3 vec3 = player.getViewVector(1);

            // when some selectable entity blocks player's head
            var eyePos = player.getEyePosition();
            List<Entity> blockers = level.getEntities(
                    player,
                    player.getBoundingBox().expandTowards(vec3.scale(5)).inflate(1),
                    PICKABLE_ENTITY_PREDICATE);
            if (blockers.stream().anyMatch(
                    ett -> ett.getBoundingBox().inflate(ett.getPickRadius()).contains(eyePos)))
                return InteractionResultHolder.pass(itemstack);

            // put a bot in an empty (collision-free) space
            if (hitresult.getType() == HitResult.Type.BLOCK) {
                var loc = hitresult.getLocation();
                FakePeopleBase fakeman = new FakePeopleBase(level, loc.x, loc.y, loc.z);
                fakeman.setYRot(player.getYRot());
                if (!level.noCollision(fakeman, fakeman.getBoundingBox())) {
                    return InteractionResultHolder.fail(itemstack);
                } else {
                    if (!level.isClientSide()) {
                        level.addFreshEntity(fakeman);
                        level.gameEvent(player, GameEvent.ENTITY_PLACE, hitresult.getLocation());
                        if (!player.getAbilities().instabuild) {
                            itemstack.shrink(1);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
                }
            }

            return InteractionResultHolder.pass(itemstack);
        }
    }

//    @Override
//    public AnimatableInstanceCache getAnimatableInstanceCache() {
//        return this.cache;
//    }

//    @Mod.EventBusSubscriber(modid = LoongBoat.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
//    public static class EventHandler {
//        @SubscribeEvent
//        public static void onPlayerInteract(PlayerInteractEvent.EntityInteractSpecific event) {
//            var itemstack = event.getItemStack();
//            if (itemstack.is(LoongBoat.LOONG_BOAT_ITEM.get())
//                    && event.getTarget() instanceof LoongBoatEntity boat
//                    && boat.getSize() < 2) {
//                var isClient = event.getLevel().isClientSide();
//                boat.setSize((byte)(boat.getSize() + 1));
//                event.setCanceled(true);
//                event.setCancellationResult(InteractionResult.sidedSuccess(isClient));
//            }
//        }
//    }
}
