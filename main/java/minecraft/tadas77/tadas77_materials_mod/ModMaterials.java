package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;

/*
 * 
 * Copper: (204, 102, 0, 255)
 * Plastic: (255, 106, 77, 225)
 * 
 */

public class ModMaterials {
	static JayMaterial copper;

	public static void init() {
		MaterialsMod.LOGGER.debug("ModMaterials Init - 3.14159265");

		ModMaterials.copper = ModMaterials.createRegularMaterial("copper", 3.0F,
				30.0F, 1, ToolType.PICKAXE);
	}

	public static JayMaterial createRegularMaterial(String locname,
			Float hardness, Float resistance, int harvestlevel,
			ToolType harvesttool) {
		return new JayMaterial(locname,
				new Item.Properties().group(ItemGroup.MATERIALS),
				Block.Properties.create(Material.IRON)
						.hardnessAndResistance(hardness, resistance)
						.harvestLevel(harvestlevel).harvestTool(harvesttool),
				new Item.Properties().group(ItemGroup.BUILDING_BLOCKS));
	}
}
