package com.merlin2092.setup;

import com.merlin2092.variants.items.ItemVariant;
import com.merlin2092.variants.tabs.VariantTab;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.merlin2092.variants.Variants.MOD_ID;

public class Registration {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final VariantTab variantTab = new VariantTab("variant_tab");

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(variantTab)));
    }

    /**
     * ITEMS
     */
    public static final RegistryObject<Item> ELVEN_SWORD = ITEMS.register("elven_sword", () -> new ItemVariant(new Item.Properties().tab(variantTab)));

    /**
     * BLOCKS
     */
    public static final RegistryObject<Block> MOON_STONE = registerBlock("moon_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));
    public static final RegistryObject<StairBlock> MOON_STONE_STAIRS = registerBlock("moon_stone_stairs", () -> new StairBlock(MOON_STONE.get().defaultBlockState(), BlockBehaviour.Properties.copy(MOON_STONE.get())));
}
