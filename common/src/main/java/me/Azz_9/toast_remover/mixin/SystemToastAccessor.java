package me.Azz_9.toast_remover.mixin;

import net.minecraft.client.gui.components.toasts.SystemToast;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SystemToast.class)
public interface SystemToastAccessor {

	@Accessor("id")
	SystemToast.SystemToastId getId();
}
