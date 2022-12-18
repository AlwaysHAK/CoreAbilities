package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestCryObsidianCosmetic
        extends Cosmetic {
    public ChestCryObsidianCosmetic() {
        super("Purple Obsidian", "I am blue ehh purple", Category.CHEST, Material.CRYING_OBSIDIAN, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


