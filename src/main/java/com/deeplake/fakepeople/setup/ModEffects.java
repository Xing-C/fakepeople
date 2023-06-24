package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Main.MOD_ID);

//    public static final RegistryObject<MobEffect> INSIDE_MAJOU = register("inside_majou", MobEffectCategory.NEUTRAL, 0xcccccc);
//
//    private static RegistryObject<MobEffect> register(String name, MobEffectCategory category, int color) {
//        return EFFECTS.register(name, () -> new MobEffect(category, color));
//    } //protected access.
}
