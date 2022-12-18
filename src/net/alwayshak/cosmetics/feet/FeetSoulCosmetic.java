package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetSoulCosmetic
        extends Cosmetic {
    public FeetSoulCosmetic() {
        super("Soul Walk", "The walk of the Demons", Category.FEET, Material.SOUL_SOIL, Rarity.LEGENDARY);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SOUL, loc.getX(), loc.getY(), loc.getZ(), 10, 0.1D, 0.1D, 0.1D, 0.0D);
        loc.getWorld().spawnParticle(Particle.CRIT, loc.getX(), loc.getY(), loc.getZ(), 100, 0.1D, 0.1D, 0.1D, 0.0D);
        loc.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, loc.getX(), loc.getY(), loc.getZ(), 100, 0.1D, 0.1D, 0.1D, 0.0D);
    }
}


