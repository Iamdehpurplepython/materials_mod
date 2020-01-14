package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

/*
 * 
 * Copper: (204, 102, 0, 255)
 * Plastic: (255, 106, 77, 225)
 * 
 */

public class MinecraftList<T extends IForgeRegistryEntry<T>> {
	Class<T> type;

	public MinecraftList(Class<T> type) {
		this.type = type;
	}

	public static ResourceLocation location(String loc) {
		return new ResourceLocation(MaterialsMod.MODID, loc);
	}
}
