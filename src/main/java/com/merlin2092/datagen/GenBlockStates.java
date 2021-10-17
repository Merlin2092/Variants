package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import com.merlin2092.variants.Variants;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class GenBlockStates extends BlockStateProvider {

    public GenBlockStates(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Variants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        simpleBlock(Registration.MOON_STONE.get());
    }
}
