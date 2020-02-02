package minecraft.tadas77.tadas77_materials_mod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JayMaterial {
	public static ArrayList<JayMaterial> materials = new ArrayList<JayMaterial>();

	public Item.Properties itemproperties;

	public Item item;

	public Block.Properties blockproperties;
	public Item.Properties blockitemproperties;

	public Block block;
	public Item blockitem;

	public String locname;

	public JayMaterial(String locname, Item.Properties itemproperties, Block.Properties blockproperties,
			Item.Properties blockitemproperties) {
		MaterialsMod.LOGGER.debug("JayMaterials Init - 3.14159265");

		this.itemproperties = itemproperties;

		this.blockproperties = blockproperties;
		this.blockitemproperties = blockitemproperties;

		this.locname = locname;

		materials.add(this);
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent<Item> event) {
		MaterialsMod.LOGGER.debug("JayMaterials Register Items - 3.14159265");
		for (JayMaterial mat : JayMaterial.materials) {
			mat.registerItem(event);
		}
	}

	public void registerItem(final RegistryEvent<Item> event) {
		MaterialsMod.LOGGER.debug("JayMaterials Register Item - 3.14159265");

		this.item = new Item(this.itemproperties).setRegistryName(location(this.locname + "_item"));
		
		this.blockitem = new BlockItem(this.block, this.blockitemproperties)
				.setRegistryName(location(this.locname + "_block"));

		((RegistryEvent.Register<Item>) event).getRegistry().registerAll(this.item, this.blockitem);
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent<Block> event) {
		MaterialsMod.LOGGER.debug("JayMaterials Register Blocks - 3.14159265");
		for (JayMaterial mat : JayMaterial.materials) {
			mat.registerBlock(event);
		}
	}

	public void registerBlock(final RegistryEvent<Block> event) {
		MaterialsMod.LOGGER.debug("JayMaterials Register Block - 3.14159265");

		this.block = new Block(this.blockproperties).setRegistryName(location(this.locname + "_block"));

		((RegistryEvent.Register<Block>) event).getRegistry().registerAll(this.block);
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MaterialsMod.MODID, name);
	}
}
