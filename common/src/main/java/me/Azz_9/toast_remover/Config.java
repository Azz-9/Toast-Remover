package me.Azz_9.toast_remover;

import static me.Azz_9.toast_remover.Constants.MOD_ID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

import me.Azz_9.toast_remover.platform.Services;

public class Config {

	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static final Path CONFIG_FILE = Services.PLATFORM.getConfigDir().resolve(MOD_ID + ".json");

	public boolean enabled = true;
	public boolean disableEveryToasts = false;
	public boolean disableNonVanilla = false;
	public boolean disableEveryToastWhooshSound = false;
	public boolean disableHiddenToastWhooshSound = true;
	public boolean disableChallengeAdvancementSound = false;
	public boolean disableNonVanillaToastSounds = false;
	public boolean disableAdvancement = false;
	public boolean disableTutorial = false;
	public boolean disableRecipe = false;
	public boolean disableNowPlaying = false;
	public boolean disableSystem = false;
	// MC_COPY ids from net.minecraft.client.gui.components.toasts.SystemToast.SystemToastId
	public boolean disableNarratorToggle = false;
	public boolean disableWorldBackup = false;
	public boolean disablePackLoadFailure = false;
	public boolean disableWorldAccessFailure = false;
	public boolean disablePackCopyFailure = false;
	public boolean disableFileDropFailure = false;
	public boolean disablePeriodicNotification = false;
	public boolean disableLowDiskSpace = false;
	public boolean disableChunkLoadFailure = false;
	public boolean disableChunkSaveFailure = false;
	public boolean disableUnsecureServerWarning = false;

	public static Config INSTANCE = new Config();

	public static void save() {
		ToastLogger.info("Saving config...");

		try (Writer writer = Files.newBufferedWriter(CONFIG_FILE)) {
			GSON.toJson(INSTANCE, writer);
		} catch (IOException e) {
			ToastLogger.error("Failed to save config file : {}", e.getMessage());
			return;
		}

		ToastLogger.info("Config successfully saved!");
	}

	public static void load() {
		ToastLogger.info("Loading config...");
		if (!Files.exists(CONFIG_FILE)) {
			ToastLogger.info("Config file does not exist, creating a new one");
			Config.save();
			return;
		}

		try (Reader reader = Files.newBufferedReader(CONFIG_FILE)) {
			INSTANCE = GSON.fromJson(reader, Config.class);
		} catch (IOException e) {
			ToastLogger.error("Failed to load config file : {}", e.getMessage());
			return;
		}

		ToastLogger.info("Config successfully loaded!");
	}
}