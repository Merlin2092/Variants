package com.merlin2092.datagen;

import com.merlin2092.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeClient()) {
            genStairs();

            generator.addProvider(new GenBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new GenItems(generator, event.getExistingFileHelper()));
        }
    }

    private static void genStairs() {
        try {
            StringBuilder replacementBlocks = new StringBuilder("");
            StringBuilder replacementBlockStates = new StringBuilder("");
            StringBuilder replacementItems = new StringBuilder("");
            String blockName = "";
            String blockVar = "";
            String blockModID = "";

            Collection<RegistryObject<Block>> entries = Registration.BLOCKS.getEntries();
            for (RegistryObject<Block> block : entries) {
                blockName = block.getId().getPath();
                blockVar = blockName.toUpperCase(Locale.ROOT);
                blockModID = block.getId().getNamespace();
                replacementBlocks.append("\n" +
                                "    public static final RegistryObject<StairBlock> ").append(blockVar).append("_STAIRS = registerBlock(\"").append(blockName).append("_stairs\", ")
                        .append("() -> new StairBlock(() -> Registration.").append(blockVar).append(".get().defaultBlockState(), BlockBehaviour.Properties.copy(Registration.").append(blockVar).append(".get())));");
                replacementBlockStates.append("\n        stairsBlock(GenStairBlocks.").append(blockVar).append("_STAIRS.get(), new ResourceLocation(MOD_ID, \"block/").append(blockName).append("\"));");
                replacementItems.append("\n        withExistingParent(\"").append(blockName).append("_stairs\", modLoc(\"block/").append(blockName).append("_stairs\"));");
            }

            String marking = "// GENERATED_TEXT_HERE";

            String stairBlocksPath = formatPath(GenStairBlocks.class.getResource("GenStairBlocks.class").getPath());
            String stairBlockStatesPath = formatPath(GenStairBlocks.class.getResource("GenBlockStates.class").getPath());
            String stairItemsPath = formatPath(GenStairBlocks.class.getResource("GenItems.class").getPath());

            replaceText(replacementBlocks.toString(), marking, stairBlocksPath);
            replaceText(replacementBlockStates.toString(), marking, stairBlockStatesPath);
            replaceText(replacementItems.toString(), marking, stairItemsPath);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String formatPath(String javaClassPath) {
        String returnPath = javaClassPath.substring(1).replace(".class", ".java").replaceAll("/out/(.*)/com/", "/src/main/java/com/");
        return returnPath;
    }

    private static void replaceText(String replacement, String marking, String path) throws IOException {
        String content = Files.readString(Path.of(path), StandardCharsets.UTF_8);
        content = content.replaceAll("(?s)" + marking + "(.*)" + marking, marking + "\n\r" + replacement + "\n\r    " + marking);

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();
    }
}
