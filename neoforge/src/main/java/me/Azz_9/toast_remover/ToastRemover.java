package me.Azz_9.toast_remover;

import static me.Azz_9.toast_remover.Constants.CLOTH_CONFIG_ID_NEOFORGE;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

import me.Azz_9.toast_remover.client.gui.components.toasts.CustomToastId;
import me.Azz_9.toast_remover.compat.ClothConfigCompat;

@Mod(Constants.MOD_ID)
public class ToastRemover {

    public ToastRemover(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.

        CommonClass.init();

		ModLoadingContext.get().registerExtensionPoint(
				IConfigScreenFactory.class,
				() -> {
					if (!ModList.get().isLoaded(CLOTH_CONFIG_ID_NEOFORGE)) {
						Minecraft.getInstance().execute(() ->
								SystemToast.add(
										Minecraft.getInstance().getToastManager(),
										CustomToastId.MISSING_CLOTH_CONFIG,
										Component.translatable("toast_remover.toast.missing_cloth_config.title"),
										Component.translatable("toast_remover.toast.missing_cloth_config.message")
								)
						);
						return null;
					}
					return (container, parent) -> ClothConfigCompat.buildClothConfigScreen(parent);
				}
		);
    }
}