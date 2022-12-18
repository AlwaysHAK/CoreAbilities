package net.alwayshak.cosmetics.feet;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;


public class FeetSmokeCosmetic
        extends Cosmetic {
    public FeetSmokeCosmetic() {
        super("Smoke Walk", "Gives you a smoke trail", Category.FEET, Material.CAMPFIRE, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.CLOUD, loc.getX(), loc.getY(), loc.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
    }


    public void summonCircle(Location location, double size) {
        for (int d = 0; d <= 90; d++) {
            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            particleLoc.setX(location.getX() + Math.cos(d) * size);
            particleLoc.setZ(location.getZ() + Math.sin(d) * size);

            location.getWorld().spawnParticle(Particle.CLOUD, particleLoc.getX(), particleLoc.getY(), particleLoc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
        }
    }
}


