package com.deeplake.fakepeople.setup;

import com.deeplake.fakepeople.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.deeplake.fakepeople.util.CommonDef.JUMP_FACTOR_MJDS_BLOCK;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
    static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Main.MOD_ID);

    // Some common properties for our blocks and items
    public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops();
//    public static final RegistryObject<Block> MYSTERIOUS_ORE_DEEPSLATE = BLOCKS.register("mysterious_ore_deepslate", () -> new Block(BLOCK_PROPERTIES));
//    public static final RegistryObject<Item> MYSTERIOUS_ORE_DEEPSLATE_ITEM = fromBlock(MYSTERIOUS_ORE_DEEPSLATE);
//    public static final RegistryObject<Block> MYSTERIOUS_ORE_END = BLOCKS.register("mysterious_ore_end", () -> new Block(BLOCK_PROPERTIES));
//    public static final RegistryObject<Item> MYSTERIOUS_ORE_END_ITEM = fromBlock(MYSTERIOUS_ORE_END);
//    public static final RegistryObject<Block> MYSTERIOUS_ORE_NETHER = BLOCKS.register("mysterious_ore_nether", () -> new Block(BLOCK_PROPERTIES));
//    public static final RegistryObject<Item> MYSTERIOUS_ORE_NETHER_ITEM = fromBlock(MYSTERIOUS_ORE_NETHER);
//    public static final RegistryObject<Block> MYSTERIOUS_ORE_OVERWORLD = BLOCKS.register("mysterious_ore_overworld", () -> new Block(BLOCK_PROPERTIES));
//    public static final RegistryObject<Item> MYSTERIOUS_ORE_OVERWORLD_ITEM = fromBlock(MYSTERIOUS_ORE_OVERWORLD);
//    public static final RegistryObject<MenuType<PowergenContainer>> POWERGEN_CONTAINER = Registration.CONTAINERS.register("powergen",
//            () -> IForgeMenuType.create((windowId, inv, data) -> new PowergenContainer(windowId, data.readBlockPos(), inv, inv.player)));
//    public static final TagKey<Block> MYSTERIOUS_ORE = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(Main.MOD_ID, "mysterious_ore"));
//    public static final TagKey<Item> MYSTERIOUS_ORE_ITEM = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(Main.MOD_ID, "mysterious_ore"));

    static final float MAX_BLAST_RESIST = 3600000.0F;

    //MJDS Blocks
    public static final BlockBehaviour.Properties BLOCK_PROP_MJDS = BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(-1f, MAX_BLAST_RESIST).jumpFactor(JUMP_FACTOR_MJDS_BLOCK);
    public static final BlockBehaviour.Properties BLOCK_PROP_MJDS_AIR = BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(-1f, MAX_BLAST_RESIST).jumpFactor(JUMP_FACTOR_MJDS_BLOCK).noCollission();
    public static final BlockBehaviour.Properties BLOCK_PROP_MJDS_GLASS = BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(-1f, MAX_BLAST_RESIST).jumpFactor(JUMP_FACTOR_MJDS_BLOCK).noOcclusion();


    // Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ModItems.ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ModItems.ITEM_PROPERTIES));
    }

    public static RegistryObject<Block> registerWithItem(final String name, final Supplier<? extends Block> sup)
    {
        RegistryObject<Block> registryObject = BLOCKS.register(name, sup);
        fromBlock(registryObject);
        return registryObject;
    }
}
