package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileLavaCosmetic
        extends Cosmetic {
    public ProjectileLavaCosmetic() {
        super("Lava Trail", "Make your arrows more lavaery...", Category.ARROW, Material.LAVA_BUCKET, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_LAVA, loc.getX(), loc.getY(), loc.getZ(), 5, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


