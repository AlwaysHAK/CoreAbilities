package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadRainCosmetic
        extends Cosmetic {
    public HeadRainCosmetic() {
        super("Rain Cloud", "A rainy day again", Category.HEAD, Material.WATER_BUCKET, Rarity.LEGENDARY);
    }

    public void onActivate(Location loc) {
        loc.add(0.0D, 1.3D, 0.0D);
        loc.getWorld().spawnParticle(Particle.REDSTONE, loc.getX(), loc.getY(), loc.getZ(), 100, 0.5D, 0.25D, 0.5D, 0.0D, new Particle.DustOptions(Color.WHITE, 1.0F));
        loc.getWorld().spawnParticle(Particle.FALLING_WATER, loc.getX(), loc.getY(), loc.getZ(), 10, 0.5D, 0.1D, 0.5D, 0.0D);
    }
}


