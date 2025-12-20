package org.ccoding.adeathback.utils;

import org.bukkit.ChatColor;

public final class ColorUtils {
    private ColorUtils() {}

    public static String colorize(String text) {
        return text == null ? "" :
                ChatColor.translateAlternateColorCodes('&', text);
    }
}
