package net.alwayshak.notes;

import net.alwayshak.Core;
import net.alwayshak.config.ConfigHandler;
import net.alwayshak.util.GUI;
import net.alwayshak.util.Materials;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NotesGUI implements Listener {
    private final Core core;
    private static final ConfigHandler configHandler = ConfigHandler.getInstance();
    private static final FileConfiguration config = ConfigHandler.getInstance().getPlayer();


    private final HashMap<Player, String> add;


    private final HashMap<Player, Note> remove;


    public NotesGUI(Core core) {
        this.add = new HashMap<>();
        this.remove = new HashMap<>();
        this.core = core;
    }

    public void openChooseGUI(Player p) {
        Inventory inv = GUI.getFullHalfSized("Choose Security Level");
        ItemStack pri = Materials.getSimpleItem("&8Private Notes", Material.BEDROCK, "&7See all of your private notes.");
        ItemStack pub = Materials.getSimpleItem("&8Public Notes", Material.GLASS, "&7See all the public notes.");
        inv.setItem(11, pri);
        inv.setItem(15, pub);
        p.openInventory(inv);
    }

    public void openAddChoose(Player p, String name) {
        this.add.remove(p);
        this.add.put(p, name);
        Inventory inv = GUI.getFullHalfSized("Security Level");

        ItemStack pri = Materials.getSimpleItem("&8Private Notes", Material.BEDROCK, "&7See all of your private notes.");
        ItemStack pub = Materials.getSimpleItem("&8Public Notes", Material.GLASS, "&7See all the public notes.");

        inv.setItem(11, pri);
        inv.setItem(15, pub);

        p.openInventory(inv);
    }

    public void openPrivateNotes(Player p) {
        Inventory inv = GUI.getBordersFullSized("Private Notes");
        for (Note note : Note.getNotes()) {
            if (note.getCreator().equalsIgnoreCase(p.getName()) && note.getSecurity() == Note.Security.PRIVATE) {
                if (note.getCreator().equalsIgnoreCase(p.getName())) {
                    ItemStack item = note.getItem();
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();
                    lore.add(c("&7Press &bQ &7to remove this note"));
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    continue;
                }
                inv.addItem(note.getItem());
            }
        }
        p.openInventory(inv);
    }

    public void openPublicNotes(Player p) {
        Inventory inv = GUI.getBordersFullSized("Public Notes");
        for (Note note : Note.getNotes()) {
            if (note.getSecurity() == Note.Security.PUBLIC) {
                if (note.getCreator().equalsIgnoreCase(p.getName())) {
                    ItemStack item = note.getItem();
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();
                    lore.add(c("&7Press &bRight Click &7to remove this note"));
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    inv.addItem(item);
                    continue;
                }
                inv.addItem(note.getItem());
            }
        }
        p.openInventory(inv);
    }

    public void openConfirm(Player p) {
        Inventory inv = GUI.getFullHalfSized("Are you sure?");

        inv.setItem(11, Materials.getSimpleItem("&aYes.", Material.LIME_WOOL));
        inv.setItem(15, Materials.getSimpleItem("&cNo.", Material.RED_WOOL));

        p.openInventory(inv);
    }


    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equalsIgnoreCase("Choose Security Level")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    e.getWhoClicked().closeInventory();
                }

                if (meta.getDisplayName().equalsIgnoreCase(c("&8Private Notes"))) {
                    openPrivateNotes((Player) e.getWhoClicked());
                }

                if (meta.getDisplayName().equalsIgnoreCase(c("&8Public Notes"))) {
                    openPublicNotes((Player) e.getWhoClicked());
                }
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Private Notes") || e.getView().getTitle().equalsIgnoreCase("Public Notes")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    openChooseGUI((Player) e.getWhoClicked());
                }

                if (meta.hasLore()) {
                    Note note = Note.getByItem(e.getCurrentItem());
                    if (e.isLeftClick()) {
                        e.getWhoClicked().closeInventory();
                        preview((Player) e.getWhoClicked(), note);
                    }
                    if (e.isRightClick() && note.getCreator().equalsIgnoreCase(e.getWhoClicked().getName())) {
                        this.remove.put((Player) e.getWhoClicked(), note);
                        openConfirm((Player) e.getWhoClicked());
                    }
                }
            }
        }
        if (e.getView().getTitle().startsWith("Security Level")) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null && e.getCurrentItem().hasItemMeta()) {
                ItemStack stack = e.getCurrentItem();
                ItemMeta meta = stack.getItemMeta();

                if (meta.getDisplayName().equalsIgnoreCase(c("&cClose"))) {
                    this.add.remove(e.getWhoClicked());
                    e.getWhoClicked().closeInventory();
                }

                if (meta.getDisplayName().equalsIgnoreCase(c("&8Private Notes"))) {
                    Note note = new Note(this.add.get(e.getWhoClicked()), e.getWhoClicked().getLocation(), e.getWhoClicked().getName(), Note.Security.PRIVATE, Note.getNextAvailableID());
                    note.save();
                    this.add.remove(e.getWhoClicked());
                    openPrivateNotes((Player) e.getWhoClicked());
                }

                if (meta.getDisplayName().equalsIgnoreCase(c("&8Public Notes"))) {
                    Note note = new Note(this.add.get(e.getWhoClicked()), e.getWhoClicked().getLocation(), e.getWhoClicked().getName(), Note.Security.PUBLIC, Note.getNextAvailableID());
                    note.save();
                    this.add.remove(e.getWhoClicked());
                    openPublicNotes((Player) e.getWhoClicked());
                }
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Are you sure?")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.LIME_WOOL) {
                this.remove.get(e.getWhoClicked()).remove();
                if (this.remove.get(e.getWhoClicked()).getSecurity() == Note.Security.PRIVATE) {
                    openPrivateNotes((Player) e.getWhoClicked());
                } else {
                    openPublicNotes((Player) e.getWhoClicked());
                }
                this.remove.remove(e.getWhoClicked());
            } else if (e.getCurrentItem().getType() == Material.RED_WOOL) {
                if (this.remove.get(e.getWhoClicked()).getSecurity() == Note.Security.PRIVATE) {
                    openPrivateNotes((Player) e.getWhoClicked());
                } else {
                    openPublicNotes((Player) e.getWhoClicked());
                }
                this.remove.remove(e.getWhoClicked());
            }
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (e.getView().getTitle().startsWith("Choose Security Level for ")) {
            this.add.remove(e.getPlayer());
        }
        if (e.getView().getTitle().equalsIgnoreCase("Are you sure?")) {
            this.remove.remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (config.contains("" + e.getPlayer().getUniqueId() + ".loglocation")) {
            e.getPlayer().teleport(config.getLocation("" + e.getPlayer().getUniqueId() + ".loglocation"));
            config.set("" + e.getPlayer().getUniqueId() + ".loglocation", null);
            configHandler.savePlayerConfig();
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        previewing.remove(e.getPlayer());
    }

    public static List<Player> previewing = new ArrayList<>();

    public void preview(Player p, Note note) {
        config.set("" + p.getUniqueId() + ".loglocation", p.getLocation());
        configHandler.savePlayerConfig();
        p.setGameMode(GameMode.SPECTATOR);
        Location loc = new Location(Bukkit.getWorld(note.getWorld()), note.getX(), note.getY(), note.getZ());
        p.teleport(loc);
        previewing.add(p);
    }

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {
        if (e.isSneaking() && previewing.contains(e.getPlayer())) {
            e.getPlayer().teleport(config.getLocation("" + e.getPlayer().getUniqueId() + ".loglocation"));
            e.getPlayer().setGameMode(GameMode.SURVIVAL);
            config.set("" + e.getPlayer().getUniqueId() + ".loglocation", null);
            configHandler.savePlayerConfig();
            previewing.remove(e.getPlayer());
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getTo().getX() == e.getFrom().getX() && e.getTo().getY() == e.getFrom().getY() && e.getTo().getZ() == e.getFrom().getZ())
            return;
        if (previewing.contains(e.getPlayer())) {
            e.setCancelled(true);
        }
    }

    private String c(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}


