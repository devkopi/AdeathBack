package org.ccoding.adeathback;

import org.bukkit.plugin.java.JavaPlugin;
import org.ccoding.adeathback.command.ABackCommand;
import org.ccoding.adeathback.command.AdeathCommand;
import org.ccoding.adeathback.listener.PlayerDeathListener;
import org.ccoding.adeathback.manager.DeathLocationManager;
import org.ccoding.adeathback.utils.MessageUtils;

public class Adeathback extends JavaPlugin {

    private DeathLocationManager deathLocationManager;
    private MessageUtils messageUtils;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        this.deathLocationManager = new DeathLocationManager(this);
        this.messageUtils = new MessageUtils(this);

        registerListeners();
        registerCommands();
    }


    @Override
    public void onDisable() {

    }

    public DeathLocationManager getDeathLocationManager() {
        return deathLocationManager;
    }

    public MessageUtils getMessageUtils() {
        return messageUtils;
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(
                new PlayerDeathListener(deathLocationManager, messageUtils),
                this
        );
    }

    private void registerCommands() {
        getCommand("aback").setExecutor(
                new ABackCommand(deathLocationManager, messageUtils)
        );
        getCommand("adeath").setExecutor(
                new AdeathCommand(this)
        );
    }
}
