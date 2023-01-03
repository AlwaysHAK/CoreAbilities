package net.alwayshak.enchantments;

import net.alwayshak.Core;
import net.alwayshak.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnchantHandler {

    private final static List<CustomEnchant> ENCHANTMENTS = new ArrayList<>();

    public static List<CustomEnchant> getEnchantments() {
        return ENCHANTMENTS;
    }

    public static CustomEnchant getEnchant(String ench) {
        for (CustomEnchant enchant : ENCHANTMENTS) {
            if (enchant.getName().equalsIgnoreCase(ench)) {
                return enchant;
            }
        }
        return null;
    }

    public static boolean addEnchantment(ItemStack item, CustomEnchant customEnchant, int level) {
        item.addUnsafeEnchantment(customEnchant, level);
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<>();
            if (meta.hasLore())
                lore = meta.getLore();
            if (customEnchant.getMaxLevel() == 1) {
                lore.add(c("&r&7" + customEnchant.getDisplayName()));
            } else
                lore.add(c("&r&7" + customEnchant.getDisplayName() + " " + Utils.toRoman(level)));
            meta.setLore(lore);
            item.setItemMeta(meta);
            return true;
        }
        return false;
    }

    public static int hasEnchant(ItemStack item, CustomEnchant ench) {
        if (item != null) {
            if(item.getEnchantments().get(ench) != null)
                return item.getEnchantments().get(ench);
            else
                return 0;
        }
        return 0;
    }

    public static boolean removeEnchantment(ItemStack item, CustomEnchant customEnchant) {
        if (item.containsEnchantment(customEnchant)) {
            item.removeEnchantment(customEnchant);
            if (item.getItemMeta().hasLore()) {
                ItemMeta meta = item.getItemMeta();
                List<String> lore = meta.getLore();
                for (String str : lore) {
                    if (str.contains(customEnchant.getDisplayName())) {
                        lore.remove(str);
                        return true;
                    }
                }
            } else
                return true;
        }
        return false;
    }

    private static String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public void register(CustomEnchant enchant) {
        registerEnchantment(enchant);
        Bukkit.getPluginManager().registerEvents(enchant, Core.getPlugin(Core.class));
        ENCHANTMENTS.add(enchant);
    }

    private void registerEnchantment(Enchantment enchantment) {
        if (!((List) Arrays.<Enchantment>stream(Enchantment.values()).collect(Collectors.toList())).contains(enchantment))
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, Boolean.valueOf(true));
                Enchantment.registerEnchantment(enchantment);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}


