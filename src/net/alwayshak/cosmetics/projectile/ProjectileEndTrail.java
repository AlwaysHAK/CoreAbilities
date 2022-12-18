package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileEndTrail
        extends Cosmetic {
    public ProjectileEndTrail() {
        super("Ender Trail", "Is it snow or end?", Category.ARROW, Material.END_ROD, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.END_ROD, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


