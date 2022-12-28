package net.alwayshak.cosmetics.hit;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class HitBubblesCosmetic extends Cosmetic {

    public HitBubblesCosmetic() {
        super("Bubbles", "Blup", Category.DAMAGE, Material.WATER_BUCKET, Rarity.COMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.BUBBLE_POP, loc.getX(), loc.getY() + 2.25D, loc.getZ(), 0, 2.0D, 0.0D, 0.0D, 0.0D);
        loc.getWorld().spawnParticle(Particle.WATER_SPLASH, loc.getX(), loc.getY() + 2.25D, loc.getZ(), 0, 1.0D, 0.0D, 0.0D, 0.0D);
        loc.getWorld().spawnParticle(Particle.WATER_DROP, loc.getX(), loc.getY() + 2.25D, loc.getZ(), 0, 1.0D, 0.0D, 0.0D, 0.0D);
    }

}
