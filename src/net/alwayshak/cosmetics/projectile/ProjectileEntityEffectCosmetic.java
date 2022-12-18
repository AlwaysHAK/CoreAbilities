package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;


public class ProjectileEntityEffectCosmetic
        extends Cosmetic {
    public ProjectileEntityEffectCosmetic() {
        super("Black effect Trail", "A lot of black wirls", Category.ARROW, Material.POTION, Rarity.UNCOMMON);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.SPELL_MOB_AMBIENT, loc.getX(), loc.getY(), loc.getZ(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
    }
}


