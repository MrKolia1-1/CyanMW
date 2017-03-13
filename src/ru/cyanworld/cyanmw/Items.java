package ru.cyanworld.cyanmw;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
    private final Main main;
    private ItemStack bow, greenchestplate, redchestplate, greenleggins, redleggins, greenboots, redboots;

    Items(Main main) {
        this.main = main;
        registerItems();
    }

    private void registerItems() {
        //Лук
        bow = new ItemStack(Material.BOW);
        bow.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
        bow.addEnchantment(Enchantment.ARROW_FIRE, 1);
        ItemMeta bowmeta = bow.getItemMeta();
        bowmeta.setUnbreakable(true);
        bow.setItemMeta(bowmeta);

        //Зелёный грудак
        greenchestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta greenchestplatemeta = (LeatherArmorMeta) greenchestplate.getItemMeta();
        greenchestplatemeta.setColor(Color.GREEN);
        greenchestplatemeta.setUnbreakable(true);
        greenchestplate.setItemMeta(greenchestplatemeta);
    }

    public ItemStack bow() {
        return bow;
    }

    public ItemStack greenchestplate() {
        return greenchestplate;
    }
}
