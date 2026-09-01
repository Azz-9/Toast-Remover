package me.Azz_9.toast_remover.platform;

import me.Azz_9.toast_remover.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public @NotNull String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(@NotNull String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

	@Override
	public @NotNull Path getConfigDir() {
		return FabricLoader.getInstance().getConfigDir();
	}
}
