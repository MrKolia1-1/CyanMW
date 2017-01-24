package me.xjcyan1de.cyanmw;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static me.xjcyan1de.cyanmw.Game.LastMissile;
import static me.xjcyan1de.cyanmw.Game.randomizer;
import static me.xjcyan1de.cyanmw.Main.cfgGiveItemCooldown;
import static me.xjcyan1de.cyanmw.Main.cfgTimeAfterGame;

public class MainScheduler {

    public static int timer;
    public static boolean schRandomItemGive = false;
    public static boolean schPostGame = false;


    //Таймер
    public static void RunTasks() {
        RandomItemGive();
        PostGame();
        VoidKill();
        timer++;
    }

    //Выдача рандомных предметов каждые N секунд
    public static void RandomItemGive() {
        //20 тиков - 1 секунда
        int tick = cfgGiveItemCooldown*20;
        if (schRandomItemGive && timer % tick == 0) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                String pname = p.getName();
                int random = randomizer.nextInt(8);
                if (random == LastMissile) {
                    RandomItemGive();
                    break;
                }
                if (random == 0) {
                    LastMissile = 0;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenGuardian(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedGuardian(p);
                    }
                }
                if (random == 1) {
                    LastMissile = 1;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenLightning(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedLightning(p);
                    }
                }
                if (random == 2) {
                    LastMissile = 2;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenJuggernaut(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedJuggernaut(p);
                    }
                }
                if (random == 3) {
                    LastMissile = 3;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenShieldbuster(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedShieldbuster(p);
                    }
                }
                if (random == 4) {
                    LastMissile = 4;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenTomahawk(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedTomahawk(p);
                    }
                }
                if (random == 5) {
                    LastMissile = 5;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.GreenShield(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.RedShield(p);
                    }
                }
                if (random == 6) {
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        GiveItem.Fireball(p);
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        GiveItem.Fireball(p);
                    }
                }
                if (random == 7) {
                    LastMissile = 7;
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
                        p.getInventory().addItem(new ItemStack(Material.ARROW, 3));
                        p.sendMessage("§7+ 3 стрелы");
                    }
                    if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
                        p.getInventory().addItem(new ItemStack(Material.ARROW, 3));
                        p.sendMessage("§7+ 3 стрелы");
                    }
                }
            }
        }
    }

    public static void PostGame() {

        int tick = cfgTimeAfterGame*20;
        if (schPostGame && timer % tick == 0) {
            Bukkit.getServer().spigot().restart();
        }
    }

    public static void VoidKill() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getLocation().getBlockY() <= 0) {
                p.setHealth(0);
                p.spigot().respawn();
            }
        }
    }
}