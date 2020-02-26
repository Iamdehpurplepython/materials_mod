package minecraft.tadas77.tadas77_materials_mod;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JayMaterial {
	public static ArrayList<JayMaterial> materials = new ArrayList<JayMaterial>();

	// Item
	public Item item;

	// Block
	public Block.Properties blockproperties;

	public Block block;
	public Item blockitem;

	// Ore
	public Block.Properties oreblockproperties;

	public Block oreblock;
	public Item oreblockitem;

	// Tool
	public IItemTier itemtier;
	public Item axe;
	public Item pickaxe;
	public Item sword;
	public Item shovel;
	public Item hoe;

	// Armor
	public IArmorMaterial armormaterial;

	public Item helm;
	public Item chest;
	public Item legs;
	public Item feet;

	// OreGen
	public CountRangeConfig config;
	public int veinsize;

	public String locname;

	public JayMaterial(String locname, Block.Properties blockproperties,
			Block.Properties oreproperties, int harvestLevelIn, int maxUsesIn,
			float efficiencyIn, float attackDamageIn, int toolenchantabilityIn,
			CountRangeConfig config, int veinsize, int maxDamageFactorIn,
			int[] damageReductionAmountsIn, int armorenchantabilityIn,
			SoundEvent equipSoundIn, float toughness) {
		MaterialsMod.LOGGER.debug("JayMaterials Init - 3.14159265");

		this.blockproperties = blockproperties;
		this.oreblockproperties = oreproperties;

		this.config = config;
		this.veinsize = veinsize;

		this.locname = locname;

		// this.itemtier = itemtier;
		this.itemtier = new JayItemTier(harvestLevelIn, maxUsesIn, efficiencyIn,
				attackDamageIn, toolenchantabilityIn, () -> {
					return Ingredient.fromItems(this.item);
				});

		// this.armormaterial = armormat;
		this.armormaterial = new JayArmorMaterial(MaterialsMod.MODID + ":" + locname, maxDamageFactorIn,
				damageReductionAmountsIn, armorenchantabilityIn, equipSoundIn,
				toughness, () -> {
					return Ingredient.fromItems(this.item);
				});

		materials.add(this);
	}

	@SubscribeEvent
	public static void registerItems(final RegistryEvent<Item> event) {
		for (JayMaterial mat : JayMaterial.materials) {
			mat.registerItem(event);
		}
	}

	public void registerItem(final RegistryEvent<Item> event) {

		this.item = new Item(new Item.Properties().group(ItemGroup.MATERIALS))
				.setRegistryName(location(this.locname + "/item"));

		this.blockitem = new BlockItem(this.block,
				new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
						.setRegistryName(location(this.locname + "/block"));

		this.oreblockitem = new BlockItem(this.oreblock,
				new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
						.setRegistryName(location(this.locname + "/oreblock"));

		this.sword = new SwordItem(this.itemtier, 3, -2.4F,
				(new Item.Properties()).group(ItemGroup.COMBAT))
						.setRegistryName(location(this.locname + "/sword"));

		this.shovel = new ShovelItem(this.itemtier, 1.5F, -3.0F,
				(new Item.Properties()).group(ItemGroup.TOOLS))
						.setRegistryName(location(this.locname + "/shovel"));

		this.pickaxe = new PickaxeItem(this.itemtier, 1, -2.8F,
				(new Item.Properties()).group(ItemGroup.TOOLS))
						.setRegistryName(location(this.locname + "/pickaxe"));

		this.axe = new AxeItem(this.itemtier, 6.0F, -3.2F,
				(new Item.Properties()).group(ItemGroup.TOOLS))
						.setRegistryName(location(this.locname + "/axe"));

		this.hoe = new HoeItem(this.itemtier, -3.0F,
				(new Item.Properties()).group(ItemGroup.TOOLS))
						.setRegistryName(location(this.locname + "/hoe"));

		this.helm = new ArmorItem(this.armormaterial, EquipmentSlotType.HEAD,
				(new Item.Properties()).group(ItemGroup.COMBAT))
						.setRegistryName(location(this.locname + "/helm"));

		this.chest = new ArmorItem(this.armormaterial, EquipmentSlotType.CHEST,
				(new Item.Properties()).group(ItemGroup.COMBAT))
						.setRegistryName(location(this.locname + "/chest"));

		this.legs = new ArmorItem(this.armormaterial, EquipmentSlotType.LEGS,
				(new Item.Properties()).group(ItemGroup.COMBAT))
						.setRegistryName(location(this.locname + "/legs"));

		this.feet = new ArmorItem(this.armormaterial, EquipmentSlotType.FEET,
				(new Item.Properties()).group(ItemGroup.COMBAT))
						.setRegistryName(location(this.locname + "/feet"));

		((RegistryEvent.Register<Item>) event).getRegistry().registerAll(
				this.item, this.blockitem, this.oreblockitem, this.sword,
				this.shovel, this.pickaxe, this.axe, this.hoe, this.helm,
				this.chest, this.legs, this.feet);
	}

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent<Block> event) {
		for (JayMaterial mat : JayMaterial.materials) {
			mat.registerBlock(event);
		}
	}

	public void registerBlock(final RegistryEvent<Block> event) {

		this.block = new Block(this.blockproperties)
				.setRegistryName(location(this.locname + "/block"));

		this.oreblock = new Block(this.oreblockproperties)
				.setRegistryName(location(this.locname + "/oreblock"));

		((RegistryEvent.Register<Block>) event).getRegistry()
				.registerAll(this.block, this.oreblock);
	}

	public static ResourceLocation location(String name) {
		return new ResourceLocation(MaterialsMod.MODID, name);
	}
}
