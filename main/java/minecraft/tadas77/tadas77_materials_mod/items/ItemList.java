package minecraft.tadas77.tadas77_materials_mod.items;

import minecraft.tadas77.tadas77_materials_mod.MinecraftList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemList extends MinecraftList<Item> {
	public static Item copper;
	public static Item plastic = new Item((new Item.Properties()).group(ItemGroup.MATERIALS))
			.setRegistryName(location("plastic"));

	@SubscribeEvent
	public static void register(final RegistryEvent.Register<Item> event) {
		ItemList.copper = new Item((new Item.Properties()).group(ItemGroup.MATERIALS))
				.setRegistryName(location("copper_ingot"));

//		ItemList.plastic = new Item((new Item.Properties()).group(ItemGroup.MATERIALS))
//				.setRegistryName(location("plastic"));

		event.getRegistry().registerAll(ItemList.copper, ItemList.plastic);
	}
}