package minecraft.tadas77.tadas77_materials_mod;

import net.minecraft.util.ResourceLocation;

public class MinecraftList {
	public static void register(final Object event) {
		
	}
	
	public static ResourceLocation location(String loc) {
		return new ResourceLocation(MaterialsMod.MODID, loc);
	}
}
