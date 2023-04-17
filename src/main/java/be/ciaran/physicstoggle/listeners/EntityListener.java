package be.ciaran.physicstoggle.listeners;

import be.ciaran.physicstoggle.PhysicsToggle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;

public class EntityListener implements Listener {

    private PhysicsToggle plugin;

    public EntityListener(PhysicsToggle pl) {
        plugin = pl;
    }

    // Entity explode
    @EventHandler(ignoreCancelled = true)
    public void onEntityExplode(EntityExplodeEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("entity-explode")) {
            event.setCancelled(true);
        }
    }

    // Explosion prime
    @EventHandler(ignoreCancelled = true)
    public void onExplosionPrime(ExplosionPrimeEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("explosion-prime")) {
            event.setCancelled(true);
        }
    }

    // Creature spawn
    @EventHandler(ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("creature-spawn")) {
            event.setCancelled(true);
        }
    }
}
