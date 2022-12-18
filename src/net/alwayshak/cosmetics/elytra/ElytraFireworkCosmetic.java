package net.alwayshak.cosmetics.elytra;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ElytraFireworkCosmetic
        extends Cosmetic {
    public ElytraFireworkCosmetic() {
        super("Fireworks", "Fly with a bang!", Category.ELYTRA, Material.FIREWORK_ROCKET, Rarity.LIMITED);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY(), loc.getZ(), 1, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


