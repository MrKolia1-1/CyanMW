package me.xjcyan1de.cyanmw;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GiveItem {
    public static void GreenGuardian(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёный страж");
        lore.add(" ");
        lore.add("§7Защищает от стрел");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§74 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёный страж");
        } else p.sendMessage("§7У вас уже есть Зелёный страж, используйте его");
    }

    public static void RedGuardian(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасный страж");
        lore.add(" ");
        lore.add("§7Защищает от стрел");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§74 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красный страж");
        } else p.sendMessage("§7У вас уже есть Красный страж, используйте его");
    }

    public static void GreenLightning(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.OCELOT, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёная молния");
        lore.add(" ");
        lore.add("§7Высокоскростная ракета");
        lore.add(" ");
        lore.add("§73.3 Блоков/сек");
        lore.add("§712 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёная молния");
        } else p.sendMessage("§7У вас уже есть Зелёная молния, используйте её");
    }

    public static void RedLightning(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.OCELOT, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасная молния");
        lore.add(" ");
        lore.add("§7Высокоскростная ракета");
        lore.add(" ");
        lore.add("§73.3 Блоков/сек");
        lore.add("§712 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красная молния");
        } else p.sendMessage("§7У вас уже есть Красная молния, используйте её");
    }

    public static void GreenJuggernaut(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GHAST, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёный Джаггернаут");
        lore.add(" ");
        lore.add("§7Огромный урон");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§722 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёный Джаггернаут");
        } else p.sendMessage("§7У вас уже есть Зелёный Джаггернаут, используйте его");
    }

    public static void RedJuggernaut(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.GHAST, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасный Джаггернаут");
        lore.add(" ");
        lore.add("§7Огромный урон");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§722 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красный Джаггернаут");
        } else p.sendMessage("§7У вас уже есть Красный Джаггернаут, используйте его");
    }

    public static void GreenShieldbuster(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.WITCH, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёный противобарьер");
        lore.add(" ");
        lore.add("§7Пробивает барьер");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§717 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёный противобарьер");
        } else p.sendMessage("§7У вас уже есть Зелёный противобарьер, используйте его");
    }

    public static void RedShieldbuster(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.WITCH, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасный противобарьер");
        lore.add(" ");
        lore.add("§7Пробивает барьер");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§717 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красный противобарьер");
        } else p.sendMessage("§7У вас уже есть Красный противобарьер, используйте его");
    }

    public static void GreenTomahawk(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.CREEPER, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёный томагавк");
        lore.add(" ");
        lore.add("§7Фронтальный взрыв");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§715 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёный томагавк");
        } else p.sendMessage("§7У вас уже есть Зелёный томагавк, используйте его");
    }

    public static void RedTomahawk(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.CREEPER, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасный томагавк");
        lore.add(" ");
        lore.add("§7Фронтальный взрыв");
        lore.add(" ");
        lore.add("§71.7 Блоков/сек");
        lore.add("§715 TNT");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красный томагавк");
        } else p.sendMessage("§7У вас уже есть Красный томагавк, используйте его");
    }

    public static void GreenShield(Player p) {
        ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§aЗелёный барьер");
        lore.add(" ");
        lore.add("§7Останавливает большинство ракет");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Зелёный барьер");
        } else p.sendMessage("§7У вас уже есть Зелёный барьер, используйте его");
    }

    public static void RedShield(Player p) {
        ItemStack item = new ItemStack(Material.SNOW_BALL, 1);
        ItemMeta meta = item.getItemMeta();
        ArrayList<String> lore = new ArrayList<String>();
        meta.setDisplayName("§cКрасный барьер");
        lore.add(" ");
        lore.add("§7Останавливает большинство ракет");
        meta.setLore(lore);
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Красный барьер");
        } else p.sendMessage("§7У вас уже есть Красный барьер, используйте его");
    }

    public static void Fireball(Player p) {
        ItemStack item = SpawnEgg.get(EntityType.BLAZE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§eОгненный шар");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Огненный шар");
        } else p.sendMessage("§7У вас уже есть огненный шар, используйте его");
    }
}
