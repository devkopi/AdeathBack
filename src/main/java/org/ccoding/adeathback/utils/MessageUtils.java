package org.ccoding.adeathback.utils;

import org.bukkit.command.CommandSender;
import org.ccoding.adeathback.Adeathback;

import java.util.*;

public class MessageUtils {

    private final Adeathback plugin;
    private final Map<String, List<String>> messages = new HashMap<>();

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

            String path = "messages." + key;

            // Si es una lista
            if (plugin.getConfig().isList(path)) {
                List<String> lines = plugin.getConfig().getStringList(path);
                List<String> colored = new ArrayList<>();

                for (String line : lines) {
                    colored.add(ColorUtils.colorize(line));
                }

                messages.put(key, colored);

                // Si es un solo String
            } else {
                messages.put(
                        key,
                        Collections.singletonList(
                                ColorUtils.colorize(
                                        plugin.getConfig().getString(path)
                                )
                        )
                );
            }
        }
    }

    public void send(CommandSender sender, String key) {
        List<String> message = messages.get(key);

        if (message == null) {
            sender.sendMessage("§cMensaje no encontrado: messages." + key);
            return;
        }

        for (String line : message) {
            sender.sendMessage(line);
        }
    }
}
