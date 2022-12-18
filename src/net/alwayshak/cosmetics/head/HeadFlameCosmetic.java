package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadFlameCosmetic
        extends Cosmetic {
    public HeadFlameCosmetic() {
        super("Devil Rings", "The Devil is knocking...", Category.HEAD, Material.BLAZE_ROD, Rarity.RARE);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FLAME, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


