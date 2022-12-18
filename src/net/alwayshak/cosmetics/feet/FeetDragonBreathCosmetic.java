package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetDragonBreathCosmetic
        extends Cosmetic {
    public FeetDragonBreathCosmetic() {
        super("Dragon Breath", "He needs a mint", Category.FEET, Material.DRAGON_BREATH, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.DRAGON_BREATH, loc.getX(), loc.getY(), loc.getZ(), 15, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}


