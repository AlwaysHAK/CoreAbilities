package net.alwayshak.cosmetics.death;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class KillExplosionCosmetic extends Cosmetic {
    public KillExplosionCosmetic() {
        super("Explosion", "Go out with a BOOM!", Category.KILL, Material.TNT, Rarity.RARE);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc.getX(), loc.getY(), loc.getZ(), 1, 0.3D, 0.0D, 0.3D, 0.0D);
    }
}
