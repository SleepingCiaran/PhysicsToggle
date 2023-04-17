package be.ciaran.physicstoggle;

import be.ciaran.physicstoggle.commands.TogglePhysics;
import be.ciaran.physicstoggle.listeners.BlockListener;
import be.ciaran.physicstoggle.listeners.EntityListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class PhysicsToggle extends JavaPlugin implements Listener {

    public final BlockListener blockListener = new BlockListener(this);
    public final EntityListener entityListener = new EntityListener(this);

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.getCommand("physics").setExecutor(new TogglePhysics(this));
        getServer().getPluginManager().registerEvents(this.blockListener, this);
        getServer().getPluginManager().registerEvents(this.entityListener, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
