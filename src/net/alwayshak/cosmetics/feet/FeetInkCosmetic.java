package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;


public class FeetInkCosmetic
        extends Cosmetic {
    public FeetInkCosmetic() {
        super("Ink Feet", "You spilled it...", Category.FEET, Material.INK_SAC, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SQUID_INK, loc.getX(), loc.getY(), loc.getZ(), 15, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


