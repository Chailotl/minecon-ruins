package com.chailotl.minecon_ruins;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineconRuins implements ModInitializer
{
	public static final String MOD_ID = "minecon_ruins";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final CapeItem MINECONE_2011_CAPE = registerCape("minecon_2011_cape", "953cac8b779fe41383e675ee2b86071a71658f2180f56fbce8aa315ea70e2ed6");
	public static final CapeItem MINECONE_2012_CAPE = registerCape("minecon_2012_cape", "a2e8d97ec79100e90a75d369d1b3ba81273c4f82bc1b737e934eed4a854be1b6");
	public static final CapeItem MINECONE_2013_CAPE = registerCape("minecon_2013_cape", "153b1a0dfcbae953cdeb6f2c2bf6bf79943239b1372780da44bcbb29273131da");
	public static final CapeItem MINECONE_2015_CAPE = registerCape("minecon_2015_cape", "b0cc08840700447322d953a02b965f1d65a13a603bf64b17c803c21446fe1635");
	public static final CapeItem MINECONE_2016_CAPE = registerCape("minecon_2016_cape", "e7dfea16dc83c97df01a12fabbd1216359c0cd0ea42f9999b6e97c584963e980");

	@Override
	public void onInitialize()
	{

	}

	private static CapeItem registerCape(String name, String hash)
	{
		CapeItem item = new OnlineCapeItem(hash, new Item.Settings().maxCount(1));
		return registerCape(name, item);
	}

	private static CapeItem registerCape(String name, Identifier texture)
	{
		CapeItem item = new CapeItem(texture, new Item.Settings().maxCount(1));
		return registerCape(name, item);
	}

	private static CapeItem registerCape(String name, CapeItem item)
	{
		Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name), item);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(item);
		});
		return item;
	}
}