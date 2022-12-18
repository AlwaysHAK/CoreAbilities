package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetCryObsidianCosmetic
        extends Cosmetic {
    public FeetCryObsidianCosmetic() {
        super("Purple Feet", "Thats a lot of purple", Category.FEET, Material.CRYING_OBSIDIAN, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_OBSIDIAN_TEAR, loc.getX(), loc.getY(), loc.getZ(), 15, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


