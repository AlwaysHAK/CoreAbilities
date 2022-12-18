package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;


public class HeadHaloCosmetic
        extends Cosmetic {
    public HeadHaloCosmetic() {
        super("Angel Halo", "Your a good person...", Category.HEAD, Material.NETHER_STAR, Rarity.LEGENDARY);
    }

    public void onActivate(Location loc) {
        genCircle(loc, 0.75F);
    }

    private void genCircle(Location location, float radius) {
        for (double t = 0.0D; t < 50.0D; t += 0.5D) {
            float x = radius * (float) Math.sin(t);
            float z = radius * (float) Math.cos(t);
            location.getWorld().spawnParticle(Particle.END_ROD, location.getX() + x, location.getY(), location.getZ() + z, 0, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }
}


