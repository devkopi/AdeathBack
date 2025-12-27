package org.ccoding.adeathback.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.ccoding.adeathback.Adeathback;

public class AdeathCommand implements CommandExecutor {

    private final Adeathback plugin;

    public AdeathCommand(Adeathback plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {

            if (!sender.hasPermission("adeathback.admin")) {
                plugin.getMessageUtils().send(sender, "no-permission");
                return true;
            }

            long start = System.nanoTime();

            plugin.reloadConfig();
            plugin.getMessageUtils().loadMessages();

            long end = System.nanoTime();

            plugin.getMessageUtils().send(sender, "reload-success");


            return true;
        }

        plugin.getMessageUtils().send(sender, "unknown-command");
        return true;
    }
}
