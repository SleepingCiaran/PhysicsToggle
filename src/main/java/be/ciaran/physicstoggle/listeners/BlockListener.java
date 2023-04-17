package be.ciaran.physicstoggle.listeners;

import be.ciaran.physicstoggle.PhysicsToggle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;

public class BlockListener implements Listener {

    private PhysicsToggle plugin;

    public BlockListener(PhysicsToggle pl) {
        plugin = pl;
    }

    // Fluids
    @EventHandler(ignoreCancelled = true)
    public void onBlockFromTo(BlockFromToEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("fluid-flow")) {
            event.setCancelled(true);
        }
    }

    // Block ignited
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockIgnite(BlockIgniteEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-ignited")) {
            event.setCancelled(true);
        }
    }

    // Block burn
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockBurn(BlockBurnEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-burn")) {
            event.setCancelled(true);
        }
    }

    // Block physics
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockPhysics(BlockPhysicsEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-physics")) {
            event.setCancelled(true);
        }
    }

    // Leave decay
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onLeavesDecay(LeavesDecayEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("leave-decay")) {
            event.setCancelled(true);
            return;
        }
    }

    // Block form
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockForm(BlockFormEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-form")) {
            event.setCancelled(true);
            return;
        }
    }

    // Block spread
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockSpread(BlockSpreadEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-spread")) {
            event.setCancelled(true);
            return;
        }
    }

    // Block explode
    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onBlockExplode(BlockExplodeEvent event) {
        if(plugin.getConfig().getBoolean("physics-blocked") && plugin.getConfig().getBoolean("block-explode")) {
            event.setCancelled(true);
            return;
        }
    }

}
