package net.alwayshak.cosmetics.elytra;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ElytraHeartCosmetic
        extends Cosmetic {
    public ElytraHeartCosmetic() {
        super("Love Plane", "Poop out love", Category.ELYTRA, Material.ELYTRA, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.HEART, loc.getX(), loc.getY(), loc.getZ(), 1, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


