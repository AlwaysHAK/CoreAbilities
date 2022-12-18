package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileWitchTrail
        extends Cosmetic {
    public ProjectileWitchTrail() {
        super("Ender", "Are you a enderman?", Category.ARROW, Material.ENDER_PEARL, Rarity.EPIC);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SPELL_WITCH, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


