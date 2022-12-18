package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileWaterCosmetic
        extends Cosmetic {
    public ProjectileWaterCosmetic() {
        super("Water Trail", "Make your arrows more watery...", Category.ARROW, Material.WATER_BUCKET, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_WATER, loc.getX(), loc.getY(), loc.getZ(), 5, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


