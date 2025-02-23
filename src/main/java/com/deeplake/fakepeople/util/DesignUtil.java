package com.deeplake.fakepeople.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.sounds.MusicManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import static com.deeplake.fakepeople.util.IDLNBTDef.NO_REVIVE;

public class DesignUtil {

//    public static boolean isNearBoss(Player entity) {
//        //should improve. not good
//
//        if (entity.getServer() != null)
//        {
//            Collection<CustomServerBossInfo> collection = entity.getServer().getCustomBossEvents().getEvents();
////            for (CustomServerBossInfo info: collection
////                 ) {
////                if (info.shouldPlayBossMusic())
////            } player list is private, darn
//
//            return  !collection.isEmpty();
//        }
//        return false;
//    }

    public static boolean isInMJDS(Entity entity)
    {
        return false;
//        Block block = entity.level.getBlockState(getBlockPosBelowThatAffectsMyMovement(entity)).getBlock();
//        return block instanceof BaseBlockMJDS;// || block instanceof LadderBlockMJDS || block instanceof BlockWallGlass;
    }

//    public static boolean isCreatureMJDS(LivingEntity entity)
//    {
//        if (entity instanceof AbstractSkeletonEntity)//including wither, stray and normal
//        {
//            return entity.getMainHandItem().getItem() instanceof SwordItem
//                    || entity.getOffhandItem().getItem() instanceof ShieldItem;
//        }
//        else return entity instanceof IMjdsMonster || entity instanceof Witch;
//    }

    public static boolean canRevive(Entity entity)
    {
        return entity != null && IDLNBTUtil.GetInt(entity, NO_REVIVE, 0) <= 0;
    }

    public static boolean isWithOffsetMJDS(Level world, BlockPos pos, Entity entity)
    {
        //todo
        return false;
//        return world.getBlockState(getBlockPosBelowThatAffectsMyMovement(entity).offset(pos)).getBlock() instanceof IBlockMJDS;
    }

    public static void applyMajou(Entity entity) {
        Level level = entity.level();
        if (entity instanceof LivingEntity living)
        {
            if (!level.isClientSide) {
                majouBuff(living);
            } else {
                playMusic(entity);
            }
        }
    }

    public static void applyMajouNoMusic(Entity entity) {
        Level level = entity.level();
        if (entity instanceof LivingEntity living)
        {
            if (!level.isClientSide) {
                majouBuff(living);
            } else {
//                playMusic(entity);
            }
        }
    }

    public static void applyMajouNoAdv(Entity entity) {
        Level level = entity.level();
        if (entity instanceof LivingEntity living)
        {
            if (!level.isClientSide) {
                majouBuff(living, true);
            } else {

            }
        }
    }

    private static void playMusic(Entity entity) {
        if (entity == Minecraft.getInstance().player)
        {
            boolean music = true;
            Player player = (Player) entity;
            music = AdvancementUtil.checkAdvClient(player, AdvancementUtil.TRIANGLE_BIT);

            if (music)
            {
                MusicManager musicManager = Minecraft.getInstance().getMusicManager();
//                if (!musicManager.isPlayingMusic(ModSounds.MUSIC_DUNGEON)) {
//                    musicManager.stopPlaying();
//                    musicManager.startPlaying(ModSounds.MUSIC_DUNGEON);
//                }
            }
        }
    }

    public static void majouBuff(LivingEntity living) {
        majouBuff(living, false);
    }

    public static void majouBuff(LivingEntity living, boolean ignoreAdv) {
        if (living instanceof ServerPlayer serverPlayer)
        {
            int level = 0;
            if (ignoreAdv || AdvancementUtil.hasAdvancement(serverPlayer, AdvancementUtil.FEATHER))
            {
                level |= AdvancementUtil.FEATHER_BIT;
            }

            if (ignoreAdv || AdvancementUtil.hasAdvancement(serverPlayer, AdvancementUtil.SHOES))
            {
                level |= AdvancementUtil.SHOES_BIT;
            }

            //no adv version also has no music
            if (!ignoreAdv && AdvancementUtil.hasAdvancement(serverPlayer, AdvancementUtil.TRIANGLE))
            {
                level |= AdvancementUtil.TRIANGLE_BIT;
            }

            if (level != 0)
            {
//                serverPlayer.addEffect(new MobEffectInstance(ModEffects.INSIDE_MAJOU.get(),
//                        100, level, true, false, !ignoreAdv, null));
            }
        }
        else {
//            living.addEffect(new MobEffectInstance(ModEffects.INSIDE_MAJOU.get(),
//                    100, 0, true, false, !ignoreAdv, null));
        }
    }
}
