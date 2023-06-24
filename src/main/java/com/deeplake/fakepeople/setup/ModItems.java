package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties();
    public static final Item.Properties ITEM_PROPERTIES_HIDDEN = new Item.Properties();

    //Advancements
    public static final RegistryObject<Item> feather = ITEMS.register("feather", () -> new Item(ITEM_PROPERTIES_HIDDEN));

}
