package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import com.merlin2092.variants.Variants;
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
        stairsBlock(Registration.MOON_STONE_STAIRS.get(), new ResourceLocation(MOD_ID, "block/moon_stone"));
        stairsBlock(Registration.RED_CONCRETE_STAIRS.get(), new ResourceLocation("minecraft", "block/red_concrete"));
    }
}
