package org.ccoding.adeathback.utils;

import org.bukkit.command.CommandSender;
import org.ccoding.adeathback.Adeathback;

import java.util.HashMap;
import java.util.Map;

public class MessageUtils {

    private final Adeathback plugin;
    private final Map<String, String> messages = new HashMap<>();

    public MessageUtils(Adeathback plugin) {
        this.plugin = plugin;
        loadMessages();
    }

    public void loadMessages() {
        messages.clear();

        if (plugin.getConfig().getConfigurationSection("messages") == null) {
            return;
        }

        for (String key : plugin.getConfig()
                .getConfigurationSection("messages")
                .getKeys(false)) {

            messages.put(
                    key,
                    ColorUtils.colorize(
                            plugin.getConfig().getString("messages." + key)
                    )
            );
        }
    }

    public void send(CommandSender sender, String key) {
        sender.sendMessage(
                messages.getOrDefault(
                        key,
                        "§cMensaje no encontrado: messages." + key
                )
        );
    }
}
