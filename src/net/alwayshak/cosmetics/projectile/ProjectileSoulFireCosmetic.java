package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileSoulFireCosmetic
        extends Cosmetic {
    public ProjectileSoulFireCosmetic() {
        super("Fire Fall Trail", "Something like flame?", Category.ARROW, Material.SOUL_SOIL, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


