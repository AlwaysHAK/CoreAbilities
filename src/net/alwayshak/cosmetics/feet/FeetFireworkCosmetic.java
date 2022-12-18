package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetFireworkCosmetic
        extends Cosmetic {
    public FeetFireworkCosmetic() {
        super("Firework Walk", "Watch your feet!", Category.FEET, Material.FIREWORK_ROCKET, Rarity.LIMITED);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY(), loc.getZ(), 100, 0.1D, 0.1D, 0.1D, 0.0D);
    }
}


