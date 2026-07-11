package me.Azz_9.toast_remover;

import static net.minecraft.client.gui.components.toasts.SystemToast.SystemToastId.*;

import net.minecraft.client.gui.components.toasts.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

import me.Azz_9.toast_remover.mixin.SystemToastAccessor;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as NeoForge events
// however it will be compatible with all supported mod loaders.
public class CommonClass {

	private static final Map<SystemToast.SystemToastId, BooleanSupplier> SYSTEM_TOAST = new HashMap<>();

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.
    public static void init() {

        // It is common for all supported loaders to provide a similar feature that can not be used directly in the
        // common code. A popular way to get around this is using Java's built-in service loader feature to create
        // your own abstraction layer. You can learn more about this in our provided services class. In this example
        // we have an interface in the common code and use a loader specific implementation to delegate our call to
        // the platform specific approach.

		Config.load();
		initToastMap();
    }

	private static void initToastMap() {
		SYSTEM_TOAST.put(NARRATOR_TOGGLE, () -> Config.INSTANCE.disableNarratorToggle);
		SYSTEM_TOAST.put(WORLD_BACKUP, () -> Config.INSTANCE.disableWorldBackup);
		SYSTEM_TOAST.put(PACK_LOAD_FAILURE, () -> Config.INSTANCE.disablePackLoadFailure);
		SYSTEM_TOAST.put(WORLD_ACCESS_FAILURE, () -> Config.INSTANCE.disableWorldAccessFailure);
		SYSTEM_TOAST.put(PACK_COPY_FAILURE, () -> Config.INSTANCE.disablePackCopyFailure);
		SYSTEM_TOAST.put(FILE_DROP_FAILURE, () -> Config.INSTANCE.disableFileDropFailure);
		SYSTEM_TOAST.put(PERIODIC_NOTIFICATION, () -> Config.INSTANCE.disablePeriodicNotification);
		SYSTEM_TOAST.put(LOW_DISK_SPACE, () -> Config.INSTANCE.disableLowDiskSpace);
		SYSTEM_TOAST.put(CHUNK_LOAD_FAILURE, () -> Config.INSTANCE.disableChunkLoadFailure);
		SYSTEM_TOAST.put(CHUNK_SAVE_FAILURE, () -> Config.INSTANCE.disableChunkSaveFailure);
		SYSTEM_TOAST.put(UNSECURE_SERVER_WARNING, () -> Config.INSTANCE.disableUnsecureServerWarning);
	}

	private static boolean shouldSystemToastBeHidden(SystemToast.SystemToastId id) {
		return SYSTEM_TOAST.getOrDefault(id, () -> Config.INSTANCE.disableNonVanilla).getAsBoolean();
	}

	public static boolean shouldToastBeHidden(Toast toast) {
		if (!Config.INSTANCE.enabled) return false;

		if (Config.INSTANCE.disableEveryToasts) return true;

		if (!isVanillaToast(toast) && Config.INSTANCE.disableNonVanilla) return true;

		return switch (toast) {
			case SystemToast systemToast -> Config.INSTANCE.disableSystem || shouldSystemToastBeHidden(((SystemToastAccessor) systemToast).getId());
			case AdvancementToast ignored -> Config.INSTANCE.disableAdvancement;
			case TutorialToast ignored -> Config.INSTANCE.disableTutorial;
			case RecipeToast ignored -> Config.INSTANCE.disableRecipe;
			case NowPlayingToast ignored -> Config.INSTANCE.disableNowPlaying;
			default -> false;
		};
	}

	public static boolean shouldPlayWhooshSound(Toast toast) {
		if (!Config.INSTANCE.enabled) {
			return true;
		}

		if (Config.INSTANCE.disableEveryToastWhooshSound) {
			return false;
		}

		return !Config.INSTANCE.disableHiddenToastWhooshSound || !shouldToastBeHidden(toast);
	}

	public static boolean shouldPlayCustomSound(Toast toast) {
		if (!Config.INSTANCE.enabled) {
			return true;
		}

		if (Config.INSTANCE.disableChallengeAdvancementSound && toast instanceof AdvancementToast) {
			return false;
		}

		return !Config.INSTANCE.disableNonVanillaToastSounds || isVanillaToast(toast);
	}

	private static boolean isVanillaToast(Toast toast) {
		Class<?> toastClass = toast.getClass();

		return toastClass == SystemToast.class
				|| toastClass == AdvancementToast.class
				|| toastClass == TutorialToast.class
				|| toastClass == RecipeToast.class
				|| toastClass == NowPlayingToast.class;
	}
}