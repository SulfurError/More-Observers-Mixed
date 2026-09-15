package com.stebars.moreobserversmod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod(MoreObserversMod.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreObserversMod {
	public final static String MOD_ID = "moreobservers";

	public static final Block TOGGLE_OBSERVER_BLOCK = new ToggleObserverBlock()
			.setRegistryName(new ResourceLocation(MOD_ID, "toggle_observer"));
	public static final Item TOGGLE_OBSERVER_ITEM = new BlockItem(TOGGLE_OBSERVER_BLOCK,
			new Item.Properties().tab(ItemGroup.TAB_REDSTONE)).setRegistryName(new ResourceLocation(MOD_ID, "toggle_observer"));

	public MoreObserversMod() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(TOGGLE_OBSERVER_BLOCK);
	}

	@SubscribeEvent
	public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
		event.getRegistry().register(TOGGLE_OBSERVER_ITEM);
	}	
}
