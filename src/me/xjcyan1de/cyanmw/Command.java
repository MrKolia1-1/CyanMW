package me.xjcyan1de.cyanmw;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.xjcyan1de.cyanmw.Main.prefix;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equals("cyanmw")) {
            if (args.length == 2 && args[0].equals("giveitem") && sender.hasPermission("cyanmw.giveitem")) {
                if (args[1].equals("GreenGuardian")) {
                    GiveItem.GreenGuardian((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("RedGuardian")) {
                    GiveItem.RedGuardian((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("GreenLightning")) {
                    GiveItem.GreenLightning((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("RedLightning")) {
                    GiveItem.RedLightning((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("GreenJuggernaut")) {
                    GiveItem.GreenJuggernaut((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("RedJuggernaut")) {
                    GiveItem.RedJuggernaut((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("GreenShieldbuster")) {
                    GiveItem.GreenShieldbuster((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("RedShieldbuster")) {
                    GiveItem.RedShieldbuster((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("GreenTomahawk")) {
                    GiveItem.GreenTomahawk((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].equals("RedTomahawk")) {
                    GiveItem.RedTomahawk((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
            }
        }
        return true;
    }
}
