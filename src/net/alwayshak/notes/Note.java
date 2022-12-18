package net.alwayshak.notes;

import net.alwayshak.config.ConfigHandler;
import net.alwayshak.util.Materials;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private static final ConfigHandler configHandler = ConfigHandler.getInstance();
    private static final FileConfiguration config = ConfigHandler.getInstance().getNotes();
    private final String name;
    private final String creator;
    private final Security security;
    private final String world;

    public static void addNote(Player writer, String name, NotesGUI gui) {
        gui.openAddChoose(writer, name);
    }

    private final int x;
    private final int y;
    private final int z;
    private int id;

    public static Note getByItem(ItemStack stack) {
        int id = Integer.valueOf(ChatColor.stripColor(stack.getItemMeta().getLore().get(3)).substring(4)).intValue();
        return getByID(id);
    }

    public static Note getByID(int id) {
        if (config.contains(String.valueOf(id))) {
            String creator = config.getString("" + id + ".creator");
            Security security = Security.fromName(config.getString("" + id + ".security"));
            String name = config.getString("" + id + ".name");
            String world = config.getString("" + id + ".world");
            int x = config.getInt("" + id + ".x");
            int y = config.getInt("" + id + ".y");
            int z = config.getInt("" + id + ".z");
            return new Note(name, x, y, z, Bukkit.getWorld(world), creator, security, id);
        }
        return null;
    }

    public static List<Note> getNotes() {
        List<Note> notes = new ArrayList<>();
        for (String id : config.getKeys(false)) {
            int i = Integer.valueOf(id).intValue();
            notes.add(getByID(i));
        }
        return notes;
    }

    public static int getNextAvailableID() {
        int highest = 0;
        for (String str : config.getKeys(false)) {
            int i = Integer.valueOf(str).intValue();
            if (i > highest) {
                highest = i;
            }
        }
        return highest + 1;
    }


    public Note(String name, Location loc, Player p, Security security, int id) {
        this.name = name;
        this.security = security;
        this.world = loc.getWorld().getName();
        this.x = loc.getBlockX();
        this.y = loc.getBlockY();
        this.z = loc.getBlockZ();
        this.creator = p.getName();
    }

    public Note(String name, Location loc, String creator, Security security, int id) {
        this.name = name;
        this.security = security;
        this.world = loc.getWorld().getName();
        this.x = loc.getBlockX();
        this.y = loc.getBlockY();
        this.z = loc.getBlockZ();
        this.creator = creator;
        this.id = id;
    }

    public Note(String name, int x, int y, int z, World world, Player p, Security security, int id) {
        this.name = name;
        this.security = security;
        this.world = world.getName();
        this.x = x;
        this.y = y;
        this.z = z;
        this.creator = p.getName();
        this.id = id;
    }

    public Note(String name, int x, int y, int z, World world, String creator, Security security, int id) {
        this.name = name;
        this.security = security;
        this.world = world.getName();
        this.x = x;
        this.y = y;
        this.z = z;
        this.creator = creator;
        this.id = id;
    }

    public void save() {
        config.set("" + this.id + ".name", this.name);
        config.set("" + this.id + ".creator", this.creator);
        config.set("" + this.id + ".security", this.security.name());
        config.set("" + this.id + ".world", this.world);
        config.set("" + this.id + ".x", Integer.valueOf(this.x));
        config.set("" + this.id + ".y", Integer.valueOf(this.y));
        config.set("" + this.id + ".z", Integer.valueOf(this.z));
        configHandler.saveNotesConfig();
    }

    public void remove() {
        config.set(String.valueOf(this.id), null);
        config.set("" + this.id + ".name", null);
        config.set("" + this.id + ".creator", null);
        config.set("" + this.id + ".security", null);
        config.set("" + this.id + ".world", null);
        config.set("" + this.id + ".x", null);
        config.set("" + this.id + ".y", null);
        config.set("" + this.id + ".z", null);
        configHandler.saveNotesConfig();
    }

    public String getName() {
        return this.name;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getWorld() {
        return this.world;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public Security getSecurity() {
        return this.security;
    }

    public ItemStack getItem() {
        return Materials.getSimpleItem("&8" + this.name, Material.PAPER, "&7X: &f" + this.x + " &7Y: &f" + this.y + " &7Z: &f" + this.z, "&7World: &f" + this.world, "&7Creator: &f" + this.creator, "&7&oID: &7" + this.id, " ", "&bLeft Click &7to preview...");
    }

    public enum Security {
        PRIVATE,
        PUBLIC;

        public static Security fromName(String name) {
            if (name.equalsIgnoreCase("PRIVATE"))
                return PRIVATE;
            if (name.equalsIgnoreCase("PUBLIC"))
                return PUBLIC;
            return null;
        }
    }
}


