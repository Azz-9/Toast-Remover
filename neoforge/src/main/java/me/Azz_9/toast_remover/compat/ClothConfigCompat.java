package me.Azz_9.toast_remover.compat;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

import me.Azz_9.toast_remover.Config;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import me.shedaniel.clothconfig2.gui.entries.BooleanListEntry;

public class ClothConfigCompat {

	public static Screen buildClothConfigScreen(Screen parent) {
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.translatable("toast_remover.config.title"))
				.setSavingRunnable(Config::save);

		ConfigEntryBuilder entryBuilder = builder.entryBuilder();

		ConfigCategory general = builder.getOrCreateCategory(Component.translatable("toast_remover.config.category.general"));

		BooleanListEntry enabledEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.enabled"),
						Config.INSTANCE.enabled
				)
				.setDefaultValue(true)
				.setSaveConsumer(aBoolean -> Config.INSTANCE.enabled = aBoolean)
				.build();

		BooleanListEntry disableEveryToastsEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_every_toasts"),
						Config.INSTANCE.disableEveryToasts
				)
				.setDefaultValue(false)
				.setSaveConsumer(aBoolean -> Config.INSTANCE.disableEveryToasts = aBoolean)
				.setRequirement(enabledEntry::getValue)
				.build();

		BooleanListEntry disableNonVanillaEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_non_vanilla"),
						Config.INSTANCE.disableNonVanilla
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableNonVanilla = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		general.addEntry(enabledEntry);
		general.addEntry(disableEveryToastsEntry);
		general.addEntry(disableNonVanillaEntry);

		ConfigCategory toastTypes = builder.getOrCreateCategory(Component.translatable("toast_remover.config.category.toast_types"));

		BooleanListEntry disableAdvancementEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_advancement"),
						Config.INSTANCE.disableAdvancement
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableAdvancement = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		BooleanListEntry disableTutorialEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_tutorial"),
						Config.INSTANCE.disableTutorial
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableTutorial = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		BooleanListEntry disableRecipeEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_recipe"),
						Config.INSTANCE.disableRecipe
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableRecipe = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		BooleanListEntry disableFriendEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_friend"),
						Config.INSTANCE.disableFriend
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableFriend = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		BooleanListEntry disableNowPlayingEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_now_playing"),
						Config.INSTANCE.disableNowPlaying
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableNowPlaying = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		BooleanListEntry disableSystemEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_system"),
						Config.INSTANCE.disableSystem
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableSystem = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue())
				.build();

		toastTypes.addEntry(disableAdvancementEntry);
		toastTypes.addEntry(disableTutorialEntry);
		toastTypes.addEntry(disableRecipeEntry);
		toastTypes.addEntry(disableFriendEntry);
		toastTypes.addEntry(disableNowPlayingEntry);
		toastTypes.addEntry(disableSystemEntry);

		ConfigCategory systemToasts = builder.getOrCreateCategory(Component.translatable("toast_remover.config.category.system_toasts"));

		BooleanListEntry disableNarratorToggleEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_narrator_toggle"),
						Config.INSTANCE.disableNarratorToggle
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableNarratorToggle = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableWorldBackupEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_world_backup"),
						Config.INSTANCE.disableWorldBackup
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableWorldBackup = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disablePackLoadFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_pack_load_failure"),
						Config.INSTANCE.disablePackLoadFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disablePackLoadFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableWorldAccessFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_world_access_failure"),
						Config.INSTANCE.disableWorldAccessFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableWorldAccessFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disablePackCopyFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_pack_copy_failure"),
						Config.INSTANCE.disablePackCopyFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disablePackCopyFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableFileDropFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_file_drop_failure"),
						Config.INSTANCE.disableFileDropFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableFileDropFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disablePeriodicNotificationEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_periodic_notification"),
						Config.INSTANCE.disablePeriodicNotification
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disablePeriodicNotification = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableLowDiskSpaceEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_low_disk_space"),
						Config.INSTANCE.disableLowDiskSpace
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableLowDiskSpace = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableChunkLoadFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_chunk_load_failure"),
						Config.INSTANCE.disableChunkLoadFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableChunkLoadFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableChunkSaveFailureEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_chunk_save_failure"),
						Config.INSTANCE.disableChunkSaveFailure
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableChunkSaveFailure = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableUnsecureServerWarningEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_unsecure_server_warning"),
						Config.INSTANCE.disableUnsecureServerWarning
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableUnsecureServerWarning = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		BooleanListEntry disableFriendSystemNotificationEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_friend_system_notification"),
						Config.INSTANCE.disableFriendSystemNotification
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableFriendSystemNotification = value)
				.setRequirement(() -> enabledEntry.getValue() && !disableEveryToastsEntry.getValue() && !disableSystemEntry.getValue())
				.build();

		systemToasts.addEntry(disableNarratorToggleEntry);
		systemToasts.addEntry(disableWorldBackupEntry);
		systemToasts.addEntry(disablePackLoadFailureEntry);
		systemToasts.addEntry(disableWorldAccessFailureEntry);
		systemToasts.addEntry(disablePackCopyFailureEntry);
		systemToasts.addEntry(disableFileDropFailureEntry);
		systemToasts.addEntry(disablePeriodicNotificationEntry);
		systemToasts.addEntry(disableLowDiskSpaceEntry);
		systemToasts.addEntry(disableChunkLoadFailureEntry);
		systemToasts.addEntry(disableChunkSaveFailureEntry);
		systemToasts.addEntry(disableUnsecureServerWarningEntry);
		systemToasts.addEntry(disableFriendSystemNotificationEntry);

		ConfigCategory soundCategory = builder.getOrCreateCategory(Component.translatable("toast_remover.config.category.sound"));

		BooleanListEntry disableEveryToastWhooshSoundEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_toast_whoosh_sound"),
						Config.INSTANCE.disableEveryToastWhooshSound
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableEveryToastWhooshSound = value)
				.setRequirement(enabledEntry::getValue)
				.build();

		BooleanListEntry disableHiddenToastWhooshSoundEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_hidden_toast_whoosh_sound"),
						Config.INSTANCE.disableHiddenToastWhooshSound
				)
				.setDefaultValue(true)
				.setSaveConsumer(value -> Config.INSTANCE.disableHiddenToastWhooshSound = value)
				.setRequirement(enabledEntry::getValue)
				.setTooltip(Component.translatable("toast_remover.config.disable_hidden_toast_whoosh_sound.tooltip"))
				.build();

		BooleanListEntry disableChallengeAdvancementSoundEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_challenge_advancement_sound"),
						Config.INSTANCE.disableChallengeAdvancementSound
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableChallengeAdvancementSound = value)
				.setRequirement(enabledEntry::getValue)
				.build();

		BooleanListEntry disableNonVanillaToastSoundsEntry = entryBuilder
				.startBooleanToggle(
						Component.translatable("toast_remover.config.disable_non_vanilla_toast_sounds"),
						Config.INSTANCE.disableNonVanillaToastSounds
				)
				.setDefaultValue(false)
				.setSaveConsumer(value -> Config.INSTANCE.disableNonVanillaToastSounds = value)
				.setRequirement(enabledEntry::getValue)
				.build();

		soundCategory.addEntry(disableEveryToastWhooshSoundEntry);
		soundCategory.addEntry(disableHiddenToastWhooshSoundEntry);
		soundCategory.addEntry(disableChallengeAdvancementSoundEntry);
		soundCategory.addEntry(disableNonVanillaToastSoundsEntry);

		return builder.build();
	}
}
