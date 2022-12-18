package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileSporeBlossemTrail
        extends Cosmetic {
    public ProjectileSporeBlossemTrail() {
        super("Spore Blossem Trail", "Is it XP?", Category.ARROW, Material.SPORE_BLOSSOM, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_SPORE_BLOSSOM, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


