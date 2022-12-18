package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetToxicCosmetic
        extends Cosmetic {
    public FeetToxicCosmetic() {
        super("Toxic Feet", "Do you still have you foot?", Category.FEET, Material.SLIME_BLOCK, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SNEEZE, loc.getX(), loc.getY(), loc.getZ(), 15, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


