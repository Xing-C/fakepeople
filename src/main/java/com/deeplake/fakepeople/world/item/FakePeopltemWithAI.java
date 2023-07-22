package com.deeplake.fakepeople.world.item;

import com.deeplake.fakepeople.world.entity.FakePeopleBase;
import com.deeplake.fakepeople.world.entity.FakePeopleWithAI;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class FakePeopltemWithAI extends FakePeopleItem{
    public static final String ITEM_NAME = "ai_fake";
    @NotNull
    public FakePeopleBase getFakeman(Level level, Vec3 loc) {
        return new FakePeopleWithAI(level, loc.x, loc.y, loc.z);
    }
}
