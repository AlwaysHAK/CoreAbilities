package net.alwayshak.cosmetics.projectile;

import net.alwayshak.cosmetics.Category;
import net.alwayshak.cosmetics.Cosmetic;
import net.alwayshak.cosmetics.Rarity;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;

public class ProjectileNoteTrail
        extends Cosmetic {
    public ProjectileNoteTrail() {
        super("Music Shooter", "The music everywhere!", Category.ARROW, Material.NOTE_BLOCK, Rarity.EPIC);
    }

    public void onActivate(Location loc) {
        loc.getWorld().spawnParticle(Particle.NOTE, loc, 1);
    }
}


