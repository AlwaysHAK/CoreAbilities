package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadFallingDripWaterCosmetic
        extends Cosmetic {
    public HeadFallingDripWaterCosmetic() {
        super("Dripping Water", "Water shower", Category.HEAD, Material.CAULDRON, Rarity.UNCOMMON);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.DRIP_WATER, loc, 1);
    }
}


