package net.alwayshak.cosmetics.head;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HeadFallingDripLavaCosmetic
        extends Cosmetic {
    public HeadFallingDripLavaCosmetic() {
        super("Dripping Lava", "Hot shower", Category.HEAD, Material.POINTED_DRIPSTONE, Rarity.UNCOMMON);
        setSpin(true);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.DRIP_LAVA, loc, 1);
    }
}


