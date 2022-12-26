package net.alwayshak.enchantments.old.events;

import net.alwayshak.enchantments.old.CustomEnchants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public class AnvilHandler
        implements Listener {
    @EventHandler
    public void anvilPrepare(PrepareAnvilEvent e) {
        AnvilInventory i = e.getInventory();

        if (i.getItem(0) != null && i.getItem(1) != null) {
            ItemStack s1 = i.getItem(0);
            ItemStack s2 = i.getItem(1);
            if (s2.getType() == Material.ENCHANTED_BOOK) {
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) s2.getItemMeta();
                if (meta.getStoredEnchants().containsKey(CustomEnchants.XPFEEDER) &&
                        !s1.getItemMeta().hasConflictingEnchant(CustomEnchants.XPFEEDER) && !s1.getItemMeta().hasEnchant(CustomEnchants.XPFEEDER)) {
                    ItemStack result = s1.clone();
                    ItemMeta resultMeta = result.getItemMeta();
                    if (resultMeta.hasLore()) {
                        resultMeta.getLore().add("" + ChatColor.GRAY + "XP Feeder");
                    } else {
                        resultMeta.setLore(Arrays.asList("" + ChatColor.GRAY + "XP Feeder"));
                    }
                    resultMeta.addEnchant(CustomEnchants.XPFEEDER, 1, false);
                    result.setItemMeta(resultMeta);
                    i.setRepairCost(1);
                    e.setResult(result);
                }
            }
        }
    }
}


