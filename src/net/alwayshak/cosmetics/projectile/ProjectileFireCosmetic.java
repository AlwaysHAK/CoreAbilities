package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileFireCosmetic
        extends Cosmetic {
    public ProjectileFireCosmetic() {
        super("Fire Trail", "Make an absolutely fire arrow", Category.ARROW, Material.FLINT_AND_STEEL, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FLAME, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


