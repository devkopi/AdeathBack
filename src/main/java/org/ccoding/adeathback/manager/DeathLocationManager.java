package org.ccoding.adeathback.manager;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.ccoding.adeathback.Adeathback;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DeathLocationManager {

    private final Adeathback plugin;
    private final Map<UUID, Location> deathLocations = new ConcurrentHashMap<>();

    public DeathLocationManager(Adeathback plugin) {
        this.plugin = plugin;
    }

    public void setDeathLocation(Player player, Location location) {
        deathLocations.put(player.getUniqueId(), location);
    }

    public Location getDeathLocation(Player player) {
        return deathLocations.get(player.getUniqueId());
    }

    public boolean hasDeathLocation(Player player) {
        return deathLocations.containsKey(player.getUniqueId());
    }

    public void clearDeathLocation(Player player) {
        deathLocations.remove(player.getUniqueId());
    }
}
