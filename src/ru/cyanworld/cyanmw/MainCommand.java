package ru.cyanworld.cyanmw;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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
                        main.utils.giveItem(args[2].toLowerCase(), player);
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
