package minecraft.tadas77.tadas77_materials_mod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class JayMaterial {
	public static ArrayList<JayMaterial> materials;

	public Item item;
	public Block block;
	public Item itemblock;

	public JayMaterial(String locname, Item.Properties itemproperties, Block.Properties blockproperties,
			Item.Properties blockitemproperties) {

		this.item = new Item(itemproperties).setRegistryName(location(locname));

		this.block = new Block(blockproperties).setRegistryName(location(locname));
		this.itemblock = new BlockItem(this.block, blockitemproperties).setRegistryName(location(locname));

		materials.add(this);
	}

	@SubscribeEvent
	public void registerItem(final RegistryEvent<Item> event) {
		((RegistryEvent.Register<Item>) event).getRegistry().registerAll(
				this.item,
				this.itemblock
		);
	}
	
	@SubscribeEvent
	public void registerBlock(final RegistryEvent<Block> event) {
		((RegistryEvent.Register<Block>) event).getRegistry().registerAll(
				this.block
		);
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MaterialsMod.MODID, name);
	}
}
