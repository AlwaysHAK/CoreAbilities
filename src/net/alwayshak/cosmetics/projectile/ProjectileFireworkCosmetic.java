package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileFireworkCosmetic
        extends Cosmetic {
    public ProjectileFireworkCosmetic() {
        super("Firework Trail", "Happy New Year!", Category.ARROW, Material.FIREWORK_ROCKET, Rarity.LIMITED);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY(), loc.getZ(), 10, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


