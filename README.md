# AdeathBack

A lightweight **Minecraft Bukkit/Spigot** plugin that allows players to return to the **location of their last death** using a single command. Ideal for Survival, SMP, and Vanilla servers.

## Features
- Teleport to the last death location
- Automatically saves the location on death
- Simple and lightweight system
- Easy to use and configure

## Commands & Permissions
| Command | Description | Permission |
|--------|-------------|------------|
| `/aback` | Teleports the player to their last death location | `adeathback.use` |
| `/lastdeath` | Alias of `/aback` | `adeathback.use` |
| `/death` | Alias of `/aback` | `adeathback.use` |
| `/back` | Alias of `/aback` | `adeathback.use` |

> **Note:** All commands perform the same action.

## Command Usage
```bash
/aback
/lastdeath
/death
/back
```

## Output
```bas
    - "----------- &c&lYOU HAVE DIED&8&m -----------"
    - 
    - "&You can use /lastdeath or /death"
    - "&to return to the place of your death."
    - 
    - "&8&m----------- &c&lYOU HAVE DIED&8&m -----------"
```
> Fully configurable messages.

# Installation
1. Download the plugin from [Spigot](https://www.spigotmc.org/resources/adeathback.131953/) | [Modrinth]()
2. Place the plugin in the `plugins` folder of your Spigot server
3. Restart/Start your server