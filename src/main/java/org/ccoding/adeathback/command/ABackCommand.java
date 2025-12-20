package org.ccoding.adeathback.command;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.ccoding.adeathback.manager.DeathLocationManager;
import org.ccoding.adeathback.utils.MessageUtils;

public class ABackCommand implements CommandExecutor {

    private final DeathLocationManager deathManager;
    private final MessageUtils messageUtils;

    public ABackCommand(
            DeathLocationManager deathManager,
            MessageUtils messageUtils
    ) {
        this.deathManager = deathManager;
        this.messageUtils = messageUtils;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            messageUtils.send(sender, "only-player");
            return true;
        }

        if (!deathManager.hasDeathLocation(player)) {
            messageUtils.send(player, "back-no-location");
            return true;
        }

        Location location = deathManager.getDeathLocation(player);
        player.teleport(location);
        deathManager.clearDeathLocation(player);

        messageUtils.send(player, "back-success");
        return true;
    }
}
