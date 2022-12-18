package net.alwayshak.enchantments.commands;

import net.alwayshak.enchantments.CustomEnchants;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomEnchantmentsCMD
        implements TabExecutor {
    public boolean onCommand(CommandSender s, Command cmd, String arg, String[] args) {
        if (s instanceof Player p) {
            if (args.length == 1) {
                String ench = args[0];
                if (ench.equalsIgnoreCase("cutclean")) {
                    getItem(p, Material.NETHERITE_PICKAXE, CustomEnchants.CUTCLEAN, 1);
                } else if (ench.equalsIgnoreCase("explosivetip")) {
                    getItem(p, Material.BOW, CustomEnchants.EXPLOSIVETIP, 1);
                } else if (ench.equalsIgnoreCase("levelhungerup")) {
                    getItem(p, Material.NETHERITE_HELMET, CustomEnchants.XPFEEDER, 1);
                } else if (ench.equalsIgnoreCase("obliterate")) {
                    getItem(p, Material.NETHERITE_PICKAXE, CustomEnchants.OBLITERATE, 1);
                } else if (ench.equalsIgnoreCase("poisonprot")) {
                    getItem(p, Material.NETHERITE_CHESTPLATE, CustomEnchants.POSIONPROTRECTION, 1);
                } else if (ench.equalsIgnoreCase("testbook")) {
                    ItemStack stack = new ItemStack(Material.ENCHANTED_BOOK);
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) stack.getItemMeta();
                    meta.addStoredEnchant(CustomEnchants.XPFEEDER, 1, true);
                    meta.setLore(Arrays.asList("" + ChatColor.GRAY + ChatColor.GRAY));
                    stack.setItemMeta(meta);
                    p.getInventory().addItem(stack);
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cWrong arguments."));
                }
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cWrong arguments."));
            }

        }
        return true;
    }

    public List<String> onTabComplete(CommandSender s, Command cmd, String arg, String[] args) {
        List<String> tab = new ArrayList<>();
        tab.add("cutclean");
        tab.add("explosivetip");
        tab.add("levelhungerup");
        tab.add("obliterate");
        tab.add("poisonprot");
        tab.add("testbook");
        return tab;
    }

    private void getItem(Player p, Material mat, Enchantment enchantment, int level) {
        ItemStack item = new ItemStack(mat);
        item.addUnsafeEnchantment(enchantment, level);

        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        if (enchantment.getMaxLevel() == 1) {
            lore.add("" + ChatColor.GRAY + ChatColor.GRAY);
        } else {
            lore.add("" + ChatColor.GRAY + ChatColor.GRAY + " " + enchantment.getName());
        }
        if (meta.hasLore()) {
            for (String i : meta.getLore()) {
                lore.add(i);
            }
        }
        meta.setLore(lore);
        item.setItemMeta(meta);
        p.getInventory().addItem(item);
    }
}


