package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.merlin2092.variants.Variants.MOD_ID;

public class GenItems extends ItemModelProvider {

    public GenItems(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /**
         * ITEMS
         */
        singleTexture(
                Registration.ELVEN_SWORD.get().getRegistryName().getPath(),              // actual model name
                new ResourceLocation("item/handheld"),                          // parent model
                "layer0",                                                       // use as key in json (instead of default 'texture'?)
                new ResourceLocation(MOD_ID, "item/elven_sword")                // texture
        );

        /**
         * BLOCK ITEMS
         */
        withExistingParent("moon_stone", modLoc("block/moon_stone"));
        withExistingParent("white_stone", modLoc("block/white_stone"));
        withExistingParent("moon_stone_stairs", modLoc("block/moon_stone_stairs"));
        withExistingParent("white_stone_stairs", modLoc("block/white_stone_stairs"));
        withExistingParent("red_concrete_stairs", modLoc("block/red_concrete_stairs"));
    }
}
