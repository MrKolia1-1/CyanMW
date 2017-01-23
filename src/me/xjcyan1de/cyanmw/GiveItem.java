package me.xjcyan1de.cyanmw;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveItem {
    public static void GreenGuardian(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aЗелёный страж");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void RedGuardian(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cКрасный страж");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void GreenLightning(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.OCELOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aЗелёная молния");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void RedLightning(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.OCELOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cКрасная молния");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void GreenJuggernaut(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GHAST, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aЗелёный Джаггернаут");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void RedJuggernaut(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GHAST, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cКрасный Джаггернаут");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void GreenShieldbuster(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.WITCH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aЗелёный противобарьер");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void RedShieldbuster(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.WITCH, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cКрасный противобарьер");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void GreenTomahawk(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.CREEPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aЗелёный томагавк");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
    public static void RedTomahawk(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.CREEPER, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§cКрасный томагавк");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
        }
    }
}
