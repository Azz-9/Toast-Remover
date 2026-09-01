package me.Azz_9.toast_remover.mixin;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.Azz_9.toast_remover.CommonClass;

@Mixin(ToastManager.ToastInstance.class)
public abstract class ToastInstanceMixin {

	@Shadow
	@Final
	private Toast toast;

	@Inject(
			method = "extractRenderState",
			at = @At("HEAD"),
			cancellable = true
	)
	private void cancelRender(
			GuiGraphicsExtractor graphics,
			int screenWidth,
			CallbackInfo ci
	) {
		if (CommonClass.shouldToastBeHidden(toast)) {
			ci.cancel();
		}
	}
}
