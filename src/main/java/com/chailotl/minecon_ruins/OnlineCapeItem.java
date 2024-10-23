package com.chailotl.minecon_ruins;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;

public class OnlineCapeItem extends CapeItem
{
	private final String hash;

	public OnlineCapeItem(String hash, Settings settings)
	{
		super(null, settings);
		this.hash = hash;
	}

	@Override
	public Identifier getTexture()
	{
		return MinecraftClient.getInstance()
			.getSkinProvider()
			.capeCache
			.get(new MinecraftProfileTexture(
				"http://textures.minecraft.net/texture/" + hash,
				null
			))
			.getNow(null);
	}
}