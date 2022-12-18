package net.alwayshak.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class GUI {
    public static Inventory getBordersFullSized(String name) {
        Inventory inv = Bukkit.createInventory(null, 54, name);

        ItemStack border = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c"));
        border.setItemMeta(borderMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cClose"));
        close.setItemMeta(closeMeta);

        for (int i = 0; i < 54; i++) {
            if (i < 10 || i > 43 || i == 9 || i == 18 || i == 27 || i == 36 || i == 17 || i == 26 || i == 35)
                inv.setItem(i, border);
        }
        inv.setItem(49, close);
        return inv;
    }

    public static Inventory getBordersHalfSized(String name) {
        Inventory inv = Bukkit.createInventory(null, 27, name);

        ItemStack border = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c"));
        border.setItemMeta(borderMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cClose"));
        close.setItemMeta(closeMeta);

        for (int i = 0; i < 27; i++) {
            if (i < 10 || i > 16) {
                inv.setItem(i, border);
            }
        }
        inv.setItem(22, close);

        return inv;
    }

    public static Inventory getFullHalfSized(String name) {
        Inventory inv = Bukkit.createInventory(null, 27, name);

        ItemStack border = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta borderMeta = border.getItemMeta();
        borderMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c"));
        border.setItemMeta(borderMeta);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cClose"));
        close.setItemMeta(closeMeta);

        for (int i = 0; i < 27; i++) {
            inv.setItem(i, border);
        }

        inv.setItem(22, close);

        return inv;
    }

    public static Inventory getLootCrateInventory(Material material1, Material material2, String name) {
        Inventory inv = Bukkit.createInventory(null, 27, name);

        ItemStack i1 = Materials.getSimpleItem(" ", material1);
        ItemStack i2 = Materials.getSimpleItem(" ", material2);

        for (int i = 0; i < 27; i++) {
            if (i != 13) {
                if (Utils.isEven(i)) {
                    inv.setItem(i, i1);
                } else {
                    inv.setItem(i, i2);
                }
            }
        }
        return inv;
    }
}


