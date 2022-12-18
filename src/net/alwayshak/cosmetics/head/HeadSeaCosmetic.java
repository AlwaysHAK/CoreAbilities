package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadSeaCosmetic
        extends Cosmetic {
    public HeadSeaCosmetic() {
        super("Poseidon", "The bright one", Category.HEAD, Material.GLOW_INK_SAC, Rarity.RARE);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.GLOW, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


