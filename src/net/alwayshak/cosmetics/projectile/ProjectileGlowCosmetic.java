package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileGlowCosmetic
        extends Cosmetic {
    public ProjectileGlowCosmetic() {
        super("Glow Trail", "Everyone knows where you are", Category.ARROW, Material.GLOW_INK_SAC, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.GLOW, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


