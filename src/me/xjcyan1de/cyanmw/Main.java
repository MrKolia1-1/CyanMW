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
    public static int PortalCheck, JoinPlayer, StartTimer, MissileSpawn, BarrierSpawn, FireballSpawn, MainSchedulerReg;

    public static int cfgGiveItemCooldown, cfgTimeAfterGame;


    public void onEnable() {
        tmapi = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        saveDefaultConfig();
        cfgGiveItemCooldown = plugin.getConfig().getInt("GiveItemCooldown");
        cfgTimeAfterGame = plugin.getConfig().getInt("TimeAfterGame");
        Bukkit.getPluginManager().registerEvents(new Game(), this);
        getCommand("cyanmw").setExecutor(new Command());

        PortalCheck = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::GameEnd, 0L, 1L);
        JoinPlayer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::AddPlayer, 0L, 5L);
        StartTimer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::StartTimer, 0L, 20L);
        MissileSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::MissileSpawn, 0L, 1L);
        BarrierSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::ShieldSpawn, 0L, 1L);
        FireballSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::FireballSpawn, 0L, 1L);
        //TODO: Перенести все шедулеры в отдельный класс
        MainSchedulerReg = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, MainScheduler::RunTasks, 0L, 1L);


        console.sendMessage(prefix + "§7Включен!");
    }

    /*
    public void SchedulerRandomGiveItem() {
        long cfgGiveItem = plugin.getConfig().getInt("GiveItemCooldown")*20;
        GiveRandomItem = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::GiveRandomItem, 0L, cfgGiveItem);
    }
    */

    public void onDisable() {
        console.sendMessage(prefix + "§7Выключен!");
    }

}

