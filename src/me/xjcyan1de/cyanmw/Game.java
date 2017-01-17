package me.xjcyan1de.cyanmw;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;

import static me.xjcyan1de.cyanmw.Main.prefix;
import static org.bukkit.Bukkit.getServer;

class Game {

    static boolean GameRuning = true;

    static void GameEnd() {
        World world = getServer().getWorld("world");
        if (!world.getBlockAt(70, 70, -72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, -72).getType().equals(Material.PORTAL)) {
            Bukkit.broadcastMessage(prefix+"У красных нет портала");
            GameRuning = false;
            Main.PortalCheck.cancelAllTasks();
        }

        if (!world.getBlockAt(70, 70, 72).getType().equals(Material.PORTAL) || !world.getBlockAt(72, 70, 72).getType().equals(Material.PORTAL)) {
            Bukkit.broadcastMessage(prefix+"У зелёных нет портала");
            GameRuning = false;
            Main.PortalCheck.cancelAllTasks();
        }
    }
}
