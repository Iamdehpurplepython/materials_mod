package minecraft.tadas77.materialsmod;

import net.minecraft.util.ResourceLocation;

public class MinecraftList {
	public static void register(final Object event) {
		
	}
	
	public static ResourceLocation location(String loc) {
		return new ResourceLocation(MaterialsMod.MODID, loc);
	}
}
