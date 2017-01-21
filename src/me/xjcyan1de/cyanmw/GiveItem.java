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
        } else p.sendMessage("Этот предмет уже в инвентаре");
    }
}
