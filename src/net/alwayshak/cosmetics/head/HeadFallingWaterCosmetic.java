package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadFallingWaterCosmetic
        extends Cosmetic {
    public HeadFallingWaterCosmetic() {
        super("Falling Water", "Close Cold shower", Category.HEAD, Material.WATER_BUCKET, Rarity.COMMON);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_WATER, loc, 1);
    }
}


