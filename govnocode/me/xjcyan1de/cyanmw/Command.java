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
                if (args[1].toLowerCase().equals("greenguardian")) {
                    GiveItem.GreenGuardian((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redguardian")) {
                    GiveItem.RedGuardian((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("greenlightning")) {
                    GiveItem.GreenLightning((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redlightning")) {
                    GiveItem.RedLightning((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("greenjuggernaut")) {
                    GiveItem.GreenJuggernaut((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redjuggernaut")) {
                    GiveItem.RedJuggernaut((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("greenshieldbuster")) {
                    GiveItem.GreenShieldbuster((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redshieldbuster")) {
                    GiveItem.RedShieldbuster((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("greentomahawk")) {
                    GiveItem.GreenTomahawk((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redtomahawk")) {
                    GiveItem.RedTomahawk((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("greenshield")) {
                    GiveItem.GreenShield((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("redshield")) {
                    GiveItem.RedShield((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                }
                if (args[1].toLowerCase().equals("fireball")) {
                    GiveItem.Fireball((Player) sender);
                    sender.sendMessage(prefix+"§7Выдано §b"+args[1]);
                    sender.sendMessage("kek "+args[1].toLowerCase());
                }
            }
        }
        return true;
    }
}
