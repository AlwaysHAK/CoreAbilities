package net.alwayshak.cosmetics;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;


public enum Category {
    FEET(c("&aFeet Particles")),
    CHEST(c("&aChest Particles")),
    HEAD(c("&aHead Particles")),
    DAMAGE(c("&aDamage Particles")),
    KILL(c("&aKill Particles")),
    ARROW(c("&aArrow Particles")),
    ELYTRA(c("&aElytra Particles"));

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public ItemStack getItem() {
        ItemStack stack = new ItemStack(Material.STICK);
        ItemMeta meta = stack.getItemMeta();
        if (this == FEET) {
            stack.setType(Material.IRON_BOOTS);
            meta.setLore(Arrays.asList(c("&7Particles that show beneath your feet")));
        }
        if (this == CHEST) {
            stack.setType(Material.IRON_CHESTPLATE);
            meta.setLore(Arrays.asList(c("&7Particles that show at your chest")));
        }
        if (this == HEAD) {
            stack.setType(Material.IRON_HELMET);
            meta.setLore(Arrays.asList(c("&7Particles that show above your head")));
        }
        if (this == DAMAGE) {
            stack.setType(Material.IRON_SWORD);
            meta.setLore(Arrays.asList(c("&7Particles that show when you damage an entity")));
        }
        if (this == KILL) {
            stack.setType(Material.SKELETON_SKULL);
            meta.setLore(Arrays.asList(c("&7Particles that show when you kill an entity")));
        }
        if (this == ARROW) {
            stack.setType(Material.ARROW);
            meta.setLore(Arrays.asList(c("&7Particles that follow an arrow")));
        }
        if (this == ELYTRA) {
            stack.setType(Material.ELYTRA);
            meta.setLore(Arrays.asList(c("&7Particles that show when you fly with an elytra")));
        }
        meta.setDisplayName(this.name);
        stack.setItemMeta(meta);
        return stack;
    }

    public static Category getByName(String name) {
        for (Category category : values()) {
            if (category.getName().equals(name))
                return category;
        }
        return null;
    }

    public static Category getByStrippedName(String name) {
        return getByName(c("&a" + name));
    }

    private static String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


