package be.ciaran.physicstoggle.commands;

import be.ciaran.physicstoggle.PhysicsToggle;
import me.dave.chatcolorhandler.ChatColorHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TogglePhysics implements CommandExecutor {

    private PhysicsToggle plugin;

    public TogglePhysics(PhysicsToggle pl) {
        plugin = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("physicstoggle.toggle")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fUsage: &3/physics <on/off/reload>"));
                return true;
            }
            if (args[0].equalsIgnoreCase("reload")) {
                plugin.reloadConfig();
                sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&aPhysicsToggle V" + plugin.getDescription().getVersion() + " has been reloaded!"));
            } else if (args[0].equalsIgnoreCase("on")) {
                if (plugin.getConfig().getBoolean("physics-blocked")) {
                    sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fPhysics are already &ablocked&f."));
                } else {
                    plugin.getConfig().set("physics-blocked", true);
                    plugin.saveConfig();
                    sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fPhysics have been &ablocked&f!"));
                }
            } else if (args[0].equalsIgnoreCase("off")) {
                if (!(plugin.getConfig().getBoolean("physics-blocked"))) {
                    sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fPhysics are already &cunblocked&f."));
                } else {
                    plugin.getConfig().set("physics-blocked", false);
                    plugin.saveConfig();
                    sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fPhysics have been &cunblocked&f!"));
                }
            } else {
                sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + "&fUsage: &3/physics <on/off/reload>"));
            }
        } else {
            sender.sendMessage(ChatColorHandler.translateAlternateColorCodes(plugin.getConfig().getString("prefix") + plugin.getConfig().getString("permission-denied")));
        }
        return true;
    }
}
