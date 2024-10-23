package com.chailotl.minecon_ruins.mixin;

import com.chailotl.minecon_ruins.CapeItem;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.SkinTextures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractClientPlayerEntity.class)
public class AbstractClientPlayerEntityMixin
{
	@Inject(method = "getSkinTextures", at = @At("RETURN"), cancellable = true)
	private void init(CallbackInfoReturnable<SkinTextures> cir)
	{
		TrinketComponent trinket = TrinketsApi.getTrinketComponent((AbstractClientPlayerEntity)(Object) this).orElse(null);
		if (trinket == null) { return; }

		var pair = trinket.getAllEquipped()
			.stream()
			.filter(p -> p.getRight().getItem() instanceof CapeItem)
			.findFirst()
			.orElse(null);
		if (pair == null) { return; }

		CapeItem cape = (CapeItem) pair.getRight().getItem();

		SkinTextures skinTextures = cir.getReturnValue();

		cir.setReturnValue(new SkinTextures(
			skinTextures.texture(),
			skinTextures.textureUrl(),
			cape.getTexture(),
			cape.getTexture(),
			skinTextures.model(),
			skinTextures.secure()
		));
	}
}