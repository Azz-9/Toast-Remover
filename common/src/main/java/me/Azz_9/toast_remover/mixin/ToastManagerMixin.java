package me.Azz_9.toast_remover.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;

import net.minecraft.client.gui.components.toasts.Toast;
import net.minecraft.client.gui.components.toasts.ToastManager;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.sounds.SoundEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import me.Azz_9.toast_remover.CommonClass;

@Mixin(ToastManager.class)
public abstract class ToastManagerMixin {

	@WrapOperation(
			method = "lambda$update$1",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/gui/components/toasts/Toast;getSoundEvent()Lnet/minecraft/sounds/SoundEvent;"
			)
	)
	private SoundEvent getToastSound(Toast toast, Operation<SoundEvent> original) {
		if (!CommonClass.shouldPlayCustomSound(toast)) {
			return null;
		}

		return original.call(toast);
	}
}
