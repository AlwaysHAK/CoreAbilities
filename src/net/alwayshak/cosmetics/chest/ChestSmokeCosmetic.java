package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestSmokeCosmetic
        extends Cosmetic {
    public ChestSmokeCosmetic() {
        super("Smoke Trail", "Dont catch on fire!", Category.CHEST, Material.CAMPFIRE, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


