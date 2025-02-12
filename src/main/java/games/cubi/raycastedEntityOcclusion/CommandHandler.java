package games.cubi.raycastedEntityOcclusion;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    RaycastedEntityOcclusion plugin;

    public CommandHandler(RaycastedEntityOcclusion plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0 && args[0].equalsIgnoreCase("reload")) {
            plugin.loadConfig();
            plugin.getCheckEntityVisibility().updateConfigValues();
            sender.sendMessage("RaycastedEntityOcclusion config reloaded.");
            return true;
        }
        sender.sendMessage("RaycastedEntityOcclusion v" + plugin.getDescription().getVersion());
        sender.sendMessage("AlwaysShowRadius: " + plugin.alwaysShowRadius);
        sender.sendMessage("RaycastRadius: " + plugin.raycastRadius);
        sender.sendMessage("SearchRadius: " + plugin.searchRadius);
        sender.sendMessage("MoreChecks: " + plugin.moreChecks);
        sender.sendMessage("OccludePlayers: " + plugin.occludePlayers);
        sender.sendMessage("RecheckInterval: " + plugin.recheckInterval);
        return true;
    }
}
