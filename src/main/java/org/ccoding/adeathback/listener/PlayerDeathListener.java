package org.ccoding.adeathback.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.ccoding.adeathback.manager.DeathLocationManager;
import org.ccoding.adeathback.utils.MessageUtils;

public class PlayerDeathListener implements Listener {

    private final DeathLocationManager deathManager;
    private final MessageUtils messageUtils;

    public PlayerDeathListener(
            DeathLocationManager deathManager,
            MessageUtils messageUtils
    ) {
        this.deathManager = deathManager;
        this.messageUtils = messageUtils;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        var player = event.getEntity();

        deathManager.setDeathLocation(
                player,
                player.getLocation().clone()
        );

        messageUtils.send(player, "death");
    }
}
