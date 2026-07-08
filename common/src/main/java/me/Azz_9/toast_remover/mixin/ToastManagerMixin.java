package me.Azz_9.toast_remover.mixin;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.Azz_9.toast_remover.CommonClass;

@Mixin(ToastManager.class)
public abstract class ToastManagerMixin {

	@Inject(method = "addToast", at = @At("HEAD"), cancellable = true)
	private void addToast(Toast toast, CallbackInfo ci) {
		if (CommonClass.shouldBeCanceled(toast)) {
			ci.cancel();
		}
	}
}
