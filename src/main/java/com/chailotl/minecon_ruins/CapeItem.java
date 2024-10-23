package com.chailotl.minecon_ruins;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.util.Identifier;

public class CapeItem extends TrinketItem
{
	private final Identifier texture;

	public CapeItem(Identifier texture, Settings settings)
	{
		super(settings);
		this.texture = texture;
	}

	public Identifier getTexture()
	{
		return texture;
	}
}
