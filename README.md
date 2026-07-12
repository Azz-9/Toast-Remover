# Toast Remover

![Fabric](https://img.shields.io/badge/Loader-Fabric-blue)
![NeoForge](https://img.shields.io/badge/Loader-NeoForge-orange)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow)
![Environment: Client](https://img.shields.io/badge/Environment-Client-red)

Hide any toast, selectively disable toast sounds, and take full control over Minecraft's notifications with an extensive
and highly configurable client-side mod.

---

## Features

- Disable every toast with a single option.
- Disable individual vanilla toast categories
- Disable toast sound

---

## Installation

1. Download the jar for your loader from [Modrinth](https://modrinth.com/project/toast-remover)
   or [CurseForge](https://www.curseforge.com/minecraft/mc-mods/toast-remover)
2. Drop it into your `mods/` folder

**Optional but recommended:**

- [ModMenu](https://modrinth.com/mod/modmenu) — adds a mod list screen where you can access the config screen (fabric)
- [Cloth Config](https://modrinth.com/mod/cloth-config) — required for the in-game config screen

Without these, the mod works out of the box with its default settings. You can still configure it by editing the config
file manually (see below).

---

## Configuration

The config file is located at `.minecraft/config/toast_remover.json` and is created automatically on first launch.

### General

| Option               | Type    | Default | Description                               |
|----------------------|---------|:-------:|-------------------------------------------|
| `enabled`            | Boolean | `true`  | Enables or disables the mod.              |
| `disableEveryToasts` | Boolean | `false` | Hides every toast regardless of its type. |
| `disableNonVanilla`  | Boolean | `false` | Hides toasts added by other mods.         |

### Toast types

| Option               | Type    | Default | Description                       |
|----------------------|---------|:-------:|-----------------------------------|
| `disableAdvancement` | Boolean | `false` | Hides advancement toasts.         |
| `disableTutorial`    | Boolean | `false` | Hides tutorial toasts.            |
| `disableRecipe`      | Boolean | `false` | Hides recipe unlock toasts.       |
| `disableNowPlaying`  | Boolean | `false` | Hides music "Now Playing" toasts. |
| `disableSystem`      | Boolean | `false` | Hides every system toast.         |

### System Toasts

| Option                            | Type    | Default | Description                                     |
|-----------------------------------|---------|:-------:|-------------------------------------------------|
| `disableNarratorToggle`           | Boolean | `false` | Hides the narrator toggle notification.         |
| `disableWorldBackup`              | Boolean | `false` | Hides the world backup notification.            |
| `disablePackLoadFailure`          | Boolean | `false` | Hides resource pack load failure notifications. |
| `disableWorldAccessFailure`       | Boolean | `false` | Hides world access failure notifications.       |
| `disablePackCopyFailure`          | Boolean | `false` | Hides resource pack copy failure notifications. |
| `disableFileDropFailure`          | Boolean | `false` | Hides file drag-and-drop failure notifications. |
| `disablePeriodicNotification`     | Boolean | `false` | Hides periodic system notifications.            |
| `disableLowDiskSpace`             | Boolean | `false` | Hides low disk space warnings.                  |
| `disableChunkLoadFailure`         | Boolean | `false` | Hides chunk loading failure notifications.      |
| `disableChunkSaveFailure`         | Boolean | `false` | Hides chunk saving failure notifications.       |
| `disableUnsecureServerWarning`    | Boolean | `false` | Hides insecure server warning notifications.    |

### Sound

| Option                             | Type    | Default | Description                                                                              |
|------------------------------------|---------|:-------:|------------------------------------------------------------------------------------------|
| `disableEveryToastWhooshSound`     | Boolean | `false` | Disables the default toast show/hide sound.                                              |
| `disableHiddenToastWhooshSound`    | Boolean | `true`  | Disables the whoosh sound only for toasts hidden by the mod.                             |
| `disableChallengeAdvancementSound` | Boolean | `false` | Disables the special sound played for challenge advancements.                            |
| `disableNonVanillaToastSounds`     | Boolean | `false` | Disables custom sounds played by non-vanilla toasts while keeping vanilla sounds intact. |

---

## License

MIT — see [LICENSE](LICENSE) for details.