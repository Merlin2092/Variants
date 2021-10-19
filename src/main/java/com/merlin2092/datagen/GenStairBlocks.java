package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.merlin2092.variants.Variants.MOD_ID;

public class GenStairBlocks {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }

    public static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Registration.variantTab)));
    }

    // GENERATED_TEXT_HERE

    public static final RegistryObject<StairBlock> MOON_STONE_STAIRS = registerBlock("moon_stone_stairs", () -> new StairBlock(() -> Registration.MOON_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Registration.MOON_STONE.get())));
    public static final RegistryObject<StairBlock> WHITE_STONE_STAIRS = registerBlock("white_stone_stairs", () -> new StairBlock(() -> Registration.WHITE_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(Registration.WHITE_STONE.get())));

    // GENERATED_TEXT_HERE
}
