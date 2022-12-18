package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileStarCosmetic
        extends Cosmetic {
    public ProjectileStarCosmetic() {
        super("Star Trail", "Let a star follow your projectile", Category.ARROW, Material.NETHER_STAR, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


