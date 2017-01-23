package me.xjcyan1de.cyanmw;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;

import static me.xjcyan1de.cyanmw.Main.*;
import static org.bukkit.Bukkit.getServer;

class Game implements Listener{
    private static World world = getServer().getWorld("world");
    public static int GreenSize = 0;
    public static int RedSize = 0;
    private static int StartTimerSec = 10;
    private static Location RedSpawn = new Location(world, 71.5, 75, -64.5, 0, 0);
    private static Location GreenSpawn = new Location(world, 71.5, 75, 65.5, 180, 0);

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
                MWScheduler.cancelTask(PortalCheck);
                WonGame("RED");
            }
            //красный портал
            if (!world.getBlockAt(70, 70, -72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, -72).getType().equals(Material.PORTAL)) {
                MWScheduler.cancelTask(PortalCheck);
                WonGame("GREEN");
        }
    }

    private static void WonGame(String team) {
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

    private static void JoinGame(Player p) {
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

    static void StartTimer() {
        if (RedSize == 1 && GreenSize == 1) {
            String color = null;
            String subtitle = " ";

            if (StartTimerSec == 10 || StartTimerSec == 9 || StartTimerSec == 8 || StartTimerSec == 7 || StartTimerSec == 6) {
                color = "§a" + StartTimerSec;
            }
            if (StartTimerSec == 5 || StartTimerSec == 4) {
                color = "§e" + StartTimerSec;
            }

            if (StartTimerSec == 3 || StartTimerSec == 2) {
                color = "§c" + StartTimerSec;
            }

            if (StartTimerSec == 1) {
                color = "§1" + StartTimerSec;
            }

            if (StartTimerSec == 0) {
                //StartTimer.cancelAllTasks();
                color = "§bВзорвите портал";
                subtitle = "§bпротивника";
                MWScheduler.cancelTask(StartTimer);
            }

            for (Player p : Bukkit.getOnlinePlayers()) {
                tmapi.sendTitles(p, color, subtitle, 0, 60, 20);
            }

            StartTimerSec = StartTimerSec - 1;
        }
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


    @EventHandler
    public void SpawnMob(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Guardian) ((Guardian) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 5), true);
        if (event.getEntity() instanceof Ocelot) ((Ocelot) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 5), true);
        if (event.getEntity() instanceof Ghast) ((Ghast) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 5), true);
        if (event.getEntity() instanceof Witch) ((Witch) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 5), true);
        if (event.getEntity() instanceof Creeper) ((Creeper) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 5), true);
    }


    public static void MissileSpawn() {
        for (Entity entity : world.getEntities()) {
            if ((entity instanceof Guardian)){
                if (entity.getCustomName().equals("§aЗелёный страж")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("GreenGuardian", world, x, y, z, -1, -5, -10);
                    entity.remove();
                }

                if (entity.getCustomName().equals("§cКрасный страж")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("RedGuardian", world, x, y, z, -1, -5, 3);
                    entity.remove();
                }
            }
            if ((entity instanceof Ocelot)){
                if (entity.getCustomName().equals("§aЗелёная молния")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("GreenLightning", world, x, y, z, -1, -5, -12);
                    entity.remove();
                }

                if (entity.getCustomName().equals("§cКрасная молния")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("RedLightning", world, x, y, z, -1, -5, 4);
                    entity.remove();
                }
            }
            if ((entity instanceof Ghast)){
                if (entity.getCustomName().equals("§aЗелёный Джаггернаут")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("GreenJuggernaut", world, x, y, z, -1, -6, -13);
                    entity.remove();
                }

                if (entity.getCustomName().equals("§cКрасный Джаггернаут")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("RedJuggernaut", world, x, y, z, -1, -6, 3);
                    entity.remove();
                }
            }
            if ((entity instanceof Witch)){
                if (entity.getCustomName().equals("§aЗелёный противобарьер")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("GreenShieldbuster", world, x, y, z, -1, -6, -17);
                    entity.remove();
                }

                if (entity.getCustomName().equals("§cКрасный противобарьер")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("RedShieldbuster", world, x, y, z, -1, -6, 3);
                    entity.remove();
                }
            }
            if ((entity instanceof Creeper)){
                if (entity.getCustomName().equals("§aЗелёный томагавк")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("GreenTomahawk", world, x, y, z, -1, -5, -15);
                    entity.remove();
                }

                if (entity.getCustomName().equals("§cКрасный томагавк")) {
                    int x = entity.getLocation().getBlockX();
                    int y = entity.getLocation().getBlockY();
                    int z = entity.getLocation().getBlockZ();
                    StructureBlock.paste("RedTomahawk", world, x, y, z, 0, -5, 3);
                    entity.remove();
                }
            }
        }
    }
}