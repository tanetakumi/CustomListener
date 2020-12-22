package net.serveron.mcstar.customlistener;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomListener extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new CommandManager(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
