package me.xjcyan1de.cyanmw;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import static me.xjcyan1de.cyanmw.Game.GameRuning;

public class Main extends JavaPlugin {

    static String prefix = "[§cMissile§aWars§r] ";
    static CommandSender console = Bukkit.getConsoleSender();
    Main plugin = this;
    static BukkitScheduler PortalCheck = Bukkit.getServer().getScheduler();

    public void onEnable() {
        console.sendMessage(prefix + "§rВключен!");

        checkPortal();
    }

    public void onDisable() {
        console.sendMessage(prefix + "§rВыключен!");
    }

    public void checkPortal() {
        if (GameRuning) {
            PortalCheck.scheduleSyncRepeatingTask(this, Game::GameEnd, 0L, 5L);
        }
    }
}

