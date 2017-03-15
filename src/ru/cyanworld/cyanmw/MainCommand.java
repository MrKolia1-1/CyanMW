package ru.cyanworld.cyanmw;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class MainCommand extends Command {

    private final Main main;

    public MainCommand(Main main) {
        super
                (
                        "cyanmw",
                        "Главная команда CyanMW",
                        "/cyanmw",
                        Collections.singletonList("снфтьц")
                );
        this.main = main;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        switch (args.length) {
            case 3:
                switch (args[0]) {
                    case "giveitem":
                        Player player = main.server.getPlayer(args[1]);
                        switch (args[2].toLowerCase()) {
                            case "bow" : player.getInventory().addItem(main.items.bow());
                            case "greenchestplate" : player.getInventory().addItem(main.items.greenChestplate());
                            case "redchestplate" : player.getInventory().addItem(main.items.redChestplate());
                            case "greenleggings" : player.getInventory().addItem(main.items.greenLeggings());
                            case "redleggings" : player.getInventory().addItem(main.items.redLeggings());
                            case "greenboots" : player.getInventory().addItem(main.items.greenBoots());
                            case "redboots" : player.getInventory().addItem(main.items.redBoots());
                        }
                        return true;
                    default:
                        sender.sendMessage(usageMessage);
                        return true;
                }
            default:
                sender.sendMessage(usageMessage);
                return true;
        }
    }
}
