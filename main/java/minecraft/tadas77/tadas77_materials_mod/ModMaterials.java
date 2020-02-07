package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.ToolType;

/*
 * 
 * Copper: (204, 102, 0, 255)
 * (Partially) Transparent Plastic: (255, 106, 77, 225)
 * 
 */

public class ModMaterials {
	static JayMaterial copper;

	public static void init() {
		MaterialsMod.LOGGER.debug("ModMaterials Init - 3.14159265");

		ModMaterials.copper = new JayMaterial("copper",
				Block.Properties.create(Material.IRON)
						.hardnessAndResistance(30.0F, 3.0F).harvestLevel(1)
						.harvestTool(ToolType.PICKAXE),
				new JayItemTier(2, 200, 5.5F, 1.5F, 12, () -> {
					return Ingredient.fromItems(ModMaterials.copper.item);
				}));
	}
}
