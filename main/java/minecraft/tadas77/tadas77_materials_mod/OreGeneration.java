package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration {
	// Vein/Chunk Count, MinHeight, MaxHeightBase, MaxHeight
//	private static final CountRangeConfig copper_cfg = new CountRangeConfig(15, 40, 0, 128);
//	private static final int copper_veinsize = 7;

	public static void setupOreGen() {
		MaterialsMod.LOGGER.debug("Setting Up Ore Gen - Iamdehpurple");
		for (Biome biome : ForgeRegistries.BIOMES.getValues()) {

			if (biome.getCategory() == Biome.Category.THEEND || biome.getCategory() == Biome.Category.NETHER) {
				continue;
			}

			for (JayMaterial mat : JayMaterial.materials) {
				biome.addFeature(Decoration.UNDERGROUND_ORES,
						Biome.createDecoratedFeature(
								Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE,
										mat.oreblock.getDefaultState(), mat.veinsize),
								Placement.COUNT_RANGE, mat.config));
			}

//			biome.addFeature(Decoration.UNDERGROUND_ORES,
//					Biome.createDecoratedFeature(Feature.ORE,
//							new OreFeatureConfig(FillerBlockType.NATURAL_STONE,
//									ModMaterials.copper.oreblock.getDefaultState(), ModMaterials.copper.veinsize),
//							Placement.COUNT_RANGE, ModMaterials.copper.config));
		}
	}
}