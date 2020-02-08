package minecraft.tadas77.tadas77_materials_mod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JayMaterial {
	public static ArrayList<JayMaterial> materials = new ArrayList<JayMaterial>();

	// Item
	public Item.Properties itemproperties;
	public Item item;

	// Block
	public Block.Properties blockproperties;
	public Item.Properties blockitemproperties;

	public Block block;
	public Item blockitem;

	// Ore
	public Block.Properties oreblockproperties;
	public Item.Properties oreblockitemproperties;

	public Block oreblock;
	public Item oreblockitem;

	// Tool
	public IItemTier itemtier;
	public Item axe;
	public Item pickaxe;
	public Item sword;
	public Item shovel;
	public Item hoe;

	// OreGen
	public CountRangeConfig config;
	public int veinsize;

	public String locname;

	public JayMaterial(String locname, Block.Properties blockproperties, Block.Properties oreproperties,
			IItemTier itemtier, CountRangeConfig config, int veinsize) {
		MaterialsMod.LOGGER.debug("JayMaterials Init - 3.14159265");

		this.blockproperties = blockproperties;
		this.oreblockproperties = oreproperties;

		this.config = config;
		this.veinsize = veinsize;

		this.locname = locname;

		this.itemtier = itemtier;

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

		this.item = new Item(new Item.Properties().group(ItemGroup.MATERIALS))
				.setRegistryName(location(this.locname + "_item"));

		this.blockitem = new BlockItem(this.block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
				.setRegistryName(location(this.locname + "_block"));

		this.sword = new SwordItem(itemtier, 3, -2.4F, (new Item.Properties()).group(ItemGroup.COMBAT))
				.setRegistryName(location(this.locname + "_sword"));
		this.shovel = new ShovelItem(itemtier, 1.5F, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS))
				.setRegistryName(location(this.locname + "_shovel"));
		this.pickaxe = new PickaxeItem(itemtier, 1, -2.8F, (new Item.Properties()).group(ItemGroup.TOOLS))
				.setRegistryName(location(this.locname + "_pickaxe"));
		this.axe = new AxeItem(itemtier, 6.0F, -3.2F, (new Item.Properties()).group(ItemGroup.TOOLS))
				.setRegistryName(location(this.locname + "_axe"));
		this.hoe = new HoeItem(itemtier, -3.0F, (new Item.Properties()).group(ItemGroup.TOOLS))
				.setRegistryName(location(this.locname + "_hoe"));

		((RegistryEvent.Register<Item>) event).getRegistry().registerAll(this.item, this.blockitem, this.sword,
				this.shovel, this.pickaxe, this.axe, this.hoe);
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

		this.oreblock = new Block(this.oreblockproperties).setRegistryName(location(this.locname + "_oreblock"));

		((RegistryEvent.Register<Block>) event).getRegistry().registerAll(this.block);
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MaterialsMod.MODID, name);
	}
}
