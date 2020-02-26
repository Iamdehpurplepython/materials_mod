package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.common.ToolType;

/*
 * 
 * Copper: (204, 102, 0, 255)
 * (Partially) Transparent Plastic (REMOVED): (255, 106, 77, 225)
 * 
 */

// TODO: make textures; TODO: remove this line

public class ModMaterials {
	static JayMaterial copper;

	public static void init() {

		ModMaterials.copper = new JayMaterial("copper",
				// Block Mat
				Block.Properties.create(Material.IRON)
						.hardnessAndResistance(5.0F, 6.0F).harvestLevel(1)
						.harvestTool(ToolType.PICKAXE),

				// Ore Mat
				Block.Properties.create(Material.IRON)
						.hardnessAndResistance(3.0F, 15.0F).harvestLevel(1)
						.harvestTool(ToolType.PICKAXE),

				// TOOL:
				// int maxUsesIn, float efficiencyIn, float attackDamageIn, int
				// toolenchantabilityIn,
				2, 200, 5.5F, 1.5F,
				// CountRangeConfig config, int veinsize
				12, new CountRangeConfig(15, 40, 0, 128), 7,

				// ARMOR:
				// int maxDamageFactorIn, int[] damageReductionAmountsIn, int
				// enchantabilityIn, SoundEvent equipSoundIn
				15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
				// float toughness
				0.0F);
	}
}
