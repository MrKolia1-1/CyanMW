package me.xjcyan1de.cyanmw;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static me.xjcyan1de.cyanmw.Main.cfgUseResourcePack;

public class GiveItem {
    private static ItemStack item;
    private static ItemMeta meta;
    //Я афк...
    //TODO: Сделать чтобы всем предметам выдавался тег Unbreakable=true если UseResourcePack=true
    public static void GreenGuardian(Player p) {
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 1);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 2);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.GUARDIAN, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 3);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.OCELOT, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 4);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.OCELOT, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 5);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.GHAST, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 6);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.GHAST, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 7);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.WITCH, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 8);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.WITCH, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 9);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.CREEPER, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        if (cfgUseResourcePack) {
            item = new ItemStack(Material.GOLD_HOE, 1);
            item.setDurability((short) 10);
            meta = item.getItemMeta();
            meta.setUnbreakable(true);
            item.setItemMeta(meta);
        } else item = SpawnEgg.get(EntityType.CREEPER, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        item = new ItemStack(Material.SNOW_BALL, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        item = new ItemStack(Material.SNOW_BALL, 1);
        ArrayList<String> lore = new ArrayList<String>();
        meta = item.getItemMeta();
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
        item = SpawnEgg.get(EntityType.BLAZE, 1);
        meta = item.getItemMeta();
        meta.setDisplayName("§eОгненный шар");
        item.setItemMeta(meta);
        if (!p.getInventory().containsAtLeast(item, 1)) {
            p.getInventory().addItem(item);
            p.sendMessage("§7+ Огненный шар");
        } else p.sendMessage("§7У вас уже есть огненный шар, используйте его");
    }
}
