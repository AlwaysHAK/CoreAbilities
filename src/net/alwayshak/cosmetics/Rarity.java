package net.alwayshak.cosmetics;

import org.bukkit.ChatColor;
import org.bukkit.Material;

public enum Rarity {
    UNCOMMON("&8&lUNCOMMON", Material.BROWN_STAINED_GLASS_PANE, Material.GRAY_STAINED_GLASS_PANE),
    COMMON("&7&lCOMMON", Material.GRAY_STAINED_GLASS_PANE, Material.BLACK_STAINED_GLASS_PANE),
    RARE("&9&lRARE", Material.LIGHT_BLUE_STAINED_GLASS_PANE, Material.BLUE_STAINED_GLASS_PANE),
    EPIC("&5&lEPIC", Material.MAGENTA_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE),
    LEGENDARY("&6&lLEGENDARY", Material.YELLOW_STAINED_GLASS_PANE, Material.ORANGE_STAINED_GLASS_PANE),
    LIMITED("&c&lLIMITED", Material.RED_STAINED_GLASS_PANE, Material.WHITE_STAINED_GLASS_PANE),
    SPECIAL("&d&lSPECIAL", Material.PINK_STAINED_GLASS_PANE, Material.PURPLE_STAINED_GLASS_PANE);

    private final String name;
    private final Material mat1;
    private final Material mat2;

    Rarity(String name, Material mat1, Material mat2) {
        this.name = ChatColor.translateAlternateColorCodes('&', name);
        this.mat1 = mat1;
        this.mat2 = mat2;
    }

    public String getName() {
        return this.name;
    }

    public Material getMat1() {
        return this.mat1;
    }

    public Material getMat2() {
        return this.mat2;
    }
}


