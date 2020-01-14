package minecraft.tadas77.tadas77_materials_mod.blocks;

import minecraft.tadas77.tadas77_materials_mod.MinecraftList;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

//@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockList extends MinecraftList {
	public static Block copperBlock;
	public static Block copperOre;

	@SubscribeEvent
	public static void register(final RegistryEvent.Register<Block> event) {
		BlockList.copperBlock = new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F, 3.0F)
				.lightValue(5).sound(SoundType.METAL)).setRegistryName(location("copper_block"));
	}
}
