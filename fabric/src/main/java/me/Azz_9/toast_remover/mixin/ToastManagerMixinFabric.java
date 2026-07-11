package me.Azz_9.toast_remover.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.sounds.SoundManager;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import me.Azz_9.toast_remover.CommonClass;

@Mixin(ToastManager.class)
public abstract class ToastManagerMixinFabric {

	@WrapWithCondition(
			method = "lambda$update$0",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/components/toasts/Toast$Visibility;playSound(Lnet/minecraft/client/sounds/SoundManager;)V"
			)
	)
	private boolean shouldPlayWhooshSound(
			Toast.Visibility visibility,
			SoundManager manager,
			@Local(name = "toast", argsOnly = true) ToastManager.ToastInstance<?> toast
	) {
		return CommonClass.shouldPlayWhooshSound(toast.getToast());
	}
}
