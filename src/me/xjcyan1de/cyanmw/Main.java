package me.xjcyan1de.cyanmw;

import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import static me.xjcyan1de.cyanmw.Game.GameRunning;

public class Main extends JavaPlugin {

    static String prefix = "[CyanMW] ";
    private static CommandSender console = Bukkit.getConsoleSender();
    static BukkitScheduler PortalCheck = Bukkit.getServer().getScheduler();
    private static BukkitScheduler JoinGame = Bukkit.getServer().getScheduler();
    public static TitleManagerAPI tmapi;

    public void onEnable() {
        console.sendMessage(prefix + "§rВключен!");

        tmapi = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        Bukkit.getPluginManager().registerEvents(new Game(), this);
        schedulerCheckPortal();
        schedulerAddPlayer();
    }

    public void onDisable() {
        console.sendMessage(prefix + "§rВыключен!");
    }

    private void schedulerCheckPortal() {
        if (GameRunning) {
            PortalCheck.scheduleSyncRepeatingTask(this, Game::GameEnd, 0L, 5L);
        } else Main.PortalCheck.cancelAllTasks();
    }

    private void schedulerAddPlayer() {
        if (GameRunning) {
            JoinGame.scheduleSyncRepeatingTask(this, Game::AddPlayer, 0L, 5L);
        }
    }
}

