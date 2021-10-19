package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.merlin2092.variants.Variants.MOD_ID;

public class GenBlockStates extends BlockStateProvider {

    public GenBlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(Registration.MOON_STONE.get());
        simpleBlock(Registration.WHITE_STONE.get());

        // GENERATED_TEXT_HERE

        stairsBlock(GenStairBlocks.MOON_STONE_STAIRS.get(), new ResourceLocation(MOD_ID, "block/moon_stone"));
        stairsBlock(GenStairBlocks.WHITE_STONE_STAIRS.get(), new ResourceLocation(MOD_ID, "block/white_stone"));

    // GENERATED_TEXT_HERE
    }
}
