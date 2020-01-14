package minecraft.tadas77.tadas77_materials_mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import minecraft.tadas77.tadas77_materials_mod.blocks.BlockList;
import minecraft.tadas77.tadas77_materials_mod.items.ItemList;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MaterialsMod.MODID)
public class MaterialsMod {
	private static final Logger LOGGER = LogManager.getLogger();
	public static MaterialsMod instance;
	public static final String MODID = "tadas77_materials_mod";

	public MaterialsMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

		MinecraftForge.EVENT_BUS.register(this);

		this.instance = this;
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	private void doClientStuff(final FMLClientSetupEvent event) {

	}

}