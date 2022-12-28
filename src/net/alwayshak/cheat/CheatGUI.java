package net.alwayshak.cheat;

import net.alwayshak.Core;
import net.alwayshak.config.ConfigHandler;
import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.CosmeticsHandler;
import net.alwayshak.cosmetics.Rarity;
import net.alwayshak.util.GUI;
import net.alwayshak.util.Materials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CheatGUI implements Listener {

    public void open(Player target) {
        Inventory inv = GUI.getFullHalfSized("Cheat Menu");

        inv.setItem(12, Materials.getSimpleItem("&bTokens", Material.BEACON));
        inv.setItem(13, Materials.getSimpleItem("&cAbility", Material.MAGMA_CREAM));
        inv.setItem(14, Materials.getSimpleItem("&aReload", Material.PAPER));

        target.openInventory(inv);
    }


    public void openReload(Player target) {
        Inventory inv = GUI.getFullHalfSized("Reload Menu");

        inv.setItem(11, Materials.getSimpleItem("&fReload Config", Material.WRITABLE_BOOK));
        inv.setItem(15, Materials.getSimpleItem("&bReload Server", Material.BEACON));
        inv.setItem(4, Materials.getSimpleItem("&aWhat to Reload?", Material.PAPER));

        target.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        String title = e.getView().getTitle();
        if(title.equalsIgnoreCase("Cheat Menu")) {
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c("&aReload"))) {
                openReload((Player)e.getWhoClicked());
            }
            e.setCancelled(true);
        }
        if(title.equalsIgnoreCase("Reload Menu")) {
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c("&bReload Server"))) {
                e.getWhoClicked().closeInventory();
                Bukkit.reload();
                e.getWhoClicked().sendMessage(c("&aReloaded Server"));
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(c("&fReload Config"))) {
                e.getWhoClicked().closeInventory();
                ConfigHandler.getInstance().loadNotesConfig();
                ConfigHandler.getInstance().loadNotesConfig();
                ConfigHandler.getInstance().loadPlayerConfig();
                e.getWhoClicked().sendMessage(c("&aReloaded Config Files"));
            }
            e.setCancelled(true);
        }
    }

    public void openTokens(Player target) {
        Inventory inv = GUI.getFullHalfSized("Token Menu");

        inv.setItem(11, Materials.getSimpleItem("&cRemove Tokens", Material.IRON_BLOCK));
        inv.setItem(15, Materials.getSimpleItem("&6Set Tokens   ", Material.GOLD_BLOCK));
        inv.setItem(4, Materials.getSimpleItem("&aAdd Tokens", Material.DIAMOND_BLOCK));

        target.openInventory(inv);
    }

    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        ((Player) e.getPlayer()).updateInventory();
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}

