package me.xjcyan1de.cyanmw;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if (cmd.getName().equals("cyanmw")) {
            if (args.length == 2 && args[0].equals("giveitem") && sender.hasPermission("cyanmw.giveitem")) {
                if (args[1].equals("GreenGuardian")) {
                    Bukkit.broadcastMessage("GreenGuardian");
                    GiveItem.GreenGuardian((Player) sender);
                    sender.sendMessage("Выдано "+args[1]);
                }
            }
        }
        return true;
        //команда /cyanmw giveitem GreenGuardian выдаёт ракету
    }
}
