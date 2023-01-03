package net.alwayshak.cosmetics.gui;

import net.alwayshak.Core;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;


public class CosmeticsGUI
        implements Listener {
    private final Core core;
    private final CosmeticsHandler handler;

    public CosmeticsGUI(Core core, CosmeticsHandler handler) {
        this.core = core;
        this.handler = handler;
        Bukkit.getPluginManager().registerEvents(this, core);
    }

    public void open(Player target) {
        Inventory inv = GUI.getBordersHalfSized("Cosmetics");

        inv.setItem(4, Materials.getSimpleItem("&c&lDisable All", Material.REDSTONE_BLOCK));

        inv.addItem(Category.FEET.getItem());
        inv.addItem(Category.CHEST.getItem());
        inv.addItem(Category.HEAD.getItem());
        inv.addItem(Category.DAMAGE.getItem());
        inv.addItem(Category.ELYTRA.getItem());
        inv.addItem(Category.KILL.getItem());
        inv.addItem(Category.ARROW.getItem());
        target.openInventory(inv);
    }

    public void openCategory(Player target, Category category) {
        Inventory inv = GUI.getBordersFullSized(ChatColor.stripColor(category.getName()));

        for (Cosmetic cosmetic : this.handler.getCosmetics()) {
            if (cosmetic.getCategory() == category) {
                ItemStack stack = cosmetic.getItem();
                ItemMeta meta = stack.getItemMeta();
                if (cosmetic.hasUnlocked(target)) {
                    if (cosmetic.hasMember(target)) {
                        meta.setDisplayName(c("&r&a" + meta.getDisplayName()));
                        stack.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
                    } else {
                        meta.setDisplayName(c("&r&c" + meta.getDisplayName()));
                    }
                } else {
                    if (cosmetic.getRarity() == Rarity.SPECIAL)
                        continue;
                    meta.setDisplayName(c("&r&c" + cosmetic.getName()));
                    List<String> lore = meta.getLore();
                    lore.add(" ");
                    lore.add(c("&c&o(Locked)"));
                    meta.setLore(lore);
                    stack.setItemMeta(meta);
                    stack.setType(Material.BARRIER);
                }

                stack.setItemMeta(meta);
                inv.addItem(stack);
            }
        }
        target.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals("Cosmetics")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&c&lDisable All"))) {
                    for (Cosmetic cosmetic : this.handler.getEnabledCosmetics((Player) e.getWhoClicked())) {
                        cosmetic.removeMember(e.getWhoClicked().getUniqueId());
                    }
                }

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    e.getWhoClicked().closeInventory();
                }

                if (Category.getByName(meta.getDisplayName()) != null) {
                    openCategory((Player) e.getWhoClicked(), Category.getByName(meta.getDisplayName()));
                }
            }
        } else if (e.getView().getTitle().contains("Particles")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    open((Player) e.getWhoClicked());
                }

                if (meta.hasLore() &&
                        !meta.getLore().contains(c("&c&o(Locked)"))) {
                    for (Cosmetic cosmetic : this.handler.getCosmetics()) {
                        if (cosmetic.getItem().getItemMeta().getLore().get(0).equalsIgnoreCase(meta.getLore().get(0))) {
                            if (cosmetic.hasMember(e.getWhoClicked().getUniqueId())) {
                                cosmetic.removeMember(e.getWhoClicked().getUniqueId());
                                openCategory((Player) e.getWhoClicked(), Category.getByStrippedName(e.getView().getTitle()));
                                continue;
                            }
                            cosmetic.addMember(e.getWhoClicked().getUniqueId());
                            openCategory((Player) e.getWhoClicked(), Category.getByStrippedName(e.getView().getTitle()));
                        }
                    }
                }
            }
        }
    }


    @EventHandler
    public void onCloseInventory(InventoryCloseEvent e) {
        ((Player) e.getPlayer()).updateInventory();
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


