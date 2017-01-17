package me.xjcyan1de.cyanmw;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String prefix = "§f[&cMissile&aWars] ";
    public static CommandSender console = Bukkit.getConsoleSender();
    Main plugin = this;

    public void onEnable() {
        console.sendMessage(prefix+"Включен!");

    }

    public void onDisable() {
        console.sendMessage(prefix+"Выключен!");
    }
}

