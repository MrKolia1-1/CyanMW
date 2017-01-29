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
    public static int JoinPlayer, StartTimer, MissileSpawn, BarrierSpawn, FireballSpawn, MainSchedulerReg;

    public static int cfgGiveItemCooldown, cfgTimeAfterGame;
    public static boolean cfgUseResourcePack;


    public void onEnable() {
        tmapi = (TitleManagerAPI) Bukkit.getServer().getPluginManager().getPlugin("TitleManager");
        saveDefaultConfig();
        cfgGiveItemCooldown = plugin.getConfig().getInt("GiveItemCooldown");
        cfgTimeAfterGame = plugin.getConfig().getInt("TimeAfterGame");
        cfgUseResourcePack = plugin.getConfig().getBoolean("UseResourcePack");
        Bukkit.getPluginManager().registerEvents(new Game(), this);
        getCommand("cyanmw").setExecutor(new Command());

        //TODO: Перенести все шедулеры в отдельные классы
        JoinPlayer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::AddPlayer, 0L, 5L);
        StartTimer = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::StartTimer, 0L, 20L);
        MissileSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::MissileSpawn, 0L, 1L);
        BarrierSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::ShieldSpawn, 0L, 1L);
        FireballSpawn = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, Game::FireballSpawn, 0L, 1L);
        MainSchedulerReg = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, MainScheduler::RunTasks, 0L, 1L);


        console.sendMessage("§3[CyanMW v"+getServer().getPluginManager().getPlugin("CyanMW").getDescription().getVersion()+ "] §7Включен!");
        console.sendMessage(prefix+"§3 GiveItemCooldown: "+cfgGiveItemCooldown);
        console.sendMessage(prefix+"§3 TimeAfterGame: "+cfgTimeAfterGame);
        console.sendMessage(prefix+"§3 UseResourcePack: "+cfgUseResourcePack);

    }

    public void onDisable() {
        console.sendMessage(prefix + "§7Выключен!");
    }

}

