package com.merlin2092.variants.tabs;

import com.merlin2092.setup.Registration;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class VariantTab extends CreativeModeTab {

    public VariantTab(String label) {
        super(label);
    }

    @Override
    public ItemStack makeIcon() {
        return Registration.MOON_STONE.get().asItem().getDefaultInstance();
    }
}
