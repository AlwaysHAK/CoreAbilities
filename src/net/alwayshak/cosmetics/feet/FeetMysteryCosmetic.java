package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetMysteryCosmetic
        extends Cosmetic {
    public FeetMysteryCosmetic() {
        super("Mystery Trail", "Very mysterious....", Category.FEET, Material.ENCHANTING_TABLE, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        for (int i = 0; i < 10; i++) {
            loc.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, loc.getX(), loc.getY(), loc.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.5D);
        }
        loc.getWorld().spawnParticle(Particle.SMOKE_NORMAL, loc.getX(), loc.getY(), loc.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.1D);
    }
}


