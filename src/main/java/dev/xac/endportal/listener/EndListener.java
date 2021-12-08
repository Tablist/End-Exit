package dev.xac.endportal.listener;

import dev.xac.endportal.Endportal;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class EndListener implements  Listener {

    public EndListener(Endportal plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGHEST)
    public void onPlayerPortal(PlayerPortalEvent event) {
        Location endSpawnLocation = Bukkit.getWorld("world_the_end").getSpawnLocation();
        Location endExitLocation = new Location(Bukkit.getWorld("world"), 0, 70, 200);
        endSpawnLocation.setYaw(89.0f);
        endExitLocation.setYaw(0.0f);
        if (event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL) {
            if (event.getPlayer().getWorld().getEnvironment() == World.Environment.THE_END) {
                event.getPlayer().teleport(endExitLocation);
            }
            else if (event.getFrom().getWorld().getEnvironment() == World.Environment.NORMAL) {
                event.getPlayer().teleport(endSpawnLocation);
            }
            event.setCancelled(true);
        }
    }
}
