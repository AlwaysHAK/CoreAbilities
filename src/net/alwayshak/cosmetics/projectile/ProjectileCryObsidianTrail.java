package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileCryObsidianTrail
        extends Cosmetic {
    public ProjectileCryObsidianTrail() {
        super("Crying Obsidian Trail", "The Purple Cry", Category.ARROW, Material.CRYING_OBSIDIAN, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.DRIPPING_OBSIDIAN_TEAR, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


