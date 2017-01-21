package me.xjcyan1de.cyanmw;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

import static me.xjcyan1de.cyanmw.Main.tmapi;
import static org.bukkit.Bukkit.getServer;

class Game implements Listener{
    static boolean GameRunning = true;
    public static World world = getServer().getWorld("world");
    static int GreenSize = 0;
    static int RedSize = 0;
    static Location RedSpawn = new Location(world, 71.5, 75, -64.5, 0, 0);
    static Location GreenSpawn = new Location(world, 71.5, 75, 65.5, 180, 0);

    static void AddPlayer() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            int x = p.getLocation().getBlockX();
            int y = p.getLocation().getBlockY();
            int z = p.getLocation().getBlockZ();
            if (x == -14 && y == 72 && z == 2) {
                JoinGame(p);
            }
            if (x == -14 && y == 72 && z == 1) {
                JoinGame(p);
            }
            if (x == -14 && y == 72 && z == 0) {
                JoinGame(p);
            }
            if (x == -14 && y == 72 && z == -1) {
                JoinGame(p);
            }
            if (x == -14 && y == 72 && z == -2) {
                JoinGame(p);
            }
        }
    }


    static void GameEnd() {
        //зелёный портал
        if (!world.getBlockAt(70, 70, 72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, 72).getType().equals(Material.PORTAL)) {
            GameRunning = false;
            Main.PortalCheck.cancelAllTasks();
            WonGame("RED");
        }
        //красный портал
        if (!world.getBlockAt(70, 70, -72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, -72).getType().equals(Material.PORTAL)) {
            GameRunning = false;
            Main.PortalCheck.cancelAllTasks();
            WonGame("GREEN");
        }
    }

    static void WonGame(String team) {
        if (team.equals("GREEN")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                tmapi.sendTitles(p, "§aЗелёная команда", "§aпобедила!");
                p.setGameMode(GameMode.SPECTATOR);
                StructureBlock.paste("GreenPegasus", world, 71, 80, 66, -15, 0, 0);
            }
        }
        if (team.equals("RED")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                tmapi.sendTitles(p, "§cКрасная команда", "§cпобедила!");
                p.setGameMode(GameMode.SPECTATOR);
                StructureBlock.paste("RedPegasus", world, 71, 80, -66, -15, 0, -22);
            }
        }
    }

    static void JoinGame(Player p) {
        p.sendMessage("ты заходишь");
        Scoreboard scoreboard = p.getScoreboard();
        Team Red = null;
        Team Green = null;
        try {
            Red = scoreboard.registerNewTeam("Красные");
            Green = scoreboard.registerNewTeam("Зелёные");
            Red.setPrefix("§c");
            Green.setPrefix("§a");
        } catch (IllegalArgumentException ignored){}

        if (RedSize >= GreenSize) {
            scoreboard.getTeam("Зелёные").addEntry(p.getName());
            GreenSize = GreenSize+1;

            p.setBedSpawnLocation(GreenSpawn);
            p.teleport(GreenSpawn);

            ItemStack bow = new ItemStack(Material.BOW);
            bow.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
            p.getInventory().addItem(bow);

        } else {
            scoreboard.getTeam("Красные").addEntry(p.getName());
            RedSize = RedSize+1;

            p.teleport(RedSpawn);

            ItemStack bow = new ItemStack(Material.BOW);
            bow.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
            p.getInventory().addItem(bow);
        }

        p.sendMessage("Красные "+RedSize);
        p.sendMessage("Зелёные "+GreenSize);
    }

    @EventHandler
    public void DeathScreen(PlayerDeathEvent e) {
        Player p = e.getEntity();
        p.setVelocity(new Vector(0, 0, 0));
        p.spigot().respawn();
    }

    @EventHandler
    public void Respawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        String pname = p.getName();
        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Красные")) {
            e.setRespawnLocation(RedSpawn);
            p.setVelocity(new Vector(0, -10, 0));
        }
        if (p.getScoreboard().getEntryTeam(pname).getName().equals("Зелёные")) {
            e.setRespawnLocation(GreenSpawn);
            p.setVelocity(new Vector(0, -10, 0));
        }
    }
}