package ru.cyanworld.cyanmw;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
    private final Main main;
    public ItemStack bow, green_chestplate, red_chestplate, green_leggings, red_leggings, green_boots, red_boots, air;

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
        green_chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta green_chestplate_meta = (LeatherArmorMeta) green_chestplate.getItemMeta();
        green_chestplate_meta.setColor(Color.GREEN);
        green_chestplate_meta.setUnbreakable(true);
        green_chestplate.setItemMeta(green_chestplate_meta);

        //Красный грудак
        red_chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta red_chestplate_meta = (LeatherArmorMeta) red_chestplate.getItemMeta();
        red_chestplate_meta.setColor(Color.RED);
        red_chestplate_meta.setUnbreakable(true);
        red_chestplate.setItemMeta(red_chestplate_meta);

        //Зелёные поножи
        green_leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta green_leggings_meta = (LeatherArmorMeta) green_leggings.getItemMeta();
        green_leggings_meta.setColor(Color.GREEN);
        green_leggings_meta.setUnbreakable(true);
        green_leggings.setItemMeta(green_leggings_meta);

        //Красные поножи
        red_leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta red_leggings_meta = (LeatherArmorMeta) red_leggings.getItemMeta();
        red_leggings_meta.setColor(Color.RED);
        red_leggings_meta.setUnbreakable(true);
        red_leggings.setItemMeta(red_leggings_meta);

        //Зелёные ботинки
        green_boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta green_boots_meta = (LeatherArmorMeta) green_boots.getItemMeta();
        green_boots_meta.setColor(Color.GREEN);
        green_boots_meta.setUnbreakable(true);
        green_boots.setItemMeta(green_boots_meta);

        //Зелёные ботинки
        red_boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta red_boots_meta = (LeatherArmorMeta) red_boots.getItemMeta();
        red_boots_meta.setColor(Color.RED);
        red_boots_meta.setUnbreakable(true);
        red_boots.setItemMeta(red_boots_meta);
        
        //Воздух
        air = new ItemStack(Material.AIR);
    }
}
