package com.deeplake.fakepeople.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class FakePeopleNoAI extends FakePeopleBase{
    public FakePeopleNoAI(EntityType<? extends PathfinderMob> p_21683_, Level p_21684_) {
        super(p_21683_, p_21684_);
    }

    public FakePeopleNoAI(Level level, double x, double y, double z) {
        super(level, x, y, z);
    }
}
