package net.alwayshak.cosmetics;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public abstract class Cosmetic
        implements Listener {
    private final String name;
    private final String description;
    private final Category category;
    private final List<UUID> members;
    private final List<UUID> unlocked;
    private ItemStack item;
    private final Rarity rarity;
    private boolean spin;

    public Cosmetic(String name, String description, Category category, Material material, Rarity rarity) {
        this.name = name;
        this.description = description;
        this.members = new ArrayList<>();
        this.unlocked = new ArrayList<>();
        this.category = category;
        this.rarity = rarity;
        ItemStack stack = new ItemStack(material, 1);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(getName());
        meta.setLore(Arrays.asList(c("&7" + getDescription()), " ", rarity.getName()));
        stack.setItemMeta(meta);
        this.item = stack;
    }

    public void setSpin(boolean spin) {
        this.spin = spin;
    }

    public boolean hasSpin() {
        return this.spin;
    }

    public Rarity getRarity() {
        return this.rarity;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Category getCategory() {
        return this.category;
    }

    public List<UUID> getMembers() {
        return this.members;
    }

    public ItemStack getItem() {
        return this.item.clone();
    }

    public void addMember(UUID uuid) {
        this.members.add(uuid);
    }

    public void addMember(Player p) {
        this.members.add(p.getUniqueId());
    }

    public void removeMember(UUID uuid) {
        this.members.remove(uuid);
    }

    public void removeMember(Player p) {
        this.members.remove(p.getUniqueId());
    }

    public boolean hasMember(UUID uuid) {
        return this.members.contains(uuid);
    }

    public boolean hasMember(Player p) {
        return hasMember(p.getUniqueId());
    }

    public List<UUID> getUnlocked() {
        return this.unlocked;
    }

    public boolean hasUnlocked(Player p) {
        return this.unlocked.contains(p.getUniqueId());
    }

    public boolean hasUnlocked(UUID uuid) {
        return this.unlocked.contains(uuid);
    }

    public void addUnlocked(Player p) {
        if (!this.unlocked.contains(p.getUniqueId()))
            this.unlocked.add(p.getUniqueId());
    }

    public void addUnlocked(UUID uuid) {
        if (!this.unlocked.contains(uuid))
            this.unlocked.add(uuid);
    }

    public void removeUnlocked(Player p) {
        this.unlocked.remove(p.getUniqueId());
    }

    public void removeUnlocked(UUID uuid) {
        this.unlocked.remove(uuid);
    }

    public abstract void onActivate(Location paramLocation);

    protected String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


