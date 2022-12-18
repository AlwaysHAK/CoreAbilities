package net.alwayshak.cosmetics.chest;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ChestFireworkCosmetic
        extends Cosmetic {
    public ChestFireworkCosmetic() {
        super("Firework Trail", "Fire power!", Category.CHEST, Material.FIREWORK_ROCKET, Rarity.LIMITED);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


