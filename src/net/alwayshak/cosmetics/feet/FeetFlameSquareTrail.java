package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class FeetFlameSquareTrail
        extends Cosmetic {
    public FeetFlameSquareTrail() {
        super("Fire Power", "This is my no no square", Category.FEET, Material.BLAZE_ROD, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        Location loc1 = loc.clone().add(1.0D, 0.0D, 1.0D);
        Location loc2 = loc.clone().add(-1.0D, 0.0D, 1.0D);
        Location loc3 = loc.clone().add(-1.0D, 0.0D, -1.0D);
        Location loc4 = loc.clone().add(1.0D, 0.0D, -1.0D);
        loc.getWorld().spawnParticle(Particle.FLAME, loc1.getX(), loc.getY(), loc1.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
        loc.getWorld().spawnParticle(Particle.FLAME, loc2.getX(), loc.getY(), loc2.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
        loc.getWorld().spawnParticle(Particle.FLAME, loc3.getX(), loc.getY(), loc3.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
        loc.getWorld().spawnParticle(Particle.FLAME, loc4.getX(), loc.getY(), loc4.getZ(), 0, 0.0D, 0.0D, 0.0D, 10.0D);
    }
}


