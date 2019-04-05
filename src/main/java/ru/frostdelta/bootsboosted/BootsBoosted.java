package ru.frostdelta.bootsboosted;

import org.bukkit.plugin.java.JavaPlugin;

public final class BootsBoosted extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Developed by " + getDescription().getAuthors());
        getCommand("botinok1").setExecutor(new BootsCommand());
        getCommand("botinok2").setExecutor(new BootsCommand());
        getServer().getPluginManager().registerEvents(new DoubleJumpEvent(), this);
        getServer().getPluginManager().registerEvents(new JetPack(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
