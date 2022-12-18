package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileWaxOnTrail
        extends Cosmetic {
    public ProjectileWaxOnTrail() {
        super("Wax On Trail", "The waxer", Category.ARROW, Material.WAXED_COPPER_BLOCK, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.WAX_ON, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


