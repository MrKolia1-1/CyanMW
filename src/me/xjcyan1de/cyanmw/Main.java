package me.xjcyan1de.cyanmw;

import io.puharesource.mc.titlemanager.api.v2.TitleManagerAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {

    static String prefix = "§3[CyanMW] ";
    public Main plugin = this;
    private static CommandSender console = Bukkit.getConsoleSender();
    static TitleManagerAPI tmapi;
    public static BukkitScheduler MWScheduler = Bukkit.getScheduler();
    public static int PortalCheck, JoinPlayer, StartTimer, MissileSpawn, BarrierSpawn;

    public void onEnable() {
        console.sendMessage(prefix + "§7Включен!");

        tmapi = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        Bukkit.getPluginManager().registerEvents(new Game(), this);
        getCommand("cyanmw").setExecutor(new Command());

        PortalCheck = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::GameEnd, 0L, 1L);
        JoinPlayer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::AddPlayer, 0L, 5L);
        StartTimer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::StartTimer, 0L, 20L);
        MissileSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::MissileSpawn, 0L, 1L);
        BarrierSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::ShieldSpawn, 0L, 1L);

    }

    public void onDisable() {
        console.sendMessage(prefix + "§7Выключен!");
    }
}

