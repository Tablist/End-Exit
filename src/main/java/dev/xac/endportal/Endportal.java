package dev.xac.endportal;

import dev.xac.endportal.listener.EndListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Endportal extends JavaPlugin {

    @Getter
    private static  Endportal plugin;

    @Override
    public void onEnable() {
        Endportal.plugin = this;

        new EndListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
