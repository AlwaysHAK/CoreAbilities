package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetTotemCosmetic
        extends Cosmetic {
    public FeetTotemCosmetic() {
        super("Totem Trail", "Is it death?", Category.FEET, Material.TOTEM_OF_UNDYING, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.TOTEM, loc.getX(), loc.getY(), loc.getZ(), 15, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


