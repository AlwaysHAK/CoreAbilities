package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadFallingLavaCosmetic
        extends Cosmetic {
    public HeadFallingLavaCosmetic() {
        super("Falling Lava", "Close Hot shower", Category.HEAD, Material.LAVA_BUCKET, Rarity.COMMON);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FALLING_LAVA, loc, 1);
    }
}


