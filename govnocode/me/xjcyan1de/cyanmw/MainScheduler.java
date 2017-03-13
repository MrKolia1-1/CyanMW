package me.xjcyan1de.cyanmw;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import static me.xjcyan1de.cyanmw.Game.*;
import static me.xjcyan1de.cyanmw.Main.cfgGiveItemCooldown;
import static me.xjcyan1de.cyanmw.Main.cfgTimeAfterGame;
import static me.xjcyan1de.cyanmw.Main.tmapi;

public class MainScheduler {

    static public Plugin plugin = Bukkit.getPluginManager().getPlugin("CyanMW");
    public static int timer;
    public static boolean schRandomItemGive = false;
    public static boolean schPostGame = false;
    public static boolean schPortalCheck = true;
    public static int postgametimer = 30;


    //Таймер
    public static void RunTasks() {
        RandomItemGive();
        GameEnd();
        PostGame();
        VoidKill();
        timer++;
    }

    //Выдача рандомных предметов каждые N секунд
    public static void RandomItemGive() {
        //20 тиков - 1 секунда
        int tick = cfgGiveItemCooldown * 20;
        if (schRandomItemGive && timer % tick == 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String pname = p.getName();
                int random = randomizer.nextInt(8);

                if (random == 0) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenGuardian(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedGuardian(p);
                    }
                    } catch (NullPointerException ignored){}
                }
                if (random == 1) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenLightning(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedLightning(p);
                    }
                    } catch (NullPointerException ignored){}
                }
                if (random == 2) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenJuggernaut(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedJuggernaut(p);
                    }
                    } catch (NullPointerException ignored){}

                }
                if (random == 3) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenShieldbuster(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedShieldbuster(p);
                    }
                    } catch (NullPointerException ignored){}

                }
                if (random == 4) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenTomahawk(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedTomahawk(p);
                    }
                    } catch (NullPointerException ignored){}

                }
                if (random == 5) {
                    try {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenShield(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedShield(p);
                    }
                    } catch (NullPointerException ignored){}
                }
                if (random == 6) {
                    try {
                        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                            GiveItem.Fireball(p);
                        }
                        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                            GiveItem.Fireball(p);
                        }
                    } catch (NullPointerException ignored){}
                }
                if (random == 7) {
                    try {
                        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                            p.getInventory().addItem(new ItemStack(Material.ARROW, 3));
                            tmapi.sendActionbar(p, "§e+ 3 стрелы");
                        }
                        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                            p.getInventory().addItem(new ItemStack(Material.ARROW, 3));
                            tmapi.sendActionbar(p, "§e+ 3 стрелы");
                        }
                    } catch (NullPointerException ignored){}
                }
            }
        }
    }


    static void GameEnd() {
        if (GreenSize >= 1 && RedSize >= 1 && schPortalCheck) {
            //зелёный портал
            if (!world.getBlockAt(70, 70, 72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, 72).getType().equals(Material.PORTAL)) {
                schPortalCheck = false;
                schRandomItemGive = false;
                WonGame("RED");
                for (Player p : Bukkit.getOnlinePlayers()) {
                    tmapi.sendActionbar(p, "§eСеврер перезапустится через " + cfgTimeAfterGame + " секунд");
                }
                timer = 1;
                schPostGame = true;
            }
            //красный портал
            if (!world.getBlockAt(70, 70, -72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, -72).getType().equals(Material.PORTAL)) {
                schPortalCheck = false;
                schRandomItemGive = false;
                WonGame("GREEN");
                for (Player p : Bukkit.getOnlinePlayers()) {
                    tmapi.sendActionbar(p, "§eСеврер перезапустится через " + cfgTimeAfterGame + " секунд");
                }
                timer = 1;
                schPostGame = true;
            }
        }
    }

    public static void PostGame() {
        if (schPostGame && timer % 20 == 0) {
            if (postgametimer == 1) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    ByteArrayDataOutput out = ByteStreams.newDataOutput();
                    out.writeUTF("Connect");
                    out.writeUTF("hub");
                    p.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
                }
            }
            if (postgametimer == -1) {
                Bukkit.spigot().restart();
            }
            postgametimer = postgametimer-1;
        }
    }

    public static void VoidKill() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().getBlockY() <= 0) {
                p.teleport(new Location(Bukkit.getWorld("world"), 0, -5000, 0));
                p.spigot().respawn();
            }
        }
    }
}