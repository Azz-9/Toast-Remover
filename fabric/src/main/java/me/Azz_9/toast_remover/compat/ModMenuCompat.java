package me.Azz_9.toast_remover.compat;

import static me.Azz_9.toast_remover.Constants.CLOTH_CONFIG_ID_FABRIC;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;

import me.Azz_9.toast_remover.client.gui.components.toasts.CustomToastId;

public class ModMenuCompat implements ModMenuApi {

	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		if (!FabricLoader.getInstance().isModLoaded(CLOTH_CONFIG_ID_FABRIC)) {
			return parent -> {
				// Toast remover displaying a toast O_o
				Minecraft.getInstance().execute(() ->
						SystemToast.add(
								Minecraft.getInstance().getToastManager(),
								CustomToastId.MISSING_CLOTH_CONFIG,
								Component.translatable("toast_remover.toast.missing_cloth_config.title"),
								Component.translatable("toast_remover.toast.missing_cloth_config.message")
						)
				);
				return null;
			};
		}
		return ClothConfigCompat::buildClothConfigScreen;
	}
}

