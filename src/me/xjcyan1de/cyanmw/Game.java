package me.xjcyan1de.cyanmw;

import net.minecraft.server.v1_11_R1.BlockPosition;
import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.TileEntityStructure;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
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

import static me.xjcyan1de.cyanmw.Main.prefix;
import static me.xjcyan1de.cyanmw.Main.tmapi;
import static org.bukkit.Bukkit.getServer;

class Game implements Listener{
    static boolean GameRunning = true;
    private static World world = getServer().getWorld("world");
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
            Bukkit.broadcastMessage(prefix + "У зелёных нет портала");
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
                Block block = world.getBlockAt(71, 80, 66);
                block.setType(Material.STRUCTURE_BLOCK, false);
                BlockPosition pos = new BlockPosition(block.getX(), block.getY(), block.getZ());
                TileEntityStructure structure = (TileEntityStructure)((CraftPlayer)p).getHandle().world.getTileEntity(pos);
                structure.a(createNBTstructure("GreenPegasus", 71, 80, 66, 31, 17, 23, -15, 0, 0));
                world.getBlockAt(71, 81, 66).setType(Material.REDSTONE_BLOCK);
            }
        }
        if (team.equals("RED")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                tmapi.sendTitles(p, "§cКрасная команда", "§cпобедила!");
                p.setGameMode(GameMode.SPECTATOR);
                Block block = world.getBlockAt(71, 80, -66);
                block.setType(Material.STRUCTURE_BLOCK, false);
                BlockPosition pos = new BlockPosition(block.getX(), block.getY(), block.getZ());
                TileEntityStructure structure = (TileEntityStructure)((CraftPlayer)p).getHandle().world.getTileEntity(pos);
                structure.a(createNBTstructure("RedPegasus", 71, 80, -66, 31, 17, 23, -15, 0, -22));
                world.getBlockAt(71, 81, -66).setType(Material.REDSTONE_BLOCK);
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

    public static NBTTagCompound createNBTstructure(String name, int x, int y, int z, int sizeX, int sizeY, int sizeZ, int posX, int posY, int posZ) {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setString("id", "Structure");
        nbttagcompound.setInt("x", x);
        nbttagcompound.setInt("y", y);
        nbttagcompound.setInt("z", z);
        nbttagcompound.setString("name", name);
        nbttagcompound.setString("author", "XjCyan1de");
        nbttagcompound.setString("metadata", "");
        nbttagcompound.setInt("posX", posX);
        nbttagcompound.setInt("posY", posY);
        nbttagcompound.setInt("posZ", posZ);
        nbttagcompound.setInt("sizeX", sizeX);
        nbttagcompound.setInt("sizeY", sizeY);
        nbttagcompound.setInt("sizeZ", sizeZ);
        nbttagcompound.setString("rotation", "NONE");
        nbttagcompound.setString("mirror", "NONE");
        nbttagcompound.setString("mode", "LOAD");
        nbttagcompound.setByte("ignoreEntities", (byte) 1);
        nbttagcompound.setBoolean("powered", false);
        nbttagcompound.setBoolean("showair", false);
        nbttagcompound.setBoolean("showboundingbox", true);
        nbttagcompound.setFloat("integrity", 1.0f);
        nbttagcompound.setLong("seed", 0);
        return nbttagcompound;
    }
}